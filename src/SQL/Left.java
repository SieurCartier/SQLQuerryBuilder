package SQL;

import Structure.Requestable.Table;

/**
 * Created by gasto on 12/06/2016.
 */
public class Left extends Outer {

    public Left(SQLQuerry.SQLQuerryBuilder builder, Table t) {
        super(builder, t);
    }

    @Override
    public String toSql() {
        return SqlBefore() + "LEFT " + super.toSql();
    }
}
