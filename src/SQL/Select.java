package SQL;

import Structure.Requestable.Requestable;
import Structure.Selectables.Selectable;
import Structure.Selectables.StringLitteral;
import Utils.MissingTableException;
import Utils.NoFromClauseException;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by gasto on 10/06/2016.
 */
public class Select implements SQLValid {

    public static final Select ALL = new Select(StringLitteral.ALL);
    protected String inBetween = "";
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

    public From from(Requestable... rs) throws NoFromClauseException, MissingTableException {
        return new From(this, rs);
    }

    @Override
    public String toSql() {
        return "SELECT " + inBetween + fieldsToSql() + " ";
    }

    private String fieldsToSql() {
        return selectables.stream()
                .map(SQLValid::toSql)
                .collect(Collectors.joining(", "));
    }
}
