import java.util.ArrayList;
import java.util.Arrays;

public class EncryptionAlgorithm {

    public static void main(String[] args) {
        long max_number = 9223372036854775807L; // 000 + 1 = 001 + 1 = 010 // 111 + 1 = 000
        long max_number_enum = Long.MAX_VALUE;
        System.out.println(max_number_enum);
        System.out.println(max_number);
        long max_number_plus_one = max_number + 5;
        System.out.println(max_number_plus_one);
        System.out.println(max_number - max_number_plus_one);
        long negative_number = -5L;
        System.out.println();
/*
        String originalMessage = "awf@ER8f338fm*AMWCV8nf38"; //
        long encryptedMessage = encrypt(originalMessage);
        System.out.println(encryptedMessage);
        */
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

        // awf@*R8f338fm*AMWCV8nf38
        // 2150712508

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
        // 10 + 276 + 1
        // 276
        long hash = length + sum;
        if(numberOrSmallLetter){
            hash++;
        }
        // convert to fixed number (fixed=standard length, i.e. 10 length)
        if(hash < 999999999){
            // todo : multiply by (i.e.) 100 times and utilize overflow of long
            // todo : download a encypter library and compare to ours (i.e. BEncrypter)

            // 15 + 15 = 30 <-  X
            // 15 * 15 = 225 <- X
            // 15 ^ 3 = 3375 <- X
        }
        return hash;
    }
}
