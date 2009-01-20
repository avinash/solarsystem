import junit.framework.Test;
import junit.framework.TestSuite;

/*
 * Created on Oct 20, 2005
 *
 * To change this generated comment go to 
 * Window>Preferences>Java>Code Generation>Code Template
 */

/**
 * @author avinashm
 */
public class AllTests
{
    public static Test suite()
    {
        TestSuite suite = new TestSuite("Test for default package");
        // $JUnit-BEGIN$
        suite.addTest(TestBody.suite());
        suite.addTest(TestSterileBody.suite());
        suite.addTest(TestParentBody.suite());
        // $JUnit-END$
        return suite;
    }
}
