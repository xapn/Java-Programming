/**
 * 
 */
package xapn.javapro.foobarqix.dsl;

import static org.junit.Assert.assertEquals;
import static xapn.javapro.foobarqix.dsl.ThisNumber.thisNumber;

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
 * Parameterized Test Case for {@link xapn.javapro.foobarqix.dsl.ThisNumber}.
 * 
 * @author Xavier Pigeon
 */
@RunWith(Parameterized.class)
public class ThisNumberParameterizedTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ThisNumberParameterizedTest.class);
    
    @Parameters
    public static Collection<Object[]> generateData() {
        return Arrays.asList(new Object[][] { { 51, "FooBar" }, { 53, "BarFoo" }, { 21, "FooQix" }, { 13, "Foo" },
                { 15, "FooBarBar" }, { 33, "FooFooFoo" } });
    }
    
    // Parameters
    private int number;
    private String expectedResult;
    
    /**
     * Constructor.
     * 
     * @param number the input number
     * @param expectedResult the expected result
     */
    public ThisNumberParameterizedTest(int number, String expectedResult) {
        this.number = number;
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
     * {@link xapn.javapro.foobarqix.dsl.ThisNumber#thisNumber(int)} .
     */
    @Test
    public void testThisNumber() {
        String actual = thisNumber(number).isDivisibleBy(3).isDivisibleBy(5).isDivisibleBy(7).contains(3, 5, 7)
                .fooBarQix();
        LOGGER.debug("From this number: " + number + " to: " + actual);
        assertEquals(expectedResult, actual);
    }
}
