package SQL;

import SQL.Join.*;
import Structure.Expressions.IExpression;
import Structure.Requestable.Table;
import Structure.Selectables.Selectable;
import Utils.Builder;
import com.sun.istack.internal.NotNull;

import java.util.*;

/**
 * Created by gasto on 09/06/2016.
 */
public class SQLQuerry {

    protected Set<Table> fromTables = new HashSet<>();
    protected Set<Table> knownTables = new HashSet<>();
    protected List<Selectable> selectClauses = new LinkedList<>();
    protected Set<Table> expectedTables = new HashSet<>();
    private Map<Table, Set<IExpression<?>>> joins = new Hashtable<>();
    protected String querry = "";

    public SQLQuerry(SQLQuerryBuilder sqlQuerryBuilder) {
        this.fromTables = sqlQuerryBuilder.fromTables;
        this.knownTables = sqlQuerryBuilder.knownTables;
        this.selectClauses = sqlQuerryBuilder.selectClauses;
        this.expectedTables = sqlQuerryBuilder.expectedTables;
        this.joins = sqlQuerryBuilder.joins;
        this.querry = sqlQuerryBuilder.querry;
    }

    @Override
    public String toString() {
        return querry;
    }

    public static abstract class SQLQuerryBuilder implements Builder<SQLQuerry> {

        protected Set<Table> fromTables = new HashSet<>();
        protected Set<Table> knownTables = new HashSet<>();
        protected List<Selectable> selectClauses = new LinkedList<>();
        protected Set<Table> expectedTables = new HashSet<>();
        private Map<Table, Set<IExpression<?>>> joins = new Hashtable<>();
        protected String querry = "";

        public abstract void init();

        protected SQLQuerryBuilder() {
            init();
        }

        @NotNull
        public void addSelectClause(Selectable s) {
            Table t = s.getRelatedTable();
            if (t != null)
                expectedTables.add(t);
            selectClauses.add(s);
        }

        public SQLQuerryBuilder from(Table t) {
            addTable(t);
            return this;
        }

        public SQLQuerryBuilder from(List<Table> lt) {
            for (Table t : lt)
                addTable(t);
            return this;
        }

        public SQLQuerryBuilder addTable(Table t) {
            knownTables.add(t);
            fromTables.add(t);
            return this;
        }

        public Inner join(Table t) {
            return innerJoin(t);
        }

        public Inner innerJoin(Table t) {
            addJoin(t);
            return new Inner(this, t);
        }

        public Left leftJoin(Table t) {
            addJoin(t);
            return new Left(this, t);
        }

        public Right rightJoin(Table t) {
            addJoin(t);
            return new Right(this, t);
        }

        public Full fullJoin(Table t) {
            addJoin(t);
            return new Full(this, t);
        }

        public Map<Table, Set<IExpression<?>>> getJoins() {
            return joins;
        }

        private void addJoin(Table t) {
            if (!joins.containsKey(t))
                joins.put(t, new HashSet<>());

            knownTables.add(t);
        }


        public SQLQuerryBuilder where(IExpression<?> e) {
            return this;
        }

        @Override
        public SQLQuerry build() {
            return new SQLQuerry(this);
        }
    }

}
