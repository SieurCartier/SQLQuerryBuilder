package Structure.Selectables;

/**
 * Created by gasto on 09/06/2016.
 */
public class StringLitteral extends Litteral<String> {

    public static final StringLitteral ALL = new StringLitteral("*");

    public StringLitteral(String value) {
        super(value);
    }

}
