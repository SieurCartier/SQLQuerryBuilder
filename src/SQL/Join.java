package SQL;

import Structure.Requestable.Table;
import Structure.Expressions.IExpression;
import Structure.Selectables.FullField;

/**
 * Created by gasto on 10/06/2016.
 */
public class Join extends SQLQuerry.SQLQuerryBuilder {

    protected From from;

    public Join(From from, Table t) {
        super();
        this.from = from;
    }

    public On on(IExpression<FullField> e) {
        return new On(this, e);
    }

}
