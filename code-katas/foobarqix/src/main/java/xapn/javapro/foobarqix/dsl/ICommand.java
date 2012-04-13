package xapn.javapro.foobarqix.dsl;

/**
 * Interface for command encapsulating a DSL operation.
 * 
 * @author Xavier Pigeon
 */
public interface ICommand {
    
    /**
     * Apply the command to the DSL.
     */
    void execute();
}
