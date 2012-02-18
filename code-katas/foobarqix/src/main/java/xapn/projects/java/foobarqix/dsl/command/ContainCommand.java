/**
 * 
 */
package xapn.projects.java.foobarqix.dsl.command;

import xapn.projects.java.foobarqix.dsl.FooBarQixDSL;

/**
 * Contain Command.
 * 
 * @author Xavier Pigeon
 */
public class ContainCommand extends AbstractCommand {
    
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
