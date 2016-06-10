package Structure.Requestable;

import Structure.Selectables.Field;
import Structure.Selectables.StringLitteral;

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

    public final StringLitteral ALL = new StringLitteral(tableName + ".*");

    public Table(String tableName) {
        this.tableName = tableName;
    }

    public Table(String tableName, String alias) {
        this.tableName = tableName;
        this.alias = alias;
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
}
