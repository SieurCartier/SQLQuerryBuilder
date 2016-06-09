/**
 * Created by gasto on 09/06/2016.
 */
public class FullField extends Field {

    protected Table relatedTable;

    public FullField(Table relatedTable, String name) {
        super(name);
        this.relatedTable = relatedTable;
    }

    @Override
    public Table getRelatedTable() {
        return relatedTable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FullField fullField = (FullField) o;

        return relatedTable != null ? relatedTable.equals(fullField.relatedTable) : fullField.relatedTable == null;

    }

    @Override
    public int hashCode() {
        return relatedTable != null ? relatedTable.hashCode() : 0;
    }
}
