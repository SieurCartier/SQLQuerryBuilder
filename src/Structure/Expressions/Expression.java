package Structure.Expressions;

import Structure.Requestable.Table;

/**
 * Created by gasto on 10/06/2016.
 */
public abstract class Expression implements IExpression {

    @Override
    public Table getRelatedTable() {
        return null;
    }

    @Override
    public abstract String toSql();
}
