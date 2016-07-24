package SQL;

import Structure.Selectables.Selectable;
import Structure.Selectables.StringLitteral;

import java.util.List;

/**
 * Created by gasto on 10/06/2016.
 */
public class SelectDistinct extends Select {

    public static final SelectDistinct ALL = new SelectDistinct(StringLitteral.ALL);

    public SelectDistinct(Selectable... ls) {
        super(ls);
        inBetween = "DISTINCT ";
    }
}