package SQL.Join;

import SQL.SQLQuerry;
import Structure.Requestable.Table;

/**
 * Created by gasto on 12/06/2016.
 */
public class Outer extends Conditionned {

    public Outer(SQLQuerry.SQLQuerryBuilder sqlQuerryBuilder, Table t) {
        super(sqlQuerryBuilder, t);
    }

    @Override
    public String toSql() {
        return "OUTER " + super.toSql();
    }
}
