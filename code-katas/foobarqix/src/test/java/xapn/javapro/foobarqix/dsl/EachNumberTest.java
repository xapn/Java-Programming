/**
 * 
 */
package xapn.javapro.foobarqix.dsl;

import static org.junit.Assert.assertEquals;
import static xapn.javapro.foobarqix.dsl.EachNumber.eachNumberBetween;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xapn.javapro.foobarqix.dsl.EachNumber;

/**
 * Test Case for {@link xapn.javapro.foobarqix.dsl.EachNumber}.
 * 
 * @author Xavier Pigeon
 */
public class EachNumberTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(EachNumberTest.class);
    
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
     * {@link xapn.javapro.foobarqix.dsl.EachNumber#eachNumberBetween(int, int)}
     * .
     * In this test case, we want to change the DSL rules and add the method
     * chaining, and to get and verify the text according to one given numeric
     * range before and after changing the rules.
     */
    @Test
    public void testEachNumberBetween() {
        LOGGER.debug("testEachNumberBetween");
        String actual = null;
        
        EachNumber eachNumber = eachNumberBetween(2, 4).isDivisibleBy(3).isDivisibleBy(5).isDivisibleBy(7)
                .contains(3, 5, 7);
        actual = eachNumber.fooBarQix();
        LOGGER.debug("{}\nResult: \n{}", eachNumber.toString(), actual);
        assertEquals("2\nFooFoo\n4", actual);
        
        Map<Integer, String> rules = eachNumber.getRules();
        rules.put(2, "Fum");
        eachNumber.withRules(rules).contains(2).isDivisibleBy(2);
        actual = eachNumber.fooBarQix();
        LOGGER.debug("{}\nResult: \n{}", eachNumber.toString(), actual);
        assertEquals("FumFum\nFooFoo\nFum", actual);
    }
}
