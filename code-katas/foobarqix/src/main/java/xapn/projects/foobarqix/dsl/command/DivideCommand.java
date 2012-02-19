/**
 * 
 */
package xapn.projects.foobarqix.dsl.command;

import xapn.projects.foobarqix.dsl.FooBarQixDSL;
import xapn.projects.foobarqix.dsl.ICommand;

/**
 * Divide Command.
 * 
 * @author Xavier Pigeon
 */
public class DivideCommand extends AbstractCommand implements ICommand {
    
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
