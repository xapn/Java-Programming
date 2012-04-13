/**
 * 
 */
package xapn.javapro.foobarqix.dsl.command;

import xapn.javapro.foobarqix.dsl.ICommand;
import xapn.javapro.foobarqix.dsl.ThisNumber;

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
    public ContainCommand(ThisNumber thisNumber, int... digits) {
        super(thisNumber, digits);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        thisNumber.contains(criteria);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return thisNumber.getNumber() + " may be divisible by: " + super.toString();
    }
}
