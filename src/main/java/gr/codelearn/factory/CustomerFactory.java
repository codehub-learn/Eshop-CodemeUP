package gr.codelearn.factory;

import gr.codelearn.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerFactory implements Factory<Customer> {
    public List<Customer> parse(List<String> strings) {
        List<Customer> customers = new ArrayList<>();
        for (String customerAsString : strings) {
            String[] splitProduct = customerAsString.split(",");
            long id = Long.parseLong(splitProduct[0].trim());
            String name = splitProduct[1].trim();
            String address = splitProduct[2].trim();
            String email = splitProduct[3].trim();
            double balance = Double.parseDouble(splitProduct[4].trim());
            String username = splitProduct[5].trim();
            String password = splitProduct[6].trim();
            Customer customer = new Customer(id, name, address, email, balance, username, password);
            customers.add(customer);
        }
        return customers;
    }
}
