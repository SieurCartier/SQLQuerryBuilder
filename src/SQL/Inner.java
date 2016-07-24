package SQL;

import Structure.Requestable.Table;

/**
 * Created by gasto on 12/06/2016.
 */
public class Inner extends Conditioned {

    public Inner(SQLQuerry.SQLQuerryBuilder builder, Table t) {
        super(builder, t);
    }

    @Override
    public String toSql() {
        return SqlBefore() +  "INNER " + super.toSql();
    }
}
