package packt_crypto;

import java.security.SecureRandom;
import java.security.Security;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class SymmetricExample {
    private static final String ALGORITHM = "AES";
    private static final String CIPHER = "AES/CBC/PKCS5PADDING";

    public static String encrypt(byte[] key, byte[] initVector, String value) throws Exception {
        IvParameterSpec iv = new IvParameterSpec(initVector);
        SecretKeySpec skeySpec = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(value.getBytes("UTF-8"));
        String encoded = Base64.getEncoder().encodeToString(encrypted);
        return encoded;
    }

    public static String decrypt(byte[] key, byte[] initVector, String encrypted) throws Exception {
        IvParameterSpec iv = new IvParameterSpec(initVector);
        SecretKeySpec skeySpec = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));
        return new String(original);
    }


    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        SecureRandom sr = new SecureRandom();

        byte[] key = new byte[16];
        sr.nextBytes(key);      // 128 bit key
        byte[] initVector = new byte[16];
        sr.nextBytes(initVector); // 16 bytes IV

        System.out.println("Random key=" + Utils.bytesToHex(key));
        System.out.println("InitVector=" + Utils.bytesToHex(initVector));

        String payload = "This is the plaintext from Erik and Milton's article";
        System.out.println("Original text=" + payload);
        String encrypted = "";
        try {
            encrypted = encrypt(key, initVector, payload);
            System.out.println("Encrypted text=" + encrypted);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            String decrypted = decrypt(key, initVector, encrypted);
            System.out.println("Decrypted text=" + decrypted);
        } catch (Throwable e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        }


    }
}
