import Structure.Selectables.StringLitteral;
import Structure.Requestable.Table;
import Structure.Selectables.Selectable;
import com.sun.istack.internal.NotNull;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by gasto on 10/06/2016.
 */
public class Select {

    public static final Select ALL = new Select(StringLitteral.ALL);
    public static final SelectDistinct DISTINCT_ALL = new SelectDistinct(StringLitteral.ALL);

    protected List<Selectable> selectClauses = new LinkedList<>();
    protected Set<Table> expectedTables = new HashSet<>();

    public Select(Selectable s) {
        addSelectClause(s);
    }

    public Select(List<Selectable> ls) {
        for (Selectable s : ls) {
            addSelectClause(s);
        }
    }

    @NotNull
    public From from(Table t) {
        return new From(this, t);
    }

    @NotNull
    public From from(List<Table> lt) {
        return new From(this, lt);
    }

    @NotNull
    private void addSelectClause(Selectable s) {
        Table t = s.getRelatedTable();
        if (t != null)
            expectedTables.add(t);
        selectClauses.add(s);
    }

    public Set<Table> getExpectedTables() {
        return expectedTables;
    }
}
