import factory.ProductFactory;
import model.Customer;
import model.Order;
import model.Product;
import repository.FileRepository;
import service.OrderService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static OrderService orderService;

    public static void main(String[] args) throws IOException, InterruptedException {
        long start = System.currentTimeMillis();

        // todo: refactor commented code
        /*
        List<Customer> customers = DataImporter.getCustomers();
        List<Product> products = DataImporter.getProducts();
        List<Order> orders = DataImporter.getOrders();
        orderService = new OrderService(products, customers, orders.get(0));
        interactWithUser();
        */

        // todo: refactor importing logic & add inheritance etc.
        FileRepository fileRepository = new FileRepository();
        List<String> productsAsStrings = fileRepository.read("data/products.csv");

        ProductFactory productFactory = new ProductFactory();
        List<Product> products = productFactory.parse(productsAsStrings);

        for (Product product : products) {
            System.out.println(product);
        }

        OrderService orderService = new OrderService();
        // todo: login feature to find who the customer is
        Order order = orderService.initiateOrder(new Customer("Ioannis", "Athens", "ioannis@gmail.com"));
        System.out.println(order);
        orderService.addProductToOrder(products.get(0), order);
        orderService.addProductToOrder(products.get(0), order);
        orderService.addProductToOrder(products.get(0), order);
        System.out.println(order);
        orderService.addProductToOrder(products.get(1), order);
        System.out.println(order);
        orderService.removeProductFromOrder(products.get(1), order);
        System.out.println(order);
        orderService.checkout(order);
        System.out.println(order);

        ArrayList<String> ordersStr = new ArrayList<>();
        ordersStr.add(order.toString());
        ordersStr.add(order.toString());
        fileRepository.save(ordersStr, "data/saved_orders.csv");

        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("End of program.");
        System.out.println("The time it took to run the program was " + timeElapsed + " milliseconds.");
    }

/*    public static void interactWithUser() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (true) {
            System.out.println("Give your choice r(remove), a(add), x(exit), s(show order)");
            String userChoice = scanner.next();
            switch (userChoice) {
                case "r":
                    System.out.println("Which product do you want to remove?");
                    int userAnswer = scanner.nextInt();
                    orderService.removeProductFromOrder(userAnswer);
                    break;
                case "a", "add":
                    System.out.println("Give the product number");
                    int productid = scanner.nextInt();
                    orderService.addProductToOrder(productid);
                    break;
                case "s", "show":
                    showOrder();
                    break;
                case "x", "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input");
            }
            if (exit) break;
        }
    }*/
}
