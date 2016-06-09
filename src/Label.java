/**
 * Created by gasto on 09/06/2016.
 */
public class Label implements Selectable {

    private Selectable selectable;
    private String label;

    public Label(Selectable selectable, String label) {
        this.selectable = selectable;
        this.label = label;
    }

    @Override
    public String toSql() {
        return selectable.toSql() + " as " + label;
    }

    @Override
    public Table getRelatedTable() {
        return selectable.getRelatedTable();
    }
}
