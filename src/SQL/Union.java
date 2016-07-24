package SQL;

import Structure.Requestable.Table;

/**
 * Created by gasto on 12/06/2016.
 */
public class Union extends Join {
    public Union(SQLQuerry.SQLQuerryBuilder builder, Table t) {
        super(builder, t);
    }

    @Override
    public String toSql() {
        return SqlBefore() + "UNION " + super.toSql();
    }
}
