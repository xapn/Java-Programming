/**
 * 
 */
package xapn.javapro.foobarqix.dsl;

import java.util.HashMap;
import java.util.Map;

/**
 * Rule Policy.
 * 
 * @author Xavier Pigeon
 */
class RulePolicy {
    
    private static final String QIX = "Qix";
    private static final String BAR = "Bar";
    private static final String FOO = "Foo";
    protected Map<Integer, String> rules;
    
    /**
     * Constructor.
     */
    public RulePolicy() {
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
    
    /**
     * Setter for the field {@code rules}
     * 
     * @param rules the rules to set
     */
    void setRules(Map<Integer, String> rules) {
        this.rules = rules;
    }
}
