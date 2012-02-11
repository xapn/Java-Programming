/**
 * 
 */
package xapn.projects.javaprogramming.annotation.customized.todo.apt;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import xapn.projects.javaprogramming.annotation.customized.todo.TODO;
import xapn.projects.javaprogramming.annotation.customized.todo.TODOs;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.apt.AnnotationProcessors;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

/**
 * Factory related to the <code>@TODO</code> annotation and used by the APT.
 * 
 * @author Xavier Pigeon
 */
public class TodoAnnotationProcessorFactory implements AnnotationProcessorFactory {
    
    /** Option from the command line that can activate the "release" mode */
    static final String RELEASE = "-Arelease";
    
    /** Collection containing the name of the supported annotations. */
    protected Collection<String> supportedAnnotationTypes = Arrays.asList(TODO.class.getName(), TODOs.class.getName());
    
    /** Collection of the supported options. */
    protected Collection<String> supportedOptions = Arrays.asList(RELEASE);
    
    /**
     * Return the AnnotationProcessor related to this Factory...
     */
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> atds, AnnotationProcessorEnvironment env) {
        // If there is no annotation, an "empty" processor is returned.
        if (atds.isEmpty()) {
            return AnnotationProcessors.NO_OP;
        }
        return new TodoAnnotationProcessor(env);
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
