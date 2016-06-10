package SQL;

import Structure.Selectables.Selectable;
import Structure.Selectables.StringLitteral;

import java.util.List;

/**
 * Created by gasto on 10/06/2016.
 */
public class SelectDistinct extends Select {

    public static final SQLQuerry.SQLQuerryBuilder ALL = new SelectDistinct(StringLitteral.ALL);

    public SelectDistinct(Selectable s) {
        super(s);
    }

    public SelectDistinct(List<Selectable> ls) {
        super(ls);
    }

    @Override
    public void init() {
        super.init();
        querry += "DISTINCT ";
    }
}