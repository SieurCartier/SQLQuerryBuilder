package Structure.Expressions;

import Structure.Expressions.IExpression;
import Structure.Requestable.Requestable;
import Structure.Selectables.CharLitteral;
import Structure.Selectables.FullField;
import Structure.Selectables.NumberLitteral;
import Structure.Selectables.StringLitteral;

import java.util.Set;

/**
 * Created by gasto on 17/07/2016.
 */
public class LessThan extends BinaryExpression {
    public <T> LessThan(IExpression<T> left, IExpression<T> right) {
        super(left, right);
        operator = " < ";
    }

    public LessThan(Number left, Number right) {
        this(new NumberLitteral(left), new NumberLitteral(right));
    }

    public LessThan(Number left, IExpression right) {
        this(new NumberLitteral(left), right);
    }

    public LessThan(IExpression left, Number right) {
        this(left, new NumberLitteral(right));
    }

    public LessThan(String left, String right) {
        this(new StringLitteral(left), new StringLitteral(right));
    }

    public LessThan(String left, IExpression right) {
        this(new StringLitteral(left), right);
    }

    public LessThan(IExpression left, String right) {
        this(left, new StringLitteral(right));
    }

    public LessThan(Character left, Character right) {
        this(new CharLitteral(left), new CharLitteral(right));
    }

    public LessThan(Character left, IExpression right) {
        this(new CharLitteral(left), right);
    }

    public LessThan(IExpression left, Character right) {
        this(left, new CharLitteral(right));
    }
}
