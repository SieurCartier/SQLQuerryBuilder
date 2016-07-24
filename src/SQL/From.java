package SQL;

import Structure.Requestable.Requestable;
import Structure.Selectables.Selectable;
import Utils.MissingTableException;
import Utils.NoFromClauseException;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by gasto on 12/06/2016.
 */
public class From extends SQLQuerry.SQLQuerryBuilder {

    private List<Requestable> froms = new LinkedList<>();
    private Select select;

    public From(Select select, Requestable... rs) throws NoFromClauseException, MissingTableException {
        this.select = select;

        if (rs.length == 0)
            throw new NoFromClauseException();

        Set<Requestable> required = new HashSet<>();
        for (Selectable s : select.getSelectables()) {
            Set<Requestable> temp = s.getRequired();
            if (temp != null)
                required.addAll(temp);
        }

        Set<Requestable> aquired = new HashSet<>();
        aquired.addAll(Arrays.asList(rs));

        required.removeAll(aquired);

        if (!required.isEmpty()) {
            throw new MissingTableException(required);
        }

        froms.addAll(Arrays.asList(rs));
        knownTables.addAll(froms);
    }

    @Override
    String toSQL() {
        return select.toSql() + "FROM " + froms.stream()
                .map(SQLValid::toSql)
                .collect(Collectors.joining(", ")) + " ";
    }

}
