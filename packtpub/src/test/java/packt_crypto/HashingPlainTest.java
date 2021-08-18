package packt_crypto;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class HashingPlainTest extends TestCase {
    public HashingPlainTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(HashingPlainTest.class);
    }


    public void testApp() {

        HashingPlain.main(null);
    }
}
