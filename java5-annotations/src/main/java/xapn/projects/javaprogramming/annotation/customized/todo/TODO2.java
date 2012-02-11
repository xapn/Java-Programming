/**
 * 
 */
package xapn.projects.javaprogramming.annotation.customized.todo;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <p>
 * This annotation will mark any uncompleted source code.<br/>
 * Meta-annotations used:
 * <ul>
 * <li>@Documented: yes, we want to know which source code remains to do in the
 * javadoc.</li>
 * <li>@Inherited: no, the subclasses have not to be impacted.</li>
 * <li>@Retention: yes, the annotation is not necessary in the *.class files,
 * neither to be read by the JVM.</li>
 * <li>@Target: no, any element kind can be marked.</li>
 * </ul>
 * </p>
 * <p>
 * The @TODO2 annotation has two members, that are mandatory when using this
 * annotation each time.
 * </p>
 * 
 * @author Xavier Pigeon
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
public @interface TODO2 {
    
    /**
     * Enumeration for the criticality levels
     * 
     * @author Xavier Pigeon
     */
    static enum Level2 {
        MINOR, NORMAL, MAJOR
    }
    
    /**
     * Criticality level
     * 
     * @return the criticality level
     */
    Level2 level();
    
    /**
     * What to do?
     * If an annotation has only one member whose the name is "value()", then we
     * can not give the attribute name when using the annotation.
     * 
     * @return what to do
     */
    String what();
}
