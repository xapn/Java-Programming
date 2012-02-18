/**
 * 
 */
package xapn.projects.java.foobarqix.dsl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import xapn.projects.java.foobarqix.dsl.command.Command;

/**
 * FooBarQix DSL applicable to a numeric range.
 * 
 * @author Xavier Pigeon
 */
public class FooBarQixRangeDSL extends AbstractFooBarQixDSL {
    
    private static final String SEPARATOR = "\n";
    
    /**
     * Initiate a DSL-based phrase for each integer into the range.
     * 
     * @param start the range start
     * @param end the end range
     * @return a {@link FooBarQixRangeDSL} object
     */
    static FooBarQixRangeDSL eachNumberBetween(int start, int end) {
        FooBarQixRangeDSL rangeDsl = new FooBarQixRangeDSL();
        rangeDsl.start = start;
        rangeDsl.end = end;
        
        return rangeDsl;
    }
    
    private int start;
    private int end;
    private FooBarQixDSL dsl;
    private List<Command> commands;
    
    /**
     * Default constructor.
     */
    FooBarQixRangeDSL() {
        dsl = new FooBarQixDSL();
        commands = new ArrayList<Command>();
    }
    
    /**
     * Build the text resulting from the recorded command sequence, according to
     * the numeric range and the DSL rules.
     */
    private void build() {
        for (int current = start; current <= end; current++) {
            dsl.setNumber(current);
            for (Command command : commands) {
                command.apply(dsl);
            }
            
            if (!dsl.isNumberReplaced()) {
                dsl.getSubstitution().append(current);
            }
            if (current < end) {
                dsl.getSubstitution().append(SEPARATOR);
            }
        }
    }
    
    /**
     * Apply the textual transformation of the numeric range according to the
     * DSL rules if the range numbers contain one of the given digits.
     * 
     * @param digits the digits that will cause the transformation if a number
     *            contains one of them
     * @return the {@link FooBarQixRangeDSL} object for chaining method calls
     */
    public FooBarQixRangeDSL contains(int... digits) {
        commands.add(new Command(Command.OperationEnum.CONTAIN, digits));
        return this;
    }
    
    /**
     * Get the final text.
     * 
     * @return the result of the textual transformation
     */
    public String getText() {
        build();
        String builtResult = dsl.getText();
        dsl.setSubstitution(new StringBuilder());
        return builtResult;
    }
    
    /**
     * Apply the textual transformation of the numeric range according to the
     * DSL rules if the range numbers are divisible by a given divisor.
     * 
     * @param divisor the divisor by which the numbers will be attempted
     *            to divide
     * @return the {@link FooBarQixRangeDSL} object for chaining method calls
     */
    public FooBarQixRangeDSL isDivisibleBy(int divisor) {
        commands.add(new Command(Command.OperationEnum.DIVISE, divisor));
        return this;
    }
    
    @Override
    public String toString() {
        StringBuilder to = new StringBuilder();
        to.append("From: " + start);
        to.append(", to: " + end);
        
        for (Entry<Integer, String> rule : rules.entrySet()) {
            to.append("\n\t").append(rule.getKey()).append(" => ").append(rule.getValue());
        }
        for (Command command : commands) {
            to.append("\n\t").append(command.toString());
        }
        
        return to.toString();
    }
    
    /**
     * Change the rules that provide the string replacement for a given number.
     * 
     * @param rules the rules to be applied
     * @return the {@link FooBarQixDSL} object for chaining method calls
     */
    public FooBarQixRangeDSL withRules(Map<Integer, String> rules) {
        dsl.withRules(rules);
        return this;
    }
}
