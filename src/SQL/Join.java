package SQL;

import Structure.Expressions.IExpression;
import Structure.Requestable.Requestable;
import Structure.Requestable.Table;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by gasto on 12/06/2016.
 */
public abstract class Join implements SQLValid {

    protected Table concernedTable;
    protected HashMap<Requestable, List<IExpression>> joined = new HashMap<>();
    protected SQLQuerry.SQLQuerryBuilder builder;

    protected Join(SQLQuerry.SQLQuerryBuilder builder, Table concernedTable) {
        this.builder = builder;
        this.concernedTable = concernedTable;
        builder.addTable(concernedTable);
    }

    protected Table getConcernedTable() {
        return concernedTable;
    }

    public Set<Requestable> getKnownTables() {
        return builder.getKnownTables();
    }

    public String toSql() {
        return "JOIN " + concernedTable.toSql() + " ";
    }

    protected String SqlBefore() {
        return builder.toSQL();
    }

    public SQLQuerry.SQLQuerryBuilder getBuilder() {
        return builder;
    }

}
