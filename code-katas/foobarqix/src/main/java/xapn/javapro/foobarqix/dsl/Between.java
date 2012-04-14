package xapn.javapro.foobarqix.dsl;

import static xapn.javapro.foobarqix.dsl.EachNumber.eachNumberBetween;

import java.util.Map;

/**
 * FooBarQix DSL element.
 * 
 * @author Xavier Pigeon
 */
public class Between {
    
    /**
     * FooBarQix DSL element.
     * 
     * @author Xavier Pigeon
     */
    public class And {
        
        private int start;
        
        /**
         * Each number between... and...
         * 
         * @param end the end number
         * @return an {@link EachNumber} object
         */
        public EachNumber and(int end) {
            EachNumber eachNumber = eachNumberBetween(start, end);
            
            if (rules != null) {
                eachNumber.withRules(rules);
            }
            
            return eachNumber;
        }
    }
    
    private Map<Integer, String> rules;
    
    /**
     * Default constructor.
     */
    public Between() {}
    
    /**
     * Constructor.
     * 
     * @param rules the rules to be applied
     */
    Between(Map<Integer, String> rules) {
        this.rules = rules;
    }
    
    /**
     * Each number between...
     * 
     * @param start the start number
     * @return an {@link And} object
     */
    public And between(int start) {
        And and = new And();
        and.start = start;
        return and;
    }
}
