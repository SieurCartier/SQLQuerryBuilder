package SQL.Join;

import SQL.SQLQuerry;
import Structure.Requestable.Table;

/**
 * Created by gasto on 12/06/2016.
 */
public class Full extends Outer {
    public Full(SQLQuerry.SQLQuerryBuilder sqlQuerryBuilder, Table t) {
        super(sqlQuerryBuilder, t);
    }

    @Override
    public String toSql() {
        return "FULL " + super.toSql();
    }
}
