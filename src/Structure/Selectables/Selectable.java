package Structure.Selectables;

import SQL.SQLValid;
import Structure.Requestable.Requestable;

import java.util.Set;

/**
 * Created by gasto on 09/06/2016.
 */
public interface Selectable extends SQLValid {

    Set<Requestable> getRequired();

}
