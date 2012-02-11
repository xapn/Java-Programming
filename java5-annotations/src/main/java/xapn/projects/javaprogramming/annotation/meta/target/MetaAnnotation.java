/**
 * 
 */
package xapn.projects.javaprogramming.annotation.meta.target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Annotation only relevant to annotations.
 * 
 * @author Xavier Pigeon
 */
@Target(ElementType.ANNOTATION_TYPE)
@interface MetaAnnotation {}
