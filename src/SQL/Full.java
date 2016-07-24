package SQL;

import Structure.Requestable.Table;

/**
 * Created by gasto on 12/06/2016.
 */
public class Full extends Outer {
    public Full(SQLQuerry.SQLQuerryBuilder builder, Table t) {
        super(builder, t);
    }

    @Override
    public String toSql() {
        return SqlBefore() + "FULL " + super.toSql();
    }
}
