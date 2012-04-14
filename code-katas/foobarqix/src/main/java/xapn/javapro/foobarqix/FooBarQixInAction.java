/**
 * 
 */
package xapn.javapro.foobarqix;

import static xapn.javapro.foobarqix.dsl.FooBarQix.eachNumber;
import static xapn.javapro.foobarqix.dsl.FooBarQix.eachNumberBetween;
import static xapn.javapro.foobarqix.dsl.FooBarQix.givenRules;
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
        System.out.println( //
                thisNumber(51) //
                        .isDivisibleBy(3).isDivisibleBy(5).isDivisibleBy(7) //
                        .contains(3).contains(5).contains(7) //
                        .fooBarQix());
        
        separate();
        System.out.println( //
                givenRules(new Object[][] { { 3, "Foo" }, { 5, "Bar" }, { 7, "Qix" } }) //
                        .thisNumber(51) //
                        .isDivisibleBy(3).isDivisibleBy(5).isDivisibleBy(7).contains(3, 5, 7) //
                        .fooBarQix());
        
        separate();
        System.out.println( //
                eachNumberBetween(1, 10) //
                        .isDivisibleBy(3).isDivisibleBy(5).isDivisibleBy(7).contains(3, 5, 7) //
                        .fooBarQix());
        
        separate();
        System.out.println( //
                eachNumber().between(1).and(100) //
                        .isDivisibleBy(3).isDivisibleBy(5).isDivisibleBy(7).contains(3, 5, 7) //
                        .fooBarQix());
        
        separate();
        System.out.println( //
                givenRules(new Object[][] { { 2, "Foo" }, { 3, "Bar" }, { 5, "Qix" }, { 7, "Fum" } }) //
                        .eachNumber().between(1).and(10) //
                        .isDivisibleBy(2).isDivisibleBy(3).isDivisibleBy(5).isDivisibleBy(7) //
                        .contains(2, 3, 5, 7) //
                        .fooBarQix());
    }
    
    private static void separate() {
        System.out.println("---------------------");
    }
}
