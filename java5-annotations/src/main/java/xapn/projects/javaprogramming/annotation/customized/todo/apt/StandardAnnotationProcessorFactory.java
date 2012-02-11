/**
 * 
 */
package xapn.projects.javaprogramming.annotation.customized.todo.apt;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.apt.AnnotationProcessors;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

/**
 * Factory related to the standard, <code>@TODO1</code> and <code>@TODO2</code>
 * annotations.
 * 
 * @author Xavier Pigeon
 */
public class StandardAnnotationProcessorFactory implements AnnotationProcessorFactory {
    
    /** Collection containing the name of the supported annotations. */
    protected Collection<String> supportedAnnotationTypes = Arrays.asList(
            // Standard Annotations
            "java.lang.*",
            // Meta-Annotations
            "java.lang.annotation.*",
            // Customized annotations
            "xapn.projects.javaprogramming.annotation.customized.todo.TODO1",
            "xapn.projects.javaprogramming.annotation.customized.todo.TODO2");
    
    /**
     * Return the AnnotationProcessors.NO_OP (No processing).
     */
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> atds, AnnotationProcessorEnvironment env) {
        return AnnotationProcessors.NO_OP;
    }
    
    /**
     * Return the list of the annotations supported by this Factory.
     */
    public Collection<String> supportedAnnotationTypes() {
        return supportedAnnotationTypes;
    }
    
    /**
     * Return the list of the options supported by this Factory.
     */
    public Collection<String> supportedOptions() {
        return Collections.emptyList();
    }
}
