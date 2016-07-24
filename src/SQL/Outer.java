package SQL;

import Structure.Requestable.Table;

/**
 * Created by gasto on 12/06/2016.
 */
public abstract class Outer extends Conditioned {

    public Outer(SQLQuerry.SQLQuerryBuilder builder, Table t) {
        super(builder, t);
    }

    @Override
    public String toSql() {
        return "OUTER " + super.toSql();
    }
}
