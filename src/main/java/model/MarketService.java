package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MarketService {
    private List<Product> productsInShop = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private Customer currentCustomer;
    private Order currentOrder;

    public void initializeData() {
        productsInShop = Arrays.asList( new Product[]{
                new Product(987654343521l, "Samsung Galaxy s22", 799.89345, Category.PHONES),
                new Product(98423423654321l, "Iphone 11 Plus", 899.89543, Category.PHONES),
                new Product(953453454321l, "Samsung Galaxy s21", 699.89345, Category.PHONES),
                new Product(987642342321l, "Samsung Galaxy s20", 599.89345, Category.PHONES),
                new Product(9874324465321l, "Samsung Galaxy s10", 499.89345, Category.PHONES),
                new Product(987678645631l, "Headphones2", 199.89345, Category.SOUND)
        });
        customers = Arrays.asList(new Customer[]{new Customer(123456789, "Paul Croft", "test address", "paulcroft@gmail.com")});
        currentCustomer = customers.get(0);
        orders = Arrays.asList(new Order[]{ new Order(234567890, currentCustomer)});
        currentOrder = orders.get(0);
    }

    public void removeProductFromOrder(int productPosition) {
        if (productPosition >= 0 && productPosition < productsInShop.size()){
            Product product = productsInShop.get(productPosition);
        currentOrder.removeProduct(product);}
        else {
            System.out.println("This product does not exist");
        }
    }

    public void addProductToOrder(int productPosition) {
        if (productPosition >= 0 && productPosition < productsInShop.size()) {
            Product product = productsInShop.get(productPosition);
            currentOrder.addProduct(product);
        } else {
            System.out.println("This product does not exist");
        }
    }

    public void showOrder() {
        System.out.println(currentOrder);
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
                case "a", "add" :
                    System.out.println("Give the product number");
                    int productid = scanner.nextInt();
                    addProductToOrder(productid);
                    break;
                case "s", "show" :
                    showOrder();
                    break;
                case "x", "exit" :
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input");
            }
            if (exit) break;



        }
    }
}
