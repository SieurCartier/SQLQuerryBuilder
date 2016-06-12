package SQL.Join;

import Structure.Requestable.Table;

/**
 * Created by gasto on 12/06/2016.
 */
public class Union extends Join {
    public Union(Table concernedTable) {
        super(concernedTable);
    }

    @Override
    public String toSql() {
        return "UNION " + super.toSql();
    }
}
