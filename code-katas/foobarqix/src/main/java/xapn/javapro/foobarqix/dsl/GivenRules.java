/**
 * 
 */
package xapn.javapro.foobarqix.dsl;

import java.util.Map;

/**
 * FooBarQix DSL element.</br>
 * "Given rules..."
 * 
 * @author Xavier Pigeon
 */
public class GivenRules {
    
    private Map<Integer, String> rules;
    
    /**
     * Default constructor.
     * 
     * @param rules the rules to be applied
     */
    GivenRules(Map<Integer, String> rules) {
        this.rules = rules;
    }
    
    /**
     * Apply the given rules to each number into a range.
     * 
     * @return a {@link Between} object
     */
    public Between eachNumber() {
        return new Between(rules);
    }
    
    /**
     * Apply the given rules to this number.
     * 
     * @return a {@link ThisNumber} object
     */
    public ThisNumber thisNumber(int number) {
        return ThisNumber.thisNumber(number).withRules(rules);
    }
}
