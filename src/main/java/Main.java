import model.Category;
import model.Customer;
import model.Order;
import model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product(987654343521l,"Samsung Galaxy s22",799.89345, Category.PHONES),
                new Product(98423423654321l,"Iphone 11 Plus",899.89543, Category.PHONES),
                new Product(953453454321l,"Samsung Galaxy s21",699.89345, Category.PHONES),
                new Product(987642342321l,"Samsung Galaxy s20",599.89345, Category.PHONES),
                new Product(9874324465321l,"Samsung Galaxy s10",499.89345, Category.PHONES),
                new Product(987678645631l,"Headphones2",199.89345, Category.SOUND),
        };
        Customer costumer1 = new Customer(123456789, "Paul Croft", "test address", "paulcroft@gmail.com");
        Order order1 = new Order(234567890, costumer1);
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Do you want to add or to remove a product?(a to add and r to remove)");
            String userChoice = scanner.next();
            if(userChoice.equals("r")){
                System.out.println("Which product do you want to remove?");
                int userAnswer = scanner.nextInt();
                order1.removeProduct(products[userAnswer]);
                continue;
            }
            System.out.println("Give the product number");
            int productid = scanner.nextInt();
            if (productid >= 0 && productid < products.length) {
                order1.addProduct(products[productid]);
            } else {
                System.out.println("This product does not exist");
            }
            System.out.println("Do you want to continue? y or n");
            String userinput = scanner.next();
            if(!userinput.equals("y")){
                break;
            }
        }
        System.out.println(order1);

    }
}
