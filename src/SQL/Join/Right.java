package SQL.Join;

import SQL.Join.Outer;
import SQL.SQLQuerry;
import Structure.Requestable.Table;

/**
 * Created by gasto on 12/06/2016.
 */
public class Right extends Outer {

    public Right(SQLQuerry.SQLQuerryBuilder sqlQuerryBuilder, Table t) {
        super(sqlQuerryBuilder, t);
    }

    @Override
    public String toSql() {
        return "RIGHT " + super.toSql();
    }
}
