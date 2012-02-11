/**
 * 
 */
package xapn.projects.javaprogramming.annotation.meta.target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import xapn.projects.javaprogramming.annotation.meta.target.Examples.TypeAnnotation;

/**
 * Examples of using annotations relevant to different element types.
 * By default, an annotation is relevant to any element types. Some restrictions
 * can be put with the @Target annotation.
 * 
 * @author Xavier Pigeon
 */
@TypeAnnotation
public class Examples {
    
    /**
     * Annotation only relevant to constructors.
     */
    @Target(ElementType.CONSTRUCTOR)
    @interface ConstructorAnnotation {}
    
    /**
     * Annotation only relevant to fields and local variables.
     */
    @Target({ ElementType.FIELD, ElementType.LOCAL_VARIABLE })
    @interface FieldAndLocalVariableAnnotation {}
    
    /**
     * Annotation only relevant to methods.
     */
    @Target(ElementType.METHOD)
    @interface MethodAnnotation {}
    
    /**
     * Annotation only relevant to parameters.
     */
    @Target(ElementType.PARAMETER)
    @interface ParameterAnnotation {}
    
    /**
     * Annotation only relevant to any type declaration: class, interface, enum.
     */
    @Target(ElementType.TYPE)
    @interface TypeAnnotation {}
    
    /**
     * An annotated field.
     */
    @FieldAndLocalVariableAnnotation
    private int intField;
    
    @FieldAndLocalVariableAnnotation
    private static double staticField;
    
    /**
     * An annotated constructor.
     */
    @ConstructorAnnotation
    public Examples() {}
    
    /**
     * An annotated method.
     */
    @MethodAnnotation
    public void annotatedMethod() {}
    
    /**
     * This method contains an annotated local variable.
     * 
     * @return true
     */
    public boolean methodWithAnnotatedLocalVariable() {
        @FieldAndLocalVariableAnnotation
        boolean flag = true;
        
        return flag;
    }
    
    /**
     * The parameter1 of this method is annotated.
     * 
     * @param parameter1 the annotated parameter
     * @param parameter2 the not annotated parameter
     */
    public void methodWithAnnotatedParameter(@ParameterAnnotation Object parameter1, Object parameter2) {}
}
