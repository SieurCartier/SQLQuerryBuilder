package SQL;

import Structure.Requestable.Table;
import Structure.Expressions.IExpression;

import java.util.List;

/**
 * Created by gasto on 10/06/2016.
 */
public class From extends SQLQuerry.SQLQuerryBuilder {

    public From(Select select, Table t) {
        this.select = select;
        addTable(t);
    }

    public From(Select select, List<Table> lt) {
        this.select = select;
        for (Table t : lt)
            addTable(t);
    }

    private void addTable(Table t) {
        knownTables.add(t);
        fromTables.add(t);
    }

    public Join join(Table t) {
        return new Join(this, t);
    }

    public LeftJoin leftJoin(Table t) {
        return new LeftJoin(this, t);
    }

    public RightJoin rightJoin(Table t) {
        return new RightJoin(this, t);
    }

    public FullJoin fullJoin(Table t) {
        return new FullJoin(this, t);
    }

    public Where where(IExpression<?> e) {
        return new Where();
    }
}
