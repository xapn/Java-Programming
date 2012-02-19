/**
 * 
 */
package xapn.projects.foobarqix.dsl;

import static org.junit.Assert.assertEquals;
import static xapn.projects.foobarqix.dsl.FooBarQixDSL.thisNumber;

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
 * {@link xapn.projects.foobarqix.dsl.FooBarQixDSL}.
 * 
 * @author Xavier Pigeon
 */
@RunWith(Parameterized.class)
public class FooBarQixDSLBasicParameterizedTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(FooBarQixDSLBasicParameterizedTest.class);
    
    @Parameters
    public static Collection<Object[]> generateData() {
        return Arrays.asList(new Object[][] { { 3, 3, "Foo" }, { 5, 5, "Bar" }, { 7, 7, "Qix" }, { 3, 5, "3" },
                { 5, 7, "5" }, { 7, 3, "7" }, { 94, 7, "94" }, { 4, 2, "4" }, { 2, 2, "2" } });
    }
    
    // Parameters
    private int inputNumber;
    private int criterion;
    private String expected;
    
    /**
     * Constructor.
     * 
     * @param inputNumber the input number
     * @param criterion the criteria to be provided to the DSL operation
     * @param expected the expected result
     */
    public FooBarQixDSLBasicParameterizedTest(int inputNumber, int criterion, String expected) {
        LOGGER.debug("Number: " + inputNumber + ", Criterion: " + criterion + ", Expected: " + expected);
        this.inputNumber = inputNumber;
        this.criterion = criterion;
        this.expected = expected;
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
     * {@link xapn.projects.foobarqix.dsl.FooBarQix#contains(int)}.
     */
    @Test
    public void testContains() {
        LOGGER.debug("testContains");
        
        assertEquals(expected, thisNumber(inputNumber).contains(criterion).getFinalText());
    }
    
    /**
     * Test method for
     * {@link xapn.projects.foobarqix.dsl.FooBarQix#isDivisibleBy(int)} .
     */
    @Test
    public void testDivisibleBy() {
        LOGGER.debug("testDivisibleBy");
        
        assertEquals(expected, thisNumber(inputNumber).isDivisibleBy(criterion).getFinalText());
    }
}
