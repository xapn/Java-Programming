/**
 * 
 */
package xapn.projects.javaprogramming.annotation.meta.retention;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation with a runtime retention policy.
 * 
 * @author Xavier Pigeon
 */
@Retention(RetentionPolicy.RUNTIME)
@interface RuntimeAnnotation {}
