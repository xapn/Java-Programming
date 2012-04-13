/**
 * 
 */
package xapn.javapro.foobarqix;

import static xapn.javapro.foobarqix.dsl.FooBarQix.eachNumber;
import static xapn.javapro.foobarqix.dsl.FooBarQix.eachNumberBetween;
import static xapn.javapro.foobarqix.dsl.FooBarQix.thisNumber;

/**
 * FooBarQix in action!
 * 
 * @author Xavier Pigeon
 */
public class FooBarQixInAction {
    
    /**
     * FooBarQix in action!
     * 
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(thisNumber(51).isDivisibleBy(3).isDivisibleBy(5).isDivisibleBy(7).contains(3, 5, 7)
                .fooBarQix());
        
        System.out.println();
        
        System.out.println(eachNumberBetween(1, 100).isDivisibleBy(3).isDivisibleBy(5).isDivisibleBy(7)
                .contains(3, 5, 7).fooBarQix());
        
        System.out.println();
        
        System.out.println(eachNumber().between(1).and(100).isDivisibleBy(3).isDivisibleBy(5).isDivisibleBy(7)
                .contains(3, 5, 7).fooBarQix());
    }
}