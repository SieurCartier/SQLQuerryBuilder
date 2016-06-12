package SQL.Join;

import SQL.SQLValid;
import Structure.Requestable.Table;

/**
 * Created by gasto on 12/06/2016.
 */
public abstract class Join implements SQLValid {

    protected Table concernedTable;

    protected Join(Table concernedTable) {
        this.concernedTable = concernedTable;
    }

    @Override
    public String toSql() {
        return "JOIN " + concernedTable.toSql() + " ";
    }
}
