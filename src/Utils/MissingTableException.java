package Utils;

import Structure.Requestable.Requestable;

import java.util.Set;

/**
 * Created by gasto on 16/07/2016.
 */
public class MissingTableException extends Exception {
    public MissingTableException(Set<Requestable> req) {
    }
}
