/**
 * 
 */
package xapn.projects.javaprogramming.annotation.meta.retention;

import java.lang.annotation.Annotation;

/**
 * Example of a class annotated with annotations with different retention
 * policies.
 * 
 * @author Xavier Pigeon
 */
@SourceAnnotation
@ClassAnnotation
@RuntimeAnnotation
class RetentionExample {
    
    public static void main(String[] args) {
        System.out.println("Annotation list of the " + RetentionExample.class.getName() + " class:");
        
        for (Annotation annotation : RetentionExample.class.getAnnotations()) {
            System.out.println("\tAnnotation: " + annotation.annotationType().getName());
        }
    }
}
