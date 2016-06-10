package Structure.Requestable;

import Structure.Selectables.Field;
import Structure.Selectables.StringLitteral;
import Utils.Builder;
import Utils.PrimaryKeyAlreadyExistsException;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Created by gasto on 09/06/2016.
 */
public class Table implements Requestable {

    private String tableName;
    private String alias;
    private Field primaryKey;
    private Dictionary<String, Field> fields = new Hashtable<>();

    public StringLitteral ALL;

    public Table(TableBuilder tableBuilder) {
        tableName = tableBuilder.tableName;
        alias = tableBuilder.alias;
        primaryKey = tableBuilder.primaryKey;
        fields = tableBuilder.fields;
        ALL = new StringLitteral(tableName + ".*");
    }

    public String toSql() {
        return tableName;
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

    public Field getPrimaryKey() {
        return primaryKey;
    }

    public Field getField(String name) {
        return fields.get(name);
    }

    public void addField(String fieldName, int type) throws PrimaryKeyAlreadyExistsException {
        addField(fieldName, type, false);
    }

    public void addField(String fieldName, int type, boolean isPrimaryKey) throws PrimaryKeyAlreadyExistsException {
        addField(new Field(fieldName, type), isPrimaryKey);
    }

    public void addField(Field field) throws PrimaryKeyAlreadyExistsException {
        addField(field, false);
    }

    public void addField(Field field, boolean isPrimaryKey) throws PrimaryKeyAlreadyExistsException {
        if (isPrimaryKey) {
            if (!(primaryKey == null)) {
                primaryKey = field;
            } else {
                throw new PrimaryKeyAlreadyExistsException();
            }
        }
        fields.put(field.getFieldName(), field);
    }

    public static class TableBuilder implements Builder<Table> {

        private String tableName;
        private String alias;
        private Field primaryKey;
        private Dictionary<String, Field> fields = new Hashtable<>();

        public TableBuilder(String tableName) {
            this.tableName = tableName;
        }

        public TableBuilder addField(String fieldName, int type) throws PrimaryKeyAlreadyExistsException {
            return addField(fieldName, type, false);
        }

        public TableBuilder addField(String fieldName, int type, boolean isPrimaryKey) throws PrimaryKeyAlreadyExistsException {
            return addField(new Field(fieldName, type), isPrimaryKey);
        }

        public TableBuilder addField(Field field) throws PrimaryKeyAlreadyExistsException {
            return addField(field, false);
        }

        public TableBuilder addField(Field field, boolean isPrimaryKey) throws PrimaryKeyAlreadyExistsException {
            if (isPrimaryKey) {
                if (primaryKey == null) {
                    primaryKey = field;
                } else {
                    throw new PrimaryKeyAlreadyExistsException();
                }
            }
            fields.put(field.getFieldName(), field);
            return this;
        }

        @Override
        public Table build() {
            return new Table(this);
        }
    }
}
