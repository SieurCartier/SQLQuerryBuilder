package SQL;

import Structure.Selectables.Selectable;

import java.util.List;

/**
 * Created by gasto on 10/06/2016.
 */
public class SelectDistinct extends Select {
    public SelectDistinct(Selectable s) {
        super(s);
    }

    public SelectDistinct(List<Selectable> ls) {
        super(ls);
    }
}
