/**
 * 
 */
package xapn.projects.java.foobarqix.dsl;

import static org.junit.Assert.assertEquals;
import static xapn.projects.java.foobarqix.dsl.FooBarQixRangeDSL.eachNumberBetween;

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
 * Parameterized Test Case for
 * {@link xapn.projects.java.foobarqix.dsl.FooBarQix}.
 * 
 * @author Xavier Pigeon
 */
@RunWith(Parameterized.class)
public class FooBarQixRangeDSLParameterizedTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(FooBarQixRangeDSLParameterizedTest.class);
    
    @Parameters
    public static Collection<Object[]> generateData() {
        return Arrays.asList(new Object[][] { { 51, 51, "FooBar" }, { 53, 53, "BarFoo" }, { 21, 21, "FooQix" },
                { 13, 13, "Foo" }, { 15, 15, "FooBarBar" }, { 33, 33, "FooFooFoo" },
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
    public FooBarQixRangeDSLParameterizedTest(int startNumber, int endNumber, String expectedResult) {
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
     * {@link xapn.projects.java.foobarqix.dsl.FooBarQix#eachNumberBetween(int, int)}
     * .
     */
    @Test
    public void testEachNumberBetween() {
        String actual = eachNumberBetween(startNumber, endNumber).isDivisibleBy(3).isDivisibleBy(5).isDivisibleBy(7)
                .contains(3, 5, 7).getText();
        LOGGER.debug("From: " + startNumber + " to: " + endNumber + ", result: " + actual);
        assertEquals(expectedResult, actual);
    }
}
