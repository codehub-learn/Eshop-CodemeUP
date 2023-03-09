import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class EncryptionAlgorithm {

    public static void main(String[] args) throws Exception {
        String originalMessage = "password123";
        //long encryptedMessage = encrypt(originalMessage);
        //System.out.println(encryptedMessage);
        publicPrivateKeyCryptography();
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
        long seed = 5437371;
        for (int i = 0; i < 10; i++) {
            hash *= seed;
            System.out.println(hash);
        }
        System.out.println("passed");
        do {
            hash *= seed;
            if(hash < 0) hash *= (-1);
            System.out.println(hash);
        } while (hash <= 999999999L || hash >= 10000000000L);

        return hash;
    }

    private static void publicPrivateKeyCryptography() throws Exception {
        // key pair generation
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(512);
        KeyPair keyPair = keyGen.generateKeyPair();
        System.out.println(keyPair.getPublic());
        System.out.println(keyPair.getPrivate());
        // store to a file...

        String message = "Hello Guys";
        // encrypt message based on public key
        Cipher encryptionCipher = Cipher.getInstance("RSA");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] encryptedMessage = encryptionCipher.doFinal(message.getBytes());
        String encryptedMessageStr = new String(encryptedMessage);
        System.out.println(encryptedMessageStr);

        // decrypt message based on private key
        Cipher decryptionCipher = Cipher.getInstance("RSA");
        decryptionCipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] decryptedMessage = decryptionCipher.doFinal(encryptedMessage);
        String decryptedMessageStr = new String(decryptedMessage);
        System.out.println(decryptedMessageStr);
    }
}
