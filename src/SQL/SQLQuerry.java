package SQL;

import SQL.Join.*;
import Structure.Expressions.IExpression;
import Structure.Requestable.Table;
import Structure.Selectables.Selectable;
import Utils.Builder;
import com.sun.istack.internal.NotNull;

import java.util.*;

/**
 * Created by gasto on 09/06/2016.
 */
public class SQLQuerry {

    public SQLQuerry(SQLQuerryBuilder sqlQuerryBuilder) {
    }

    @Override
    public String toString() {


        return null;
    }

    public static class SQLQuerryBuilder implements Builder<SQLQuerry> {
        protected String querry = "";

        protected SQLQuerryBuilder() {
        }

        @Override
        public SQLQuerry build() {
            return new SQLQuerry(this);
        }

    }

}
