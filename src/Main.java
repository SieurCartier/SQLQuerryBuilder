import Structure.Requestable.Table;

/**
 * Created by Gaston on 08/06/2016.
 */
public class Main {

    public static void main(String[] args) {


        Table products = new Table("Products");
        Table sells = new Table("Sells");
        Table customers = new Table("Customers");

        SQLQuerry querry = Select.ALL
                .from(products)
                .join(sells)
                .on(null)
                .build();

        String sql = querry.toString();



        /*
        String sql = querry.select(new Structure.Selectables.FullField(products, "name"))
                .from(products)
                .innerJoin(customers).On(null)
                .whrere(null)
                .build();
                */
    }
}
