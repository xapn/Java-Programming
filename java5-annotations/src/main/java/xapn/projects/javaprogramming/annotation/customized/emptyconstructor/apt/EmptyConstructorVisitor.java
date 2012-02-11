/**
 * 
 */
package xapn.projects.javaprogramming.annotation.customized.emptyconstructor.apt;

import java.lang.annotation.Annotation;

import xapn.projects.javaprogramming.annotation.customized.emptyconstructor.EmptyConstructor;

import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.ClassDeclaration;
import com.sun.mirror.declaration.ConstructorDeclaration;
import com.sun.mirror.declaration.InterfaceDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;
import com.sun.mirror.type.InterfaceType;
import com.sun.mirror.util.DeclarationVisitor;
import com.sun.mirror.util.SimpleDeclarationVisitor;

/**
 * <code>@EmptyConstructor</code> Visitor.
 * 
 * @author Xavier Pigeon
 */
public class EmptyConstructorVisitor extends SimpleDeclarationVisitor implements DeclarationVisitor {
    
    protected final AnnotationProcessorEnvironment environment;
    
    /**
     * Constructor.
     * 
     * @param environment the annotation processor environment
     */
    public EmptyConstructorVisitor(AnnotationProcessorEnvironment environment) {
        this.environment = environment;
    }
    
    /**
     * Recursively search if any of the implemented interfaces is
     * <code>@EmptyConstructor</code> annotated.</br>
     * Indeed, the annotations of the interfaces are not inherited.
     * 
     * @param typeDeclaration the base type of the research
     * @param annotationClass the class of the annotation to be searched
     * @return <b>true</b> if an annotation of the <b>annotationClass</b> type
     *         is found, <b>false</b> otherwise.
     */
    public boolean hasAnnotation(TypeDeclaration typeDeclaration, Class<? extends Annotation> annotationClass) {
        boolean emptyConstructorAnnotated = false;
        
        if (typeDeclaration.getAnnotation(EmptyConstructor.class) != null) {
            emptyConstructorAnnotated = true;
        } else {
            // For each directly implemented interface:
            for (InterfaceType interfaceType : typeDeclaration.getSuperinterfaces()) {
                InterfaceDeclaration superInterface = interfaceType.getDeclaration();
                
                // If the interface is @EmptyConstructor annotated
                if (superInterface.getAnnotation(EmptyConstructor.class) != null) {
                    emptyConstructorAnnotated = true;
                    break;
                }
                // If the parent interface is @EmptyConstructor annotated
                else if (hasAnnotation(superInterface, annotationClass)) {
                    emptyConstructorAnnotated = true;
                    break;
                }
            }
        }
        
        return emptyConstructorAnnotated;
    }
    
    /**
     * This method means that the class declaration parameter has an empty
     * constructor.
     * 
     * @param classDeclaration the class declaration to be analyzed
     * @return true if the class has an empty constructor, false otherwise
     */
    public boolean hasEmptyConstructor(ClassDeclaration classDeclaration) {
        boolean emptyConstructorFound = false;
        
        // For each constructor of the class:
        for (ConstructorDeclaration constructor : classDeclaration.getConstructors()) {
            // If an empty constructor has been found
            if (constructor.getParameters().isEmpty()) {
                emptyConstructorFound = true;
                break;
            }
        }
        
        return emptyConstructorFound;
    }
    
    /**
     * Method called for each class declaration.
     */
    @Override
    public void visitClassDeclaration(ClassDeclaration classDeclaration) {
        
        // If the @EmptyConstructor annotation is found and the class has no
        // empty constructor, then an error message is displayed.
        if (hasAnnotation(classDeclaration, EmptyConstructor.class) && !hasEmptyConstructor(classDeclaration)) {
            environment.getMessager().printError(classDeclaration.getPosition(),
                    "An empty constructor is required by @EmptyConstructor.");
        }
    }
}
