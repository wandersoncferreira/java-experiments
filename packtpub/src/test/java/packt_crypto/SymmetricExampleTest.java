package packt_crypto;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class SymmetricExampleTest extends TestCase {
    public SymmetricExampleTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(SymmetricExampleTest.class);
    }


    public void testApp() {

        SymmetricExample.main(null);
    }
}
