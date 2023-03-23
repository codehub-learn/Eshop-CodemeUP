package other.exception;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionShowcase1 {

    public static void main(String[] args) {
        System.out.println("start");
        method1();
        System.out.println("end");
    }

    private static void method1() {
        method2();
    }

    private static void method2() {
        method3();
    }

    private static void method3() {
        try {
            method4();
            FileReader fileReader = new FileReader("...");//checked exception
            fileReader.read();
            //....
        } catch (NumberFormatException e) {
            // logic to handle error
            System.out.println("Cannot convert to number");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("There was a problem with the file given.");
        }
    }

    private static void method4() {
        // methods that may cause an error
        System.out.println("Enter a number...");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        int userInputAsInteger = Integer.parseInt(userInput);
        System.out.println("Your number was: " + userInputAsInteger);
    }
}