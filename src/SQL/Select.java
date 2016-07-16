package SQL;

import Structure.Requestable.Requestable;
import Structure.Selectables.Selectable;
import Structure.Selectables.StringLitteral;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by gasto on 10/06/2016.
 */
public class Select {

    public static final Select ALL = new Select(StringLitteral.ALL);
    private List<Selectable> selectables = new LinkedList<>();

    public Select(Selectable... ls) {
        super();
        if (ls.length != 0) {
            for (Selectable s : ls) {
                addSelectClause(s);
            }
        } else {
            selectables.add(StringLitteral.ALL);
        }
    }

    public void addSelectClause(Selectable s) {
        selectables.add(s);
    }

    public List<Selectable> getSelectables() {
        return selectables;
    }

    public From from(Requestable... rs) {
        return new From(this, rs);
    }
}
