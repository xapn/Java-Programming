/**
 * 
 */
package xapn.projects.java.foobarqix;

import static xapn.projects.java.foobarqix.dsl.FooBarQix.eachNumberBetween;
import static xapn.projects.java.foobarqix.dsl.FooBarQix.thisNumber;

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
                .getText());
        
        System.out.println(eachNumberBetween(1, 100).isDivisibleBy(3).isDivisibleBy(5).isDivisibleBy(7)
                .contains(3, 5, 7).getText());
    }
}
