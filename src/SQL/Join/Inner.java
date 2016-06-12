package SQL.Join;

import SQL.SQLQuerry;
import Structure.Requestable.Table;

/**
 * Created by gasto on 12/06/2016.
 */
public class Inner extends Conditionned {

    public Inner(SQLQuerry.SQLQuerryBuilder sqlQuerryBuilder, Table t) {
        super(sqlQuerryBuilder, t);
    }

    @Override
    public String toSql() {
        return "INNER " + super.toSql();
    }
}
