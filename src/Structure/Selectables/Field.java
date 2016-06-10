package Structure.Selectables;

import Structure.Requestable.Table;

/**
 * Created by gasto on 09/06/2016.
 */
public class Field implements Selectable {

    protected String fieldName;

    public Field(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toSql() {
        return fieldName;
    }

    @Override
    public Table getRelatedTable() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Field field = (Field) o;

        return fieldName != null ? fieldName.equals(field.fieldName) : field.fieldName == null;

    }

    @Override
    public int hashCode() {
        return fieldName != null ? fieldName.hashCode() : 0;
    }
}
