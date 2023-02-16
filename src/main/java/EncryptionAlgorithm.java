import java.util.ArrayList;
import java.util.Arrays;

public class EncryptionAlgorithm {

    public static void main(String[] args) {
        String originalMessage = "0000000"; //
        long encryptedMessage = encrypt(originalMessage);
        System.out.println(encryptedMessage);
    }

    // 332 * 2 = 664
    // 332 * 2 = 664

    // sum:
    // 4 + 6
    // 6 + 4
    // multiplication:
    // 4 * 6 = 24 ->

    private static long encrypt(String originalText) {
        // length of original text
        // p a t a t e s: 7
        // -127 eos 127
        // 55 77 22 66 99 22 66: 7
        byte[] bytes = originalText.getBytes();
        // length of message
        int length = bytes.length;
        // sum of bytes of first, middle, and last characters
        int sum = bytes[0] + bytes[bytes.length/2] + bytes[bytes.length - 1];
        // if byte array contains bytes between 48-57 or 97-126
        // (if message contains number or small letters)
        // boolean -> +1
        boolean numberOrSmallLetter = false;
        int numberOrSmallLetterCount = 0;
        for (int i = 0; i < bytes.length; i++) {
            if(bytes[i] >= 48 && bytes[i] <= 57 || bytes[i] >= 97 && bytes[i] <= 126){
                numberOrSmallLetterCount++;
            }
            if(numberOrSmallLetterCount >= bytes.length/2){
                numberOrSmallLetter = true;
                break;
            }
        }
        long hash = length + sum;
        if(numberOrSmallLetter){
            hash++;
        }
        // convert to fixed number (fixed=standard length, i.e. 10 length)
        if(hash < 999999999){
          // 9999999999 ^ 2 = .... > 64bits // todo next session (homework
            // 999999998 + 2
        }
        return hash;
    }
}
