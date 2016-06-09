import com.sun.istack.internal.NotNull;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.*;

/**
 * Created by gasto on 09/06/2016.
 */
public class SQLQuerryBuilder {

    private boolean isDistinct = false;
    private List<Selectable> selectClauses = new LinkedList<>();
    private List<Table> fromTables = new LinkedList<>();
    private List<Table> expectedTables = new LinkedList<>();
    private List<Table> knownTables = new LinkedList<>();
    private Map<Table, List<Predicate<?>>> joins = new Hashtable<>();
    private String querry = "";

    @NotNull
    public SQLQuerryBuilder select(Selectable s) {
        addSelectClause(s);
        return this;
    }

    @NotNull
    public SQLQuerryBuilder select(List<Selectable> ls) {
        for (Selectable s : ls) {
            addSelectClause(s);
        }
        return this;
    }

    @NotNull
    private void addSelectClause(Selectable s) {
        Table t = s.getRelatedTable();
        if (t != null)
            expectedTables.add(t);
        selectClauses.add(s);
    }

    public SQLQuerryBuilder selectAll() {
        return select(StringLitteral.ALL);
    }

    @NotNull
    public SQLQuerryBuilder selectDistinct(Selectable s) {
        setDistinct();
        select(s);
        return this;
    }

    @NotNull
    public SQLQuerryBuilder selectDistinct(List<Selectable> ls) {
        setDistinct();
        select(ls);
        return this;
    }

    private void setDistinct() {
        isDistinct = true;
    }

    public SQLQuerryBuilder selectDistinctAll() {
        return selectDistinct(StringLitteral.ALL);
    }

    @NotNull
    public SQLQuerryBuilder from(Table t) {
        knownTables.add(t);
        fromTables.add(t);
        return this;
    }

    public SQLQuerryBuilder from(List<Table> lt) {
        for (Table t : lt) {
            from(t);
        }
        return this;
    }

    public SQLQuerryBuilder innerJoin(Table t) {
        return this;
    }

    public SQLQuerryBuilder leftJoin(Table t) {
        return this;
    }

    public SQLQuerryBuilder rightJoin(Table t) {
        return this;
    }

    public SQLQuerryBuilder fullJoin(Table t) {
        return this;
    }

    public SQLQuerryBuilder On(Predicate<Field> p) {
        return null;
    }

    public SQLQuerryBuilder whrere(Predicate<Field> p) {
        return this;
    }

    public void reset() {
        selectClauses = new LinkedList<>();
        expectedTables = new LinkedList<>();
        querry = "";
    }

    public String build() {
        querry = "SELECT " + ((isDistinct) ? "DISTINCT " : "");

        for (Selectable s : selectClauses) {
            querry += s.toSql() + ", ";
        }

        querry += "FROM ";

        for (Table t : fromTables) {
            querry += t.toSql() + ", ";
        }

        return querry;
    }


}
