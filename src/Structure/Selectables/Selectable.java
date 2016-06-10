package Structure.Selectables;

import SQL.SQLValid;
import Structure.Requestable.Table;

/**
 * Created by gasto on 09/06/2016.
 */
public interface Selectable extends SQLValid {

    Table getRelatedTable();

}
