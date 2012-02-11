/**
 * 
 */
package xapn.projects.javaprogramming.annotation.meta.documented;

/**
 * The annotation of the method 2 will be in the javadoc documentation of this
 * class, the annotation of the method 1 will not.
 * 
 * @author Xavier Pigeon
 */
public class DocumentedExample {
    
    /**
     * Comment of the method 1.
     */
    @SimpleAnnotation
    public void method1() {
        /* ... */
    }
    
    /**
     * Comment of the method 2.
     */
    @DocumentedAnnotation
    public void method2() {
        /* ... */
    }
}
