package SQL;

import Structure.Expressions.BinaryExpression;
import Structure.Requestable.Table;
import Structure.Selectables.FullField;
import Utils.InvalidExpressionException;
import Utils.MissingTableException;

/**
 * Created by gasto on 12/06/2016.
 */
public abstract class Conditioned extends Join {

    protected Conditioned(SQLQuerry.SQLQuerryBuilder builder, Table t) {
        super(builder, t);
    }

    public On on(BinaryExpression<FullField> e) throws MissingTableException, InvalidExpressionException {
        return new On(this, e);
    }

}
