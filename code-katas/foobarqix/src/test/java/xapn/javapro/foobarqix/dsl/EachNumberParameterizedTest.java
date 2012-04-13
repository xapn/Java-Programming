/**
 * 
 */
package xapn.javapro.foobarqix.dsl;

import static org.junit.Assert.assertEquals;
import static xapn.javapro.foobarqix.dsl.EachNumber.eachNumberBetween;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parameterized Test Case for {@link xapn.javapro.foobarqix.dsl.EachNumber}.
 * 
 * @author Xavier Pigeon
 */
@RunWith(Parameterized.class)
public class EachNumberParameterizedTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EachNumberParameterizedTest.class);
    
    @Parameters
    public static Collection<Object[]> generateData() {
        return Arrays.asList(new Object[][] { { 53, 53, "BarFoo" },
                { 1, 10, "1\n2\nFooFoo\n4\nBarBar\nFoo\nQixQix\n8\nFoo\nBar" } });
    }
    
    // Parameters
    private int startNumber;
    private int endNumber;
    private String expectedResult;
    
    /**
     * Constructor.
     * 
     * @param startNumber the range start
     * @param endNumber the range end
     * @param expectedResult the expected result
     */
    public EachNumberParameterizedTest(int startNumber, int endNumber, String expectedResult) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.expectedResult = expectedResult;
    }
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {}
    
    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {}
    
    /**
     * Test method for
     * {@link xapn.javapro.foobarqix.dsl.FooBarQix#eachNumberBetween(int, int)}
     * .
     */
    @Test
    public void testEachNumberBetween() {
        String actual = eachNumberBetween(startNumber, endNumber).isDivisibleBy(3).isDivisibleBy(5).isDivisibleBy(7)
                .contains(3, 5, 7).fooBarQix();
        LOGGER.debug("From: " + startNumber + " to: " + endNumber + ", result: " + actual);
        assertEquals(expectedResult, actual);
    }
}
