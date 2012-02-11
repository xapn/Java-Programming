/**
 * 
 */
package xapn.projects.javaprogramming.annotation.customized.emptyconstructor.apt;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.Declaration;
import com.sun.mirror.util.DeclarationVisitor;
import com.sun.mirror.util.DeclarationVisitors;

/**
 * Annotation processor of the <code>@EmptyConstructor</code annotation.
 * 
 * @author Xavier Pigeon
 */
public class EmptyConstructorAnnotationProcessor implements AnnotationProcessor {
    
    protected final AnnotationProcessorEnvironment environment;
    
    /**
     * Constructor.
     * 
     * @param environment The environment of the annotation processor.
     */
    public EmptyConstructorAnnotationProcessor(AnnotationProcessorEnvironment environment) {
        this.environment = environment;
    }
    
    /**
     * Process the <code>@EmptyConstructor</code> annotation.
     */
    public void process() {
        DeclarationVisitor emptyConstructorVisitor = new EmptyConstructorVisitor(environment);
        
        for (Declaration d : environment.getTypeDeclarations()) {
            d.accept(DeclarationVisitors.getSourceOrderDeclarationScanner(emptyConstructorVisitor,
                    DeclarationVisitors.NO_OP));
        }
    }
}
