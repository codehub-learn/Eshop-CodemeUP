import java.util.ArrayList;
import java.util.Arrays;

public class EncryptionAlgorithm {

    public static void main(String[] args) {
        String originalMessage = "patates"; //
        encrypt(originalMessage);
    }


    private static String encrypt(String originalText) {
        byte[] bytes = originalText.getBytes();
        // length of message
        int length = bytes.length;
        // sum of bytes of first, middle, and last characters
        int sum = bytes[0] + bytes[bytes.length/2] + bytes[bytes.length - 1];
        // if byte array contains bytes between 48-57 or 97-126
        // (if message contains number or small letters)
        // todo: homework: finish the encrypt method
        return "";
    }
}
