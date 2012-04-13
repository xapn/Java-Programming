/**
 * 
 */
package xapn.javapro.foobarqix.dsl.command;

import java.util.Arrays;

import xapn.javapro.foobarqix.dsl.ICommand;
import xapn.javapro.foobarqix.dsl.ThisNumber;

/**
 * Abstract Command.
 * 
 * @author Xavier Pigeon
 */
public abstract class AbstractCommand implements ICommand {
    
    protected ThisNumber thisNumber;
    protected int[] criteria;
    
    /**
     * Constructor.
     * 
     * @param operation
     * @param criteria
     */
    public AbstractCommand(ThisNumber thisNumber, int... criteria) {
        this.thisNumber = thisNumber;
        this.criteria = criteria;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void execute();
    
    /**
     * Getter for the field {@code criteria}
     * 
     * @return the criteria
     */
    public int[] getCriteria() {
        return criteria;
    }
    
    /**
     * Setter for the field {@code criteria}
     * 
     * @param criteria the criteria to set
     */
    public void setCriteria(int[] criteria) {
        this.criteria = criteria;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return Arrays.toString(criteria);
    }
}
