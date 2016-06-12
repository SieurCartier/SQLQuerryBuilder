package Structure.Expressions;

import Structure.Requestable.Table;

/**
 * Created by gasto on 10/06/2016.
 */

public class BinaryExpression<T> implements IExpression {

    protected IExpression<T> left;
    protected IExpression<T> right;

    public BinaryExpression(IExpression left, IExpression right) {
        this.left = left;
        this.right = right;
    }

    public IExpression<T> getLeft() {
        return left;
    }

    public IExpression<T> getRight() {
        return right;
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
