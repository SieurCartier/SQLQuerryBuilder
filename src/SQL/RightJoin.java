package SQL;

import SQL.From;
import SQL.Join;
import Structure.Requestable.Table;

/**
 * Created by gasto on 10/06/2016.
 */
public class RightJoin extends Join {
    public RightJoin(From from, Table t) {
        super(from, t);
    }
}
