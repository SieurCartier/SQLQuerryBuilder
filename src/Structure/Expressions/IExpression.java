package Structure.Expressions;

import Structure.Requestable.Requestable;
import Structure.Requestable.Table;
import Structure.Selectables.Selectable;

import java.util.Set;

/**
 * Created by gasto on 10/06/2016.
 */
public interface IExpression<T> extends Requestable, Selectable {

    Set<Requestable> getConcernedTables();
}
