/**
 * 
 */
package xapn.projects.javaprogramming.annotation.customized.todo.apt;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.Declaration;
import com.sun.mirror.util.DeclarationVisitor;
import com.sun.mirror.util.DeclarationVisitors;

/**
 * Annotation processor created by the factory and used by the APT to process
 * source code files.
 * 
 * @author Xavier Pigeon
 */
public class TodoAnnotationProcessor implements AnnotationProcessor {
    
    /** The environment of the annotation processor. */
    protected final AnnotationProcessorEnvironment environment;
    
    /**
     * Constructor.
     * The environment is passed on by the Factory.
     * 
     * @param environment The environment of the annotation processor.
     */
    public TodoAnnotationProcessor(AnnotationProcessorEnvironment environment) {
        this.environment = environment;
    }
    
    /**
     * Process the source code files.
     * This method is called by the APT once to process the annotations.
     */
    public void process() {
        // Instantiation of the Visitor
        DeclarationVisitor todoVisitor = new TodoVisitor(environment);
        
        // Iteration for all the Annotations: one looks down the list of the
        // type declarations.
        for (Declaration d : environment.getTypeDeclarations()) {
            
            // With the "accept" method, one visits each of the found
            // declarations:
            d.accept(DeclarationVisitors.getSourceOrderDeclarationScanner(todoVisitor, DeclarationVisitors.NO_OP));
        }
    }
}
