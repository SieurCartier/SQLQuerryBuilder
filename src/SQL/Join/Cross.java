package SQL.Join;

import Structure.Requestable.Table;

/**
 * Created by gasto on 12/06/2016.
 */
public class Cross extends Join {
    public Cross(Table concernedTable) {
        super(concernedTable);
    }

    @Override
    public String toSql() {
        return "CROSS " + super.toSql();
    }
}
