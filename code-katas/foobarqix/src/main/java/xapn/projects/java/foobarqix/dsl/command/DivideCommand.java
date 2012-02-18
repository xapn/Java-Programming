/**
 * 
 */
package xapn.projects.java.foobarqix.dsl.command;

import xapn.projects.java.foobarqix.dsl.FooBarQixDSL;

/**
 * Divide Command.
 * 
 * @author Xavier Pigeon
 */
public class DivideCommand extends AbstractCommand {
    
    /**
     * Constructor.
     * 
     * @param divisor the eventual divisor
     */
    public DivideCommand(FooBarQixDSL dsl, int divisor) {
        super(dsl, divisor);
    }
    
    @Override
    public void execute() {
        dsl.isDivisibleBy(criteria[0]);
    }
    
    @Override
    public String toString() {
        return dsl.getNumber() + " contains: " + super.toString();
    }
}
