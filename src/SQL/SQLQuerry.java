package SQL;

import Structure.Expressions.IExpression;
import Structure.Requestable.Table;
import Structure.Selectables.FullField;
import Structure.Selectables.Selectable;
import Utils.Builder;
import com.sun.istack.internal.NotNull;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by gasto on 09/06/2016.
 */
public class SQLQuerry {

    protected Set<Table> fromTables = new HashSet<>();
    protected Set<Table> knownTables = new HashSet<>();
    protected List<Selectable> selectClauses = new LinkedList<>();
    protected Set<Table> expectedTables = new HashSet<>();
    private Map<Table, List<Predicate<?>>> joins = new Hashtable<>();
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
        private Map<Table, List<Predicate<?>>> joins = new Hashtable<>();
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

        public SQLQuerryBuilder join(Table t) {

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

        public SQLQuerryBuilder on(IExpression<FullField> e) {
            return this;
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
