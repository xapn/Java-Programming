/**
 * 
 */
package xapn.projects.javaprogramming.annotation.meta.target;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Annotation only relevant to packages.
 * Package annotations must be in file package-info.java.
 * 
 * @author Xavier Pigeon
 */
@Target(ElementType.PACKAGE)
@interface PackageAnnotation {}
