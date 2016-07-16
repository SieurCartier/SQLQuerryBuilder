package SQL;

import Structure.Requestable.Requestable;
import Structure.Selectables.Selectable;
import Utils.NoFromClauseeException;

import java.util.*;

/**
 * Created by gasto on 12/06/2016.
 */
public class From extends SQLQuerry.SQLQuerryBuilder {

    private List<Requestable> froms = new LinkedList<>();

    public From(Select select, Requestable... rs) throws NoFromClauseeException {
        if (rs.length == 0) throw new NoFromClauseeException();

        Set<Requestable> required = new HashSet<>();
        for (Selectable s : select.getSelectables()) {
            required.addAll(s.getRequired());
        }

        Set<Requestable> aquired = new HashSet<>();
        aquired.addAll(Arrays.asList(rs));

        if(required.)
    }


}
