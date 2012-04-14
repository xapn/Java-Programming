/**
 * 
 */
package xapn.javapro.foobarqix.dsl;

import java.util.Map;

/**
 * FooBarQix DSL element applicable to one number at a time.
 * 
 * @author Xavier Pigeon
 */
public class ThisNumber {
    
    private static final int DEFAULT_NUMBER = -1;
    
    /**
     * This factory method initiates a DSL-based phrase for a given number.
     * 
     * @param number the number to be analyzed
     * @return a {@link ThisNumber} object
     */
    static ThisNumber thisNumber(int number) {
        ThisNumber thisNumber = new ThisNumber();
        thisNumber.setNumber(number);
        return thisNumber;
    }
    
    private int number;
    private StringBuilder substitution;
    private boolean numberReplaced = false;
    private RulePolicy rulePolicy;
    
    /**
     * Default constructor.
     */
    ThisNumber() {
        numberReplaced = false;
        substitution = new StringBuilder();
        setNumber(DEFAULT_NUMBER);
        rulePolicy = new RulePolicy();
    }
    
    /**
     * Apply the textual transformation of the {@code number} according to the
     * DSL rules if the {@code number} contains one of the given digits.
     * 
     * @param digits the digits that will cause the transformation if the
     *            {@code number} contains one of them
     * @return the {@link ThisNumber} object for chaining method calls
     */
    public ThisNumber contains(int... digits) {
        String numberSequence = Integer.toString(number);
        
        for (int sequenceIndex = 0; sequenceIndex < numberSequence.length(); sequenceIndex++) {
            for (int digitIndex = 0; digitIndex < digits.length; digitIndex++) {
                if (numberSequence.subSequence(sequenceIndex, sequenceIndex + 1).equals(
                        String.valueOf(digits[digitIndex]))
                        && rulePolicy.getRules().containsKey(digits[digitIndex])) {
                    substitution.append(rulePolicy.getRules().get(digits[digitIndex]));
                    numberReplaced = true;
                }
            }
        }
        
        return this;
    }
    
    /**
     * Get the final text, after the last DSL operation was over. After that, it
     * will be impossible to apply any additional operation.
     * 
     * @return the result of the textual transformation
     */
    public String fooBarQix() {
        next();
        return textAndClean();
    }
    
    /**
     * Getter for the field {@code number}
     * 
     * @return the number
     */
    public int getNumber() {
        return number;
    }
    
    /**
     * Get the rules.
     * 
     * @return the rules to be applied
     */
    Map<Integer, String> getRules() {
        return rulePolicy.getRules();
    }
    
    /**
     * Getter for the field {@code substitution}
     * 
     * @return the substitution
     */
    StringBuilder getSubstitution() {
        return substitution;
    }
    
    /**
     * Get the text in its current state. At this stage and after that, it
     * remains possible to apply some additional operations.
     * 
     * @return the result of the textual transformation
     */
    public String getText() {
        return substitution.toString();
    }
    
    /**
     * Apply the textual transformation of the {@code number} according to the
     * DSL rules if the {@code number} is divisible by a given divisor.
     * 
     * @param divisor the divisor by which the {@code number} will be attempted
     *            to divide
     * @return the {@link ThisNumber} object
     */
    public ThisNumber isDivisibleBy(int divisor) {
        if (((number % divisor) == 0) && rulePolicy.getRules().containsKey(divisor)) {
            substitution.append(rulePolicy.getRules().get(divisor));
            numberReplaced = true;
        }
        
        return this;
    }
    
    /**
     * Getter for the field {@code numberReplaced}
     * 
     * @return the numberReplaced
     */
    boolean isNumberReplaced() {
        return numberReplaced;
    }
    
    /**
     * Prepare the DSL to process another number before changing and
     * transforming.
     */
    void next() {
        // If the number has not been transformed, it must be copied.
        if (!isNumberReplaced()) {
            substitution.append(number);
        }
    }
    
    /**
     * Setter for the field {@code number}
     * 
     * @param number the number to set
     */
    void setNumber(int number) {
        this.number = number;
        numberReplaced = false;
        
        if (substitution == null) {
            substitution = new StringBuilder();
        }
    }
    
    /**
     * Set the rules
     * 
     * @param rules the rules to be applied
     */
    void setRules(Map<Integer, String> rules) {
        rulePolicy.setRules(rules);
    }
    
    /**
     * Setter for the field {@code substitution}
     * 
     * @param substitution the substitution to set
     */
    void setSubstitution(StringBuilder substitution) {
        this.substitution = substitution;
    }
    
    /**
     * Get the text in its current state and clean it. After that, it will be
     * impossible to apply any additional operation.
     * 
     * @return the result of the textual transformation
     */
    String textAndClean() {
        String text = substitution.toString();
        substitution = null;
        return text;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Number: " + number;
    }
    
    /**
     * Change the rules that provide the string replacement for a given number.
     * 
     * @param rules the rules to be applied
     * @return the {@link ThisNumber} object for chaining method calls
     */
    ThisNumber withRules(Map<Integer, String> rules) {
        rulePolicy.setRules(rules);
        return this;
    }
}
