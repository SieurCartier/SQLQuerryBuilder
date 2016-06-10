package SQL;

import Structure.Expressions.IExpression;
import Structure.Selectables.FullField;

/**
 * Created by gasto on 10/06/2016.
 */
public class On extends SQLQuerry.SQLQuerryBuilder {
    public On(Join join, IExpression<FullField> e) {
        super();
    }
}
