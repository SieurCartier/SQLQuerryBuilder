package Structure.Requestable;

import Structure.Selectables.Field;
import Structure.Selectables.FullField;
import Structure.Selectables.StringLitteral;
import Utils.Builder;
import Utils.InexistantFieldException;
import Utils.UnconsistentType;
import Utils.PrimaryKeyAlreadyExistsException;
import com.sun.istack.internal.NotNull;

import java.util.*;

/**
 * Created by gasto on 09/06/2016.
 */
public class Table implements Requestable {

    private String tableName;
    private String alias;
    private Field primaryKey;
    private Map<String, Field> fields = new Hashtable<>();
    private Map<Field, Set<Field>> foreignKeys = new Hashtable<>();

    public StringLitteral ALL;

    public Table(TableBuilder tableBuilder) {
        tableName = tableBuilder.tableName;
        alias = tableBuilder.alias;
        primaryKey = tableBuilder.primaryKey;
        fields = tableBuilder.fields;
        foreignKeys = tableBuilder.foreignKeys;

        ALL = new StringLitteral(tableName + ".*");
    }

    public String toSql() {
        return tableName + ((alias != null) ? " " + alias : "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Table table = (Table) o;

        return tableName != null ? tableName.equals(table.tableName) : table.tableName == null;
    }

    @Override
    public int hashCode() {
        return tableName != null ? tableName.hashCode() : 0;
    }

    public FullField getPrimaryKey() {
        return new FullField(this, primaryKey);
    }

    public FullField getField(String name) throws InexistantFieldException {
        FullField ret = null;
        try {
            ret = new FullField(this, fields.get(name));
        } catch (NullPointerException e) {
            throw new InexistantFieldException(name);
        }
        return ret;
    }

    public static class TableBuilder implements Builder<Table> {
        private String tableName;
        private String alias;
        private Field primaryKey;
        private Map<String, Field> fields = new Hashtable<>();
        private Map<Field, Set<Field>> foreignKeys = new Hashtable<>();


        public TableBuilder(String tableName) {
            this.tableName = tableName;
        }

        public TableBuilder alias(String alias) {
            this.alias = alias;
            return this;
        }

        @NotNull
        public TableBuilder setPrimaryKey(String fieldname, int type) throws PrimaryKeyAlreadyExistsException {
            return setPrimaryKey(new Field(fieldname, type));
        }

        @NotNull
        public TableBuilder setPrimaryKey(Field field) throws PrimaryKeyAlreadyExistsException {
            if (primaryKey != null)
                throw new PrimaryKeyAlreadyExistsException();

            if (!fields.containsKey(field.getFieldName()))
                fields.put(field.getFieldName(), field);

            primaryKey = field;
            return this;
        }

        @NotNull
        public TableBuilder addForeignKey(String fieldName, int type, FullField references) throws UnconsistentType {
            return addForeignKey(new Field(fieldName, type), references);
        }

        @NotNull
        public TableBuilder addForeignKey(Field field, FullField references) throws UnconsistentType {
            if (field.getType() != references.getType())
                throw new UnconsistentType(field, references);

            if (!fields.containsKey(field))
                fields.put(field.getFieldName(), field);

            if (!foreignKeys.containsKey(field))
                foreignKeys.put(field, new HashSet<>());

            foreignKeys.get(field).add(references);
            return this;
        }

        @NotNull
        public TableBuilder addField(String fieldname, int type) {
            return addField(new Field(fieldname, type));
        }

        @NotNull
        public TableBuilder addField(Field field) {
            fields.put(field.getFieldName(), field);
            return this;
        }

        @Override
        public Table build() {
            return new Table(this);
        }
    }
}
