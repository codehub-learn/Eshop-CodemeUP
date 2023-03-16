package other.exception;

import other.exception.NumberBelowZeroException;

import java.io.IOException;

public class ExceptionShowcase2 {
    public static void main(String[] args) {
        String number = "5";
        //System.out.println(convertWithTryCatch(number));
        //System.out.println(convertWithTryCatchFinally(number));
        //System.out.println(convertWithTryCatchFinallyAllReturn(number));
/*        try {
            throwsCheckedException(number);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        //throwsUncheckedException(number);
        //actuallyThrowUncheckedException(number);
        printPositiveNumber(-5);
    }

    private static int convertWithTryCatch(String input) {
        try {
            Integer.parseInt(input);
            return 1;
        } catch (NumberFormatException e) {
            System.out.println("Cannot convert number.");
            return -1;
        }
    }

    private static int convertWithTryCatchFinally(String input) {
        try {
            Integer.parseInt(input);
            return 1;
        } catch (NumberFormatException e) {
            System.out.println("Cannot convert number.");
            return -1;
        } finally {
            System.out.println("within finally");
        }
    }

    private static int convertWithTryCatchFinallyAllReturn(String input) {
        try {
            Integer.parseInt(input);
            return 1;
        } catch (NumberFormatException e) {
            System.out.println("Cannot convert number.");
            return -1;
        } finally {
            System.out.println("within finally");
            return -999; // should be avoided
        }
    }

    // checked vs unchecked
    private static int throwsCheckedException(String input) throws IOException {
        Integer.parseInt(input);
        return 1;
    }

    private static int throwsUncheckedException(String input) throws RuntimeException {
        Integer.parseInt(input);
        return 1;
    }

    private static int actuallyThrowUncheckedException(String input) {
        throw new RuntimeException();
        //return 1;
    }

    private static void printPositiveNumber(int number){
        if (number > 0){
            System.out.println(number);
        } else {
            throw new NumberBelowZeroException("Your number was equal to 0 OR negative.");
        }
    }

    private static void convertNumber(String numberStr){
        try {
            Integer.parseInt(numberStr);
        } catch (NumberFormatException e){
            throw new RuntimeException();
        }
    }
}
