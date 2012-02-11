/**
 * 
 */
package xapn.projects.javaprogramming.annotation.customized.emptyconstructor.apt;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import xapn.projects.javaprogramming.annotation.customized.emptyconstructor.EmptyConstructor;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.apt.AnnotationProcessors;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

/**
 * @author Xavier Pigeon
 */
public class EmptyConstructorAnnotationProcessorFactory implements AnnotationProcessorFactory {
    
    /** Collection containing the name of the supported annotations. */
    protected Collection<String> supportedAnnotationTypes = Arrays.asList(EmptyConstructor.class.getName());
    
    /** Collection of the supported options. */
    protected Collection<String> supportedOptions = Collections.emptyList();
    
    /**
     * Return the AnnotationProcessor related to this Factory...
     */
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> atds, AnnotationProcessorEnvironment env) {
        // If there is no annotation, an "empty" processor is returned.
        if (atds.isEmpty()) {
            return AnnotationProcessors.NO_OP;
        }
        return new EmptyConstructorAnnotationProcessor(env);
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
        return supportedOptions;
    }
}
