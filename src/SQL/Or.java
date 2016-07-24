package SQL;

import Structure.Expressions.IExpression;

/**
 * Created by gasto on 17/07/2016.
 */
public class Or extends Where {

    public Or(SQLQuerry.SQLQuerryBuilder builder, IExpression e) {
        super(builder, e);
        sql = "OR ";
        other = null;
    }

    public Or(IExpression left, IExpression right) {
        super(null, left);
        sql = " OR ";
        other = right;
    }
}
