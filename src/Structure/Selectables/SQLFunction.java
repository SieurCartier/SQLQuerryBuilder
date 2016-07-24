package Structure.Selectables;

import Structure.Requestable.Requestable;

import java.util.Set;

/**
 * Created by gasto on 09/06/2016.
 */
public class SQLFunction implements Selectable {
    @Override
    public String toSql() {
        return null;
    }

    @Override
    public Set<Requestable> getRequired() {
        return null;
    }
}
