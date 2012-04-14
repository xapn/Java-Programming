/**
 * 
 */
package xapn.javapro.foobarqix.dsl;

import java.util.Map;

/**
 * FooBarQix facade.
 * 
 * @author Xavier Pigeon
 */
public class FooBarQix {
    
    /**
     * Initiate a DSL-based phrase for each integer into the range.</br>
     * "Each number..."
     * 
     * @return a {@link Between} object
     */
    public static Between eachNumber() {
        return new Between();
    }
    
    /**
     * Initiate a DSL-based phrase for each integer into the range.</br>
     * "Each number between &lt;start&gt; and &lt;end&gt;..."
     * 
     * @param start the range start
     * @param end the end range
     * @return a {@link EachNumber} object
     */
    public static EachNumber eachNumberBetween(int start, int end) {
        return EachNumber.eachNumberBetween(start, end);
    }
    
    /**
     * Initiate a DSL-based phrase starting with the rule definition.
     * 
     * @param rules the rules to be applied
     */
    public static GivenRules givenRules(Map<Integer, String> rules) {
        throw new RuntimeException("Not yet implemented");
    }
    
    /**
     * Initiate a DSL-based phrase starting with the rule definition.
     * 
     * @param rules the rules to be applied
     */
    public static GivenRules givenRules(Object[][] rules) {
        throw new RuntimeException("Not yet implemented");
    }
    
    /**
     * Initiate a DSL-based phrase for a given number.
     * 
     * @param number the number to be analyzed
     * @return a {@link ThisNumber} object
     */
    public static ThisNumber thisNumber(int number) {
        return ThisNumber.thisNumber(number);
    }
}
