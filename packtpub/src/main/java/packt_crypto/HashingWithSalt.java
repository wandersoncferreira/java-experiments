package packt_crypto;

import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider;

public class HashingWithSalt {
    

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException{
        Security.addProvider(new BouncyCastlePQCProvider());

        final String password = "12345";
        final String salt = "user@example.com";
        final int iterations = 42;

        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), iterations, 512);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hashed = skf.generateSecret(keySpec).getEncoded();
        System.out.println("The SHA-256 value salted with PBKDF2 is " + Utils.bytesToHex(hashed));
    }
}
