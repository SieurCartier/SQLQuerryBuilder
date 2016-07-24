package SQL;

import Structure.Expressions.IExpression;

/**
 * Created by gasto on 17/07/2016.
 */
public class And extends Where {

    public And(SQLQuerry.SQLQuerryBuilder builder, IExpression e) {
        super(builder, e);
        sql = "AND ";
    }

    public And(IExpression left, IExpression right) {
        super(null, left);
        sql = " AND ";
        other = right;
    }

    public And(SQLQuerry.SQLQuerryBuilder builder, And e) {
        super(builder, null);
        sql = "AND ";
    }

}
