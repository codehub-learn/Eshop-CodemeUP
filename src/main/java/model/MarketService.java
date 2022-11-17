package model;

import java.util.Scanner;

public class MarketService {
    private Product[] products;
    private Customer customer1;
    private Order order1;

    public void initializeData() {
        products = new Product[]{
                new Product(987654343521l, "Samsung Galaxy s22", 799.89345, Category.PHONES),
                new Product(98423423654321l, "Iphone 11 Plus", 899.89543, Category.PHONES),
                new Product(953453454321l, "Samsung Galaxy s21", 699.89345, Category.PHONES),
                new Product(987642342321l, "Samsung Galaxy s20", 599.89345, Category.PHONES),
                new Product(9874324465321l, "Samsung Galaxy s10", 499.89345, Category.PHONES),
                new Product(987678645631l, "Headphones2", 199.89345, Category.SOUND),
        };
        customer1 = new Customer(123456789, "Paul Croft", "test address", "paulcroft@gmail.com");
        order1 = new Order(234567890, customer1);
    }

    public void removeProductFromOrder(int productId) {
        order1.removeProduct(products[productId]);
    }

    public void addProductToOrder(int productId) {
        if (productId >= 0 && productId < products.length) {
            order1.addProduct(products[productId]);
        } else {
            System.out.println("This product does not exist");
        }
    }

    public void showOrder() {

    }

    public void doOperations() {
        initializeData();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (true) {
            System.out.println("Give your choice r(remove), a(add), x(exit), s(show order)");
            String userChoice = scanner.next();
            switch (userChoice) {
                case "r":
                    System.out.println("Which product do you want to remove?");
                    int userAnswer = scanner.nextInt();
                    removeProductFromOrder(userAnswer);
                    break;
                case "a":
                    System.out.println("Give the product number");
                    int productid = scanner.nextInt();
                    addProductToOrder(productid);
                    break;
                case "s":
                    System.out.println(order1);
                    break;
                case "x":
                    exit = true;
                    break;
            }
            if (exit) break;



        }
    }
}
