/**
 * 
 */
package xapn.projects.java.foobarqix.dsl;

import java.util.HashMap;
import java.util.Map;

/**
 * Abstract FooBarQix DSL.
 * 
 * @author Xavier Pigeon
 */
public abstract class AbstractFooBarQixDSL {
    
    protected Map<Integer, String> rules;
    
    /**
     * Constructor.
     */
    public AbstractFooBarQixDSL() {
        rules = new HashMap<Integer, String>();
        rules.put(3, "Foo");
        rules.put(5, "Bar");
        rules.put(7, "Qix");
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
