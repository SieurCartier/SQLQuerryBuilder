package Structure.Expressions;

/**
 * Created by gasto on 10/06/2016.
 */
public class Equals extends Expression {

    private IExpression leftSide;
    private IExpression rightSide;

    public Equals(IExpression leftSide, IExpression rightSide) {
        super();
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    @Override
    public String toSql() {
        return leftSide.toSql() + " = " + rightSide.toSql();
    }
}
