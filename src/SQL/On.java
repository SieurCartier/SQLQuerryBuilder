package SQL;

import Structure.Expressions.BinaryExpression;
import Structure.Requestable.Requestable;
import Structure.Selectables.FullField;
import Utils.InvalidExpressionException;
import Utils.MissingTableException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gasto on 16/07/2016.
 */
public class On extends SQLQuerry.SQLQuerryBuilder {

    private Conditioned conditioned;
    private BinaryExpression<FullField> expression;

    public On(Conditioned conditioned, BinaryExpression<FullField> e) throws MissingTableException, InvalidExpressionException {
        this.conditioned = conditioned;
        this.expression = e;
        Set<Requestable> union = new HashSet<>();

        Set<Requestable> temp = e.getLeft().getRequired();
        if (temp != null)
            union.addAll(temp);

        temp = e.getRight().getRequired();

        if (temp != null)
            union.addAll(temp);

        Set<Requestable> known = conditioned.getKnownTables();

        if (!known.containsAll(union)) {
            union.removeAll(known);
            throw new MissingTableException(union);
        }

        temp = e.getConcernedTables();

        if (temp != null)
            if (!e.getConcernedTables().contains(conditioned.getConcernedTable()))
                throw new InvalidExpressionException();
    }

    @Override
    String toSQL() {
        return conditioned.toSql() + "ON " + expression.toSql();
    }
}
