package SQL;

import Structure.Expressions.IExpression;

/**
 * Created by gasto on 17/07/2016.
 */
public class Where extends SQLQuerry.SQLQuerryBuilder {

    protected SQLQuerry.SQLQuerryBuilder builder;
    protected IExpression expression;
    protected IExpression other;
    protected String sql;

    public Where(SQLQuerry.SQLQuerryBuilder builder, IExpression e) {
        super();
        this.builder = builder;
        this.expression = e;
        sql = "WHERE ";
    }

    String toSQL() {
        if (builder != null)
            return builder.toSQL() + sql + "(" + expression.toSql() + ")";

        return expression.toSql() + sql + other.toSql();
    }
}
