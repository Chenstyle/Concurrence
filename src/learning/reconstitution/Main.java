package learning.reconstitution;

import learning.reconstitution.rent.Customer;
import learning.reconstitution.rent.Movie;
import learning.reconstitution.rent.Rental;

/**
 * @author Chenstyle
 *         2017-5-23
 */
public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("Devid");
        customer.addRental(new Rental(new Movie("Title", 2333), 15));
        System.out.println(customer.statement());
    }
}
