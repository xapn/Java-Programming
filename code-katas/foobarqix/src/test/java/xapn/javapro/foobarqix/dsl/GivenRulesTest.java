/**
 * 
 */
package xapn.javapro.foobarqix.dsl;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Collections;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test Case for {@link xapn.javapro.foobarqix.dsl.GivenRules}.
 * 
 * @author Xavier Pigeon
 */
public class GivenRulesTest {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GivenRulesTest.class);
    
    @Rule
    public TestName testName = new TestName();
    
    private GivenRules givenRules;
    private Map<Integer, String> expectedRules;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        LOGGER.debug("TEST: " + testName.getMethodName());
        expectedRules = Collections.emptyMap();
        givenRules = new GivenRules(expectedRules);
    }
    
    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {}
    
    /**
     * Test method for
     * {@link xapn.javapro.foobarqix.dsl.GivenRules#eachNumber()}.
     */
    @Test
    public void testEachNumber() {
        assertThat(givenRules.eachNumber()).isNotNull().isInstanceOf(Between.class);
        assertThat(givenRules.eachNumber().between(1).and(3).getRules()).isSameAs(expectedRules);
    }
    
    /**
     * Test method for
     * {@link xapn.javapro.foobarqix.dsl.GivenRules#thisNumber()}.
     */
    @Test
    public void testThisNumber() {
        assertThat(givenRules.thisNumber(1)).isNotNull().isInstanceOf(ThisNumber.class);
        assertThat(givenRules.thisNumber(1).getRules()).isSameAs(expectedRules);
    }
}
