/**
 * 
 */
package xapn.projects.java.foobarqix.dsl;

import static org.junit.Assert.assertEquals;
import static xapn.projects.java.foobarqix.dsl.FooBarQixRangeDSL.eachNumberBetween;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test Case for {@link xapn.projects.java.foobarqix.dsl.FooBarQixRangeDSL}.
 * 
 * @author Xavier Pigeon
 */
public class FooBarQixRangeDSLTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(FooBarQixRangeDSLTest.class);
    
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
     * {@link xapn.projects.java.foobarqix.dsl.FooBarQixRangeDSL#eachNumberBetween(int, int)}
     * .
     */
    @Test
    public void testEachNumberBetween() {
        LOGGER.debug("testEachNumberBetween");
        String actual = null;
        
        FooBarQixRangeDSL dsl = eachNumberBetween(2, 4).isDivisibleBy(3).isDivisibleBy(5).isDivisibleBy(7)
                .contains(3, 5, 7);
        actual = dsl.getText();
        LOGGER.debug("{}\nResult: \n{}", dsl.toString(), actual);
        assertEquals("2\nFooFoo\n4", actual);
        
        Map<Integer, String> rules = dsl.getRules();
        rules.put(2, "Fum");
        dsl.withRules(rules).contains(2).isDivisibleBy(2);
        actual = dsl.getText();
        LOGGER.debug("{}\nResult: \n{}", dsl.toString(), actual);
        assertEquals("FumFum\nFooFoo\nFum", actual);
    }
}
