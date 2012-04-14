/**
 * 
 */
package xapn.javapro.foobarqix.dsl;

import static org.fest.assertions.Assertions.assertThat;
import static xapn.javapro.foobarqix.dsl.FooBarQix.eachNumber;
import static xapn.javapro.foobarqix.dsl.FooBarQix.eachNumberBetween;
import static xapn.javapro.foobarqix.dsl.FooBarQix.givenRules;
import static xapn.javapro.foobarqix.dsl.FooBarQix.thisNumber;

import java.util.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test Case for {@link xapn.javapro.foobarqix.dsl.FooBarQix}.
 * 
 * @author Xavier Pigeon
 */
public class FooBarQixTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(FooBarQix.class);
    
    @Rule
    public TestName testName = new TestName();
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        LOGGER.debug("TEST: " + testName);
    }
    
    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {}
    
    /**
     * Test method for {@link xapn.javapro.foobarqix.dsl.FooBarQix#eachNumber()}
     * .
     */
    @Test
    public void testEachNumber() {
        assertThat(eachNumber()).isNotNull().isInstanceOf(Between.class);
    }
    
    /**
     * Test method for
     * {@link xapn.javapro.foobarqix.dsl.FooBarQix#eachNumberBetween(int, int)}.
     */
    @Test
    public void testEachNumberBetween() {
        assertThat(eachNumberBetween(1, 3)).isNotNull().isInstanceOf(EachNumber.class);
    }
    
    /**
     * Test method for
     * {@link xapn.javapro.foobarqix.dsl.FooBarQix#givenRules(java.util.Map)}.
     */
    @Test
    public void testGivenRulesMap() {
        assertThat(givenRules(Collections.<Integer, String> emptyMap())).isNotNull().isInstanceOf(GivenRules.class);
    }
    
    /**
     * Test method for
     * {@link xapn.javapro.foobarqix.dsl.FooBarQix#givenRules(Object[][])}.
     */
    @Test
    public void testGivenRulesObject() {
        assertThat(givenRules(new Object[][] { { "2", "Two" }, { 3, "Three" } })).isNotNull().isInstanceOf(
                GivenRules.class);
    }
    
    /**
     * Test method for
     * {@link xapn.javapro.foobarqix.dsl.FooBarQix#thisNumber(int)}.
     */
    @Test
    public void testThisNumber() {
        assertThat(thisNumber(3)).isNotNull().isInstanceOf(ThisNumber.class);
    }
}
