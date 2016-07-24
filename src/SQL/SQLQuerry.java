package SQL;

import Structure.Expressions.IExpression;
import Structure.Requestable.Requestable;
import Structure.Requestable.Table;
import Utils.Builder;

import java.util.*;


/**
 * Created by gasto on 09/06/2016.
 */
public class SQLQuerry {

    private SQLQuerryBuilder builder;

    public SQLQuerry(SQLQuerryBuilder builder) {
        this.builder = builder;
    }

    @Override
    public String toString() {
        return builder.toSQL();
    }

    public static abstract class SQLQuerryBuilder implements Builder<SQLQuerry> {
        protected String querry = "";
        protected Set<Requestable> knownTables = new HashSet<>();

        public void addTable(Requestable r) {
            knownTables.add(r);
        }

        public void addAllTable(Collection<Requestable> rs) {
            knownTables.addAll(rs);
        }

        public Set<Requestable> getKnownTables() {
            return knownTables;
        }

        public Where where(IExpression e) {
            return new Where(this, e);
        }

        public And and(IExpression e) {
            return new And(this, e);
        }

        public And and(And e) {
            return new And(this, e);
        }

        public And and(Or e) {
            return new And(this, e);
        }

        public Or or(IExpression e) {
            return new Or(this, e);
        }

        public Or or(Or e) {
            return new Or(this, e);
        }

        public Or or(And e) {
            return new Or(this, e);
        }

        public Inner join(Table t) {
            return innerJoin(t);
        }

        public Inner innerJoin(Table t) {
            return new Inner(this, t);
        }

        public Natural naturalJoin(Table t) {
            return new Natural(this, t);
        }

        public Cross crossJoin(Table t) {
            return new Cross(this, t);
        }

        public Union unionJoin(Table t) {
            return new Union(this, t);
        }

        public Right rightOuterJoin(Table t) {
            return new Right(this, t);
        }

        public Full fullOuterJoin(Table t) {
            return new Full(this, t);
        }

        public Left leftOuterJoin(Table t) {
            return new Left(this, t);
        }


        abstract String toSQL();

        @Override
        public SQLQuerry build() {
            return new SQLQuerry(this);
        }

    }

}
