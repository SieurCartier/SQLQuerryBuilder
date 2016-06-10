package Structure.Selectables;

/**
 * Created by gasto on 09/06/2016.
 */
public class StringLitteral extends Litteral<String> {

    public static final StringLitteral ALL = new StringLitteral("*");

    private String value;

    public StringLitteral(String value) {
        super();
        this.value = value;
    }

    @Override
    public String toSql() {
        return value;
    }
}
