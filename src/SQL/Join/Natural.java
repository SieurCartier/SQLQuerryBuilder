package SQL.Join;

import Structure.Requestable.Table;

/**
 * Created by gasto on 12/06/2016.
 */
public class Natural extends Join {
    public Natural(Table concernedTable) {
        super(concernedTable);
    }

    @Override
    public String toSql() {
        return "NATURAL " + super.toSql();
    }
}
