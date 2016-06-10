package Structure.Expressions;

import Structure.Requestable.Table;

/**
 * Created by gasto on 10/06/2016.
 */

public class BinaryExpression implements IExpression {

    protected IExpression left;
    protected IExpression right;

    public BinaryExpression(IExpression left, IExpression right) {
        this.left = left;
        this.right = right;
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
