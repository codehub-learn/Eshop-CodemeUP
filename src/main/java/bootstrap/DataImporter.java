package bootstrap;

import model.Category;
import model.Customer;
import model.Order;
import model.Product;

import java.util.Arrays;
import java.util.List;

public class DataImporter {
    public static List<Product> getProducts() {
        return Arrays.asList(
                new Product(987654343521L, "Samsung Galaxy s22", 799.89345, Category.PHONES),
                new Product(98423423654321L, "Iphone 11 Plus", 899.89543, Category.PHONES),
                new Product(953453454321L, "Samsung Galaxy s21", 699.89345, Category.PHONES),
                new Product(987642342321L, "Samsung Galaxy s20", 599.89345, Category.PHONES),
                new Product(9874324465321L, "Samsung Galaxy s10", 499.89345, Category.PHONES),
                new Product(987678645631L, "Headphones2", 199.89345, Category.SOUND)
        );
    }

    public static List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer("Paul Croft", "test address", "paulcroft@gmail.com")
        );
    }

    public static List<Order> getOrders() {
        return Arrays.asList(
                new Order(getCustomers().get(0))
        );
    }
}
