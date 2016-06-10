package Structure.Expressions;

/**
 * Created by gasto on 10/06/2016.
 */
public class GreaterThan extends BinaryExpression {
    public GreaterThan(IExpression left, IExpression right) {
        super(left, right);
    }

    @Override
    public String toSql() {
        return left.toSql() + " > " + right.toSql();
    }
}
