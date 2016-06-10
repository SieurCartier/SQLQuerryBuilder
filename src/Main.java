import SQL.SQLQuerry;
import SQL.Select;
import Structure.Expressions.Equals;
import Structure.Expressions.GreaterThan;
import Structure.Requestable.Table;
import Structure.Selectables.NumberLitteral;
import Structure.Selectables.StringLitteral;

import java.sql.Types;

/**
 * Created by Gaston on 08/06/2016.
 */
public class Main {

    public static void main(String[] args) {

        try {
            Table products = new Table.TableBuilder("Products")
                    .addField("id", Types.INTEGER, true)
                    .addField("name", Types.VARCHAR)
                    .addField("unitPrice", Types.FLOAT)
                    .addField("stock", Types.INTEGER)
                    .build();


            Table sells = new Table.TableBuilder("Sells")
                    .addField("id", Types.INTEGER, true)
                    .addField("idCustomer", Types.INTEGER)
                    .addField("ticketNumber", Types.INTEGER)
                    .addField("date", Types.DATE)
                    .addField("price", Types.FLOAT)
                    .build();

            Table tickets = new Table.TableBuilder("Tickets")
                    .addField("id", Types.INTEGER, true)
                    .addField("ticketNumber", Types.INTEGER)
                    .addField("idProduct", Types.INTEGER)
                    .addField("quantity", Types.INTEGER)
                    .addField("totalPrice", Types.FLOAT)
                    .build();


            Table customers = new Table.TableBuilder("Customers")
                    .addField("id", Types.INTEGER, true)
                    .addField("name", Types.VARCHAR)
                    .build();


            SQLQuerry querry = Select.ALL
                    .from(products)
                    .join(sells).on(new Equals(customers.getPrimaryKey(), sells.getField("customerid")))
                    .where(new GreaterThan(sells.getField("price"), new NumberLitteral(19)))
                    .build();

            String sql = querry.toString();

            SQLQuerry q2 = new Select(products.getField("unitPrice"))
                    .from(products)
                    .where(new GreaterThan(products.getField("unitPrice"), new NumberLitteral(19)))
                    .build();

            String sq2 = q2.toString();

        /*
        String sql = querry.select(new Structure.Selectables.FullField(products, "name"))
                .from(products)
                .innerJoin(customers).SQL.On(null)
                .whrere(null)
                .build();
                */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
