/**
 * Created by gasto on 09/06/2016.
 */
public interface Selectable {

    String toSql();

    Table getRelatedTable() ;

}
