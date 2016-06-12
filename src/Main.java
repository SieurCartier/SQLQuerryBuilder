import SQL.SQLQuerry;
import SQL.Select;
import Structure.Expressions.Equals;
import Structure.Expressions.GreaterThan;
import Structure.Requestable.Table;
import Structure.Selectables.NumberLitteral;

import java.sql.Types;

/**
 * Created by Gaston on 08/06/2016.
 */
public class Main {

    public static void main(String[] args) {

        try {
            Table products = new Table.TableBuilder("Products")
                    .setPrimaryKey("id", Types.INTEGER)
                    .addField("name", Types.VARCHAR)
                    .addField("unitPrice", Types.FLOAT)
                    .addField("stock", Types.INTEGER)
                    .build();

            Table customers = new Table.TableBuilder("Customers")
                    .setPrimaryKey("id", Types.INTEGER)
                    .addField("name", Types.VARCHAR)
                    .build();

            Table tickets = new Table.TableBuilder("Tickets")
                    .setPrimaryKey("id", Types.INTEGER)
                    .addField("ticketNumber", Types.INTEGER)
                    .addField("quantity", Types.INTEGER)
                    .addField("totalPrice", Types.FLOAT)
                    .addForeignKey("idProduct", Types.INTEGER, products.getPrimaryKey())
                    .build();

            Table sells = new Table.TableBuilder("Sells")
                    .setPrimaryKey("id", Types.INTEGER)
                    .addField("date", Types.DATE)
                    .addField("price", Types.FLOAT)
                    .addForeignKey("idCustomer", Types.INTEGER, customers.getPrimaryKey())
                    .addForeignKey("ticketNumber", Types.INTEGER, tickets.getPrimaryKey())
                    .build();


            SQLQuerry querry = Select.ALL
                    .from(products)
                    .join(sells).on(new Equals(customers.getPrimaryKey(), sells.getField("idCustomer")))
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
