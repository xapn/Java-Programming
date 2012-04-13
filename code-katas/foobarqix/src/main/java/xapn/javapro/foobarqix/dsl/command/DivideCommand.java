/**
 * 
 */
package xapn.javapro.foobarqix.dsl.command;

import xapn.javapro.foobarqix.dsl.ICommand;
import xapn.javapro.foobarqix.dsl.ThisNumber;

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
    public DivideCommand(ThisNumber thisNumber, int divisor) {
        super(thisNumber, divisor);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void execute() {
        thisNumber.isDivisibleBy(criteria[0]);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return thisNumber.getNumber() + " may contain: " + super.toString();
    }
}
