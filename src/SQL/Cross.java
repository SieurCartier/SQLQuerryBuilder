package SQL;

import Structure.Requestable.Table;

/**
 * Created by gasto on 12/06/2016.
 */
public class Cross extends Join {
    public Cross(SQLQuerry.SQLQuerryBuilder builder, Table concernedTable) {
        super(builder, concernedTable);
    }

    @Override
    public String toSql() {
        return SqlBefore() +  "CROSS " + super.toSql();
    }
}
