import repository.FileRepository;
import service.OrderService;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static OrderService orderService;

    public static void main(String[] args) throws IOException {
        /*
        List<Customer> customers = DataImporter.getCustomers();
        List<Product> products = DataImporter.getProducts();
        List<Order> orders = DataImporter.getOrders();
        orderService = new OrderService(products, customers, orders.get(0));
        interactWithUser();
        */

        FileRepository fileRepository = new FileRepository();
        fileRepository.read("data/application.txt");
    }

    public static void showOrder() {
        System.out.println(orderService.getCurrentOrder());
    }

    public static void interactWithUser() {
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
    }
}
