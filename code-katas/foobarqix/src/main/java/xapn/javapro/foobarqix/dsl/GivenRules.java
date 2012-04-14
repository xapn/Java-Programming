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
    
    /**
     * Default constructor.
     * 
     * @param rules
     */
    GivenRules(Map<Integer, String> rules) {
        throw new RuntimeException("Not yet implemented");
    }
    
    /**
     * Apply the given rules to each number into a range.
     * 
     * @return a {@link Between} object
     */
    public Between eachNumber() {
        throw new RuntimeException("Not yet implemented");
    }
    
    /**
     * Apply the given rules to this number.
     * 
     * @return a {@link ThisNumber} object
     */
    public ThisNumber thisNumber(int number) {
        throw new RuntimeException("Not yet implemented");
    }
}
