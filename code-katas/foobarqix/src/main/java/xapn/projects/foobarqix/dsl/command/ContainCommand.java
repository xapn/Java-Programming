/**
 * 
 */
package xapn.projects.foobarqix.dsl.command;

import xapn.projects.foobarqix.dsl.FooBarQixDSL;
import xapn.projects.foobarqix.dsl.ICommand;

/**
 * Contain Command.
 * 
 * @author Xavier Pigeon
 */
public class ContainCommand extends AbstractCommand implements ICommand {
    
    /**
     * Constructor.
     * 
     * @param digits the digits eventually contained
     */
    public ContainCommand(FooBarQixDSL dsl, int... digits) {
        super(dsl, digits);
    }
    
    @Override
    public void execute() {
        dsl.contains(criteria);
    }
    
    @Override
    public String toString() {
        return dsl.getNumber() + " divisible by: " + super.toString();
    }
}
