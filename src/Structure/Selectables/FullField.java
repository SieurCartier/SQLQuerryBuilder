package Structure.Selectables;

import Structure.Requestable.Requestable;
import Structure.Requestable.Table;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gasto on 09/06/2016.
 */
public class FullField extends Field {

    protected Table relatedTable;

    public FullField(Table relatedTable, String name, int type) {
        super(name, type);
        this.relatedTable = relatedTable;
    }

    public FullField(Table relatedTable, Field field) {
        super(field.getFieldName(), field.getType());
        this.relatedTable = relatedTable;
    }

    @Override
    public Set<Requestable> getConcernedTables() {
        Set<Requestable> ret = new HashSet<>();
        ret.add(relatedTable);
        return ret;
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
