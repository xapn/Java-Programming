/**
 * 
 */
package xapn.projects.java.foobarqix.dsl;

/**
 * FooBarQix utility.
 * 
 * @author Xavier Pigeon
 */
public class FooBarQix {
    
    /**
     * Initiate a DSL-based phrase for each integer into the range.
     * 
     * @param start the range start
     * @param end the end range
     * @return a {@link FooBarQixRangeDSL} object
     */
    public static FooBarQixRangeDSL eachNumberBetween(int start, int end) {
        return FooBarQixRangeDSL.eachNumberBetween(start, end);
    }
    
    /**
     * Initiate a DSL-based phrase for a given number.
     * 
     * @param number the number to be analyzed
     * @return a {@link FooBarQixDSL} object
     */
    public static FooBarQixDSL thisNumber(int number) {
        return FooBarQixDSL.thisNumber(number);
    }
}
