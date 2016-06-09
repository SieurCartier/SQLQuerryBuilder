/**
 * Created by Gaston on 08/06/2016.
 */
public class Main {

    public static void main(String[] args) {

        SQLQuerryBuilder querry = new SQLQuerryBuilder();
        Table products = new Table("Products");
        Table sells = new Table("Sells");
        Table customers = new Table("Customers");

        String sql = querry.selectAll().from(products).build() ;



        /*
        String sql = querry.select(new FullField(products, "name"))
                .from(products)
                .innerJoin(customers).On(null)
                .whrere(null)
                .build();
                */
    }
}
