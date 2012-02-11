/**
 * 
 */
package xapn.projects.javaprogramming.annotation.customized.emptyconstructor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

/**
 * <code>@EmptyConstructor</code> Annotation, used to mark a class that has to
 * have an empty constructor and to verify this during compilation.
 * 
 * @author Xavier Pigeon
 */
@Inherited
@Documented
@Target(ElementType.TYPE)
public @interface EmptyConstructor {}
