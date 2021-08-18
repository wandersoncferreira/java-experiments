package packt_crypto;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class HashingWithSaltTest extends TestCase {
    public HashingWithSaltTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(HashingWithSaltTest.class);
    }


    public void testApp() {

        try {
            HashingWithSalt.main(null);
        } catch (Throwable e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        }

    }
}
