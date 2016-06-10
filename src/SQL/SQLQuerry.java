package SQL;

import Structure.Requestable.Table;
import Utils.Builder;
import Structure.Selectables.Selectable;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by gasto on 09/06/2016.
 */
public class SQLQuerry {

    protected Select select;
    protected Set<Table> fromTables = new HashSet<>();
    protected Set<Table> knownTables = new HashSet<>();

    private Map<Table, List<Predicate<?>>> joins = new Hashtable<>();
    private String querry = "";

    public SQLQuerry(SQLQuerryBuilder sqlQuerryBuilder) {
    }

    @Override
    public String toString() {
        return querry;
    }

    public static class SQLQuerryBuilder implements Builder<SQLQuerry> {

        protected Select select;
        protected Set<Table> fromTables = new HashSet<>();
        protected Set<Table> knownTables = new HashSet<>();

        public Select select(Selectable s) {
            return new Select(s);
        }

        public Select select(List<Selectable> ls) {
            return new Select(ls);
        }

        public Select SelectAll() {
            return Select.ALL;
        }

        public SelectDistinct selectDistinct(Selectable s) {
            return new SelectDistinct(s);
        }

        public SelectDistinct selectDistinct(List<Selectable> ls) {
            return new SelectDistinct(ls);
        }

        public SelectDistinct selectDistinctAll() {
            return Select.DISTINCT_ALL;
        }

        public SQLQuerry build() {
            return new SQLQuerry(this);
        }
    }

}
