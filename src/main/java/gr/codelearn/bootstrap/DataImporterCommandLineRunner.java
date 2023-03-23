package gr.codelearn.bootstrap;

import gr.codelearn.model.Category;
import gr.codelearn.model.Customer;
import gr.codelearn.model.Order;
import gr.codelearn.model.Product;
import gr.codelearn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataImporterCommandLineRunner implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        Order order = orderService.initiateOrder(getCustomers().get(0));
        orderService.addProductToOrder(getProducts().get(0), order);
        orderService.addProductToOrder(getProducts().get(1), order);
        orderService.checkout(order);

        Order order2 = orderService.initiateOrder(getCustomers().get(1));
        orderService.addProductToOrder(getProducts().get(2), order2);
        orderService.addProductToOrder(getProducts().get(3), order2);
        orderService.addProductToOrder(getProducts().get(4), order2);
        orderService.checkout(order2);
    }

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
                new Customer("Paul Croft", "test address", "paulcroft@gmail.com"),
                new Customer("Jonen Donen", "Ionen 13", "jondon@gmail.com")
        );
    }
}
