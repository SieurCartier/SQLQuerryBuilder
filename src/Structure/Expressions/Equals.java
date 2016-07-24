package Structure.Expressions;

/**
 * Created by gasto on 10/06/2016.
 */
public class Equals extends BinaryExpression {

    public Equals(IExpression left, IExpression right) {
        super(left, right);
        operator = " = ";
    }
}
