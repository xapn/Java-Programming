/**
 * 
 */
package xapn.projects.java.foobarqix.dsl.command;

import java.util.Arrays;

import xapn.projects.java.foobarqix.dsl.FooBarQixDSL;

/**
 * Command.
 * 
 * @author Xavier Pigeon
 */
public class Command {
    
    /**
     * Operation enumeration.
     * 
     * @author Xavier Pigeon
     */
    public enum OperationEnum {
        CONTAIN, DIVISE;
    }
    
    private OperationEnum operation;
    private int[] criteria;
    
    /**
     * Constructor.
     * 
     * @param operation
     * @param criteria
     */
    public Command(OperationEnum operation, int... criteria) {
        this.operation = operation;
        this.criteria = criteria;
    }
    
    /**
     * Apply the command.
     * 
     * @param dsl a {@link FooBarQixDSL} object
     */
    public void apply(FooBarQixDSL dsl) {
        switch (operation) {
        case CONTAIN:
            dsl.contains(criteria);
            break;
        case DIVISE:
            dsl.isDivisibleBy(criteria[0]);
            break;
        }
    }
    
    /**
     * Getter for the field {@code criteria}
     * 
     * @return the criteria
     */
    public int[] getCriteria() {
        return criteria;
    }
    
    /**
     * Getter for the field {@code operation}
     * 
     * @return the operation
     */
    public OperationEnum getOperation() {
        return operation;
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
     * Setter for the field {@code operation}
     * 
     * @param operation the operation to set
     */
    public void setOperation(OperationEnum operation) {
        this.operation = operation;
    }
    
    @Override
    public String toString() {
        return operation.toString() + " with criteria: " + Arrays.toString(criteria);
    }
}
