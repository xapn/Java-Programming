/**
 * 
 */
package xapn.javapro.foobarqix.dsl;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract FooBarQix DSL.
 * 
 * @author Xavier Pigeon
 */
abstract class AbstractFooBarQixDSL {
    
    private static final String QIX = "Qix";
    private static final String BAR = "Bar";
    private static final String FOO = "Foo";
    protected Map<Integer, String> rules;
    
    /**
     * Constructor.
     */
    public AbstractFooBarQixDSL() {
        rules = new HashMap<Integer, String>();
        rules.put(3, FOO);
        rules.put(5, BAR);
        rules.put(7, QIX);
    }
    
    /**
     * Getter for the field {@code rules}
     * 
     * @return the rules
     */
    public Map<Integer, String> getRules() {
        return rules;
    }
}
