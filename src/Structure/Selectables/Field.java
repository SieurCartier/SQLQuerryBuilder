package Structure.Selectables;

import Structure.Expressions.IExpression;
import Structure.Requestable.Requestable;
import Structure.Requestable.Table;

import java.util.Set;

/**
 * Created by gasto on 09/06/2016.
 */
public class Field implements Selectable, IExpression {

    protected String fieldName;
    protected int type;

    public Field(String fieldName, int type) {
        this.fieldName = fieldName;
        this.type = type;
    }

    @Override
    public String toSql() {
        return fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public int getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Field field = (Field) o;

        if (type != field.type) return false;
        return fieldName != null ? fieldName.equals(field.fieldName) : field.fieldName == null;

    }

    @Override
    public int hashCode() {
        int result = fieldName != null ? fieldName.hashCode() : 0;
        result = 31 * result + type;
        return result;
    }

    @Override
    public Set<Requestable> getRequired() {
        return null;
    }

    @Override
    public Set<Requestable> getConcernedTables() {
        return null;
    }
}
