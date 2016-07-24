package Structure.Expressions;

import Structure.Requestable.Requestable;
import Structure.Selectables.CharLitteral;
import Structure.Selectables.NumberLitteral;
import Structure.Selectables.StringLitteral;

import java.util.Set;

/**
 * Created by gasto on 10/06/2016.
 */

public class BinaryExpression<T> implements IExpression {

    protected IExpression<T> left;
    protected IExpression<T> right;
    protected String operator;

    public BinaryExpression(IExpression<T> left, IExpression<T> right) {
        this.left = left;
        this.right = right;
    }

    public BinaryExpression(Number left, Number right) {
        this(new NumberLitteral(left), new NumberLitteral(right));
    }

    public BinaryExpression(Number left, NumberLitteral right) {
        this(new NumberLitteral(left), right);
    }

    public BinaryExpression(NumberLitteral left, Number right) {
        this(left, new NumberLitteral(right));
    }

    public BinaryExpression(StringLitteral left, String right) {
        this(left, new StringLitteral(right));
    }

    public BinaryExpression(String left, StringLitteral right) {
        this(new StringLitteral(left), right);
    }

    public BinaryExpression(String left, String right) {
        this(new StringLitteral(left), new StringLitteral(right));
    }

    public BinaryExpression(char left, char right) {
        this(new CharLitteral(left), new CharLitteral(right));
    }

    public BinaryExpression(char left, CharLitteral right) {
        this(new CharLitteral(left), right);
    }

    public BinaryExpression(CharLitteral left, char right) {
        this(left, new CharLitteral(right));
    }

    public IExpression<T> getLeft() {
        return left;
    }

    public IExpression<T> getRight() {
        return right;
    }

    @Override
    public String toSql() {
        return left.toSql() + operator + right.toSql() + " ";
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
