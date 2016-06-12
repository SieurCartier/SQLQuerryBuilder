package SQL.Join;

import SQL.SQLQuerry;
import Structure.Expressions.BinaryExpression;
import Structure.Requestable.Table;
import Structure.Selectables.FullField;

/**
 * Created by gasto on 12/06/2016.
 */
public abstract class Conditionned extends Join {

    protected SQLQuerry.SQLQuerryBuilder builder;

    protected Conditionned(SQLQuerry.SQLQuerryBuilder sqlQuerryBuilder, Table t) {
        super(t);
        this.builder = sqlQuerryBuilder;
    }

    public SQLQuerry.SQLQuerryBuilder on(BinaryExpression<FullField> e) {
        builder.getJoins().get(concernedTable).add(e);
        return builder;
    }
}
