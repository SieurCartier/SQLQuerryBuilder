package Structure.Selectables;

import Structure.Expressions.IExpression;
import Structure.Requestable.Table;

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
        return null;
    }

    @Override
    public Table getRelatedTable() {
        return null;
    }
}
