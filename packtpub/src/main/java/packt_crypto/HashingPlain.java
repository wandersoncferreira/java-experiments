package packt_crypto;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.Security;
import org.bouncycastle.pqc.jcajce.provider.BouncyCastlePQCProvider;

public class HashingPlain {

    public static void main(String[] args) {
        Security.addProvider(new BouncyCastlePQCProvider());

        try (InputStream in = Utils.readFromResources("test.json");) {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            final byte[] bytes = new byte[1024];

            for (int length = in.read(bytes); length != -1; length--) {
                md.update(bytes, 0, length);
            }

            final byte[] hashed = md.digest();
            System.out.println("The SHA-s256 value is " + Utils.bytesToHex(hashed));

        } catch (Throwable e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        }
    }
}
