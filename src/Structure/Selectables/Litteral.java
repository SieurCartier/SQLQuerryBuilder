package Structure.Selectables;

import Structure.Expressions.IExpression;
import Structure.Requestable.Requestable;

import java.util.Set;

/**
 * Created by gasto on 09/06/2016.
 */
public class Litteral<T> implements IExpression {

    protected T value;

    public Litteral(T value) {
        this.value = value;
    }

    @Override
    public String toSql() {
        return value.toString();
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
