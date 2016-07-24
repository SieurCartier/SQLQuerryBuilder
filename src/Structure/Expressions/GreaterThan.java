package Structure.Expressions;

import Structure.Selectables.CharLitteral;
import Structure.Selectables.NumberLitteral;
import Structure.Selectables.StringLitteral;

/**
 * Created by gasto on 10/06/2016.
 */
public class GreaterThan extends BinaryExpression {
    public <T> GreaterThan(IExpression<T> left, IExpression<T> right) {
        super(left, right);
        operator = " > ";
    }

    public GreaterThan(Number left, Number right) {
        this(new NumberLitteral(left), new NumberLitteral(right));
    }

    public GreaterThan(Number left, IExpression right) {
        this(new NumberLitteral(left), right);
    }

    public GreaterThan(IExpression left, Number right) {
        this(left, new NumberLitteral(right));
    }

    public GreaterThan(String left, String right) {
        this(new StringLitteral(left), new StringLitteral(right));
    }

    public GreaterThan(String left, IExpression right) {
        this(new StringLitteral(left), right);
    }

    public GreaterThan(IExpression left, String right) {
        this(left, new StringLitteral(right));
    }

    public GreaterThan(Character left, Character right) {
        this(new CharLitteral(left), new CharLitteral(right));
    }

    public GreaterThan(Character left, IExpression right) {
        this(new CharLitteral(left), right);
    }

    public GreaterThan(IExpression left, Character right) {
        this(left, new CharLitteral(right));
    }
}
