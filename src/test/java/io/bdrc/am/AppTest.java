package io.bdrc.am;

import org.apache.log4j.Logger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    private static Logger appTestLog ;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        appTestLog = Logger.getLogger("startup");
        appTestLog.info("Created class");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws java.io.IOException
    {
        String me = this.getClass().getName();
        Logger testLog = Logger.getLogger(me);

        String rsr = StreamToString("/HowdyVolks.settings");
        String subs = StreamToString("/subHowdy/subHowdyVolks.settings");
        appTestLog.info("Writing into app test log");
        testLog.info("testApp class log");
        assertTrue (rsr.length() != subs.length() );
    }


    private String StreamToString(String resourceName) throws java.io.IOException
    {
        InputStreamReader resIn = new InputStreamReader(getClass().getResourceAsStream(resourceName));
        BufferedReader rootSrc = new BufferedReader( resIn);
        String str;
        StringBuilder buff = new StringBuilder();
        while ((str = rootSrc.readLine()) != null)
        {
            buff.append(str);
            buff.append('\n');
        }
        resIn.close();
        return buff.toString();



    }
}
