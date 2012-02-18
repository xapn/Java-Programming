/**
 * 
 */
package xapn.projects.java.foobarqix.dsl.command;

import java.util.Arrays;

import xapn.projects.java.foobarqix.dsl.FooBarQixDSL;

/**
 * Abstract Command.
 * 
 * @author Xavier Pigeon
 */
public abstract class AbstractCommand {
    
    protected FooBarQixDSL dsl;
    protected int[] criteria;
    
    /**
     * Constructor.
     * 
     * @param operation
     * @param criteria
     */
    public AbstractCommand(FooBarQixDSL dsl, int... criteria) {
        this.dsl = dsl;
        this.criteria = criteria;
    }
    
    /**
     * Apply the command to the DSL.
     */
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
    
    @Override
    public String toString() {
        return Arrays.toString(criteria);
    }
}
