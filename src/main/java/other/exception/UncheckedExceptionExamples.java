package other.exception;

import java.util.List;

public class UncheckedExceptionExamples {
    public static void main(String[] args) {
        //divisionByZero();
        //arrayOutOfBounds();
        //stringOutOfBounds();
        //notANumber();
        //nullPointerException();
    }

    private static int divisionByZero(){
        return 5/0;
    }

    private static int arrayOutOfBounds() {
        int array[] = new int[20];
        return array[21];
    }

    private static int stringOutOfBounds(){
        String sentence = "My name is Ioannis";
        return sentence.charAt(500);
    }

    private static void notANumber(){
        double sqrt = Math.sqrt(-3);
        System.out.println(sqrt);
    }

    private static void nullPointerException(){
        List<String> list = null;
        list.get(0);
    }
}
