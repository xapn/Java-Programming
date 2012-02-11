/**
 * 
 */
package xapn.projects.javaprogramming.annotation.customized.todo;

/**
 * <p>
 * <code>@TODOs</code> Annotation
 * </p>
 * <p>
 * It is not possible to annotate the same element with the same annotation
 * several times.</br> To solve this problem, an annotation-container may be
 * used: it must contain a table of annotations.
 * </p>
 * 
 * @author Xavier Pigeon
 */
public @interface TODOs {
    
    /**
     * Table of different @TODO annotations
     * 
     * @return all the @TODO annotations
     */
    TODO[] value();
}
