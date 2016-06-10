package SQL;

import Structure.Selectables.Selectable;
import Structure.Selectables.StringLitteral;

import java.util.List;

/**
 * Created by gasto on 10/06/2016.
 */
public class Select extends SQLQuerry.SQLQuerryBuilder {

    public static final SQLQuerry.SQLQuerryBuilder ALL = new Select(StringLitteral.ALL);

    public Select(Selectable s) {
        super();
        addSelectClause(s);
    }

    public Select(List<Selectable> ls) {
        super();
        for (Selectable s : ls) {
            addSelectClause(s);
        }
    }

    @Override
    public void init() {
        querry = "SELECT ";
    }
}
