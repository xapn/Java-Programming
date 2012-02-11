/**
 * 
 */
package xapn.projects.javaprogramming.annotation.customized.example;

import xapn.projects.javaprogramming.annotation.customized.todo.TODO;
import xapn.projects.javaprogramming.annotation.customized.todo.TODO.Level;
import xapn.projects.javaprogramming.annotation.customized.todo.TODO1;
import xapn.projects.javaprogramming.annotation.customized.todo.TODO2;
import xapn.projects.javaprogramming.annotation.customized.todo.TODO2.Level2;
import xapn.projects.javaprogramming.annotation.customized.todo.TODOs;

/**
 * Examples of using the customized.todo.TODO* annotations.
 * 
 * @author Xavier Pigeon
 */
class TodoExamples {
    
    /**
     * What to do with <code>@TODO1</code>.
     */
    @TODO1(value = "Something that has to be done")
    void doSomething1() {}
    
    /**
     * What to do with <code>@TODO1</code>.</br>
     * If an annotation has only one member whose the name is "value()", then we
     * can not give the attribute name when using the annotation.
     */
    @TODO1("Something that has to be done")
    void doSomething2() {}
    
    /**
     * With <code>@TODO2</code>, two attributes are mandatory: a value is needed
     * for the "what" attribute, and another for the "level" attribute.</br>
     * The only possible usage of the TODO2 annotation follows.
     */
    @TODO2(what = "Something very important", level = Level2.MAJOR)
    void doSomething3() {}
    
    /**
     * With <code>@TODO</code>, it is possible to give only the "value"
     * attribute, because the other attributes already have a default value.
     */
    @TODO(value = "Something normal to do")
    void doSomething4() {}
    
    /**
     * With <code>@TODO</code>, it is possible to give only the "value"
     * attribute, because the other attributes already have a default
     * value.</br>
     * The "value" attribute is the only mandatory attribute of the annotation,
     * and we can not give its name when using the annotation.
     */
    @TODO("Something normal to do")
    void doSomething5() {}
    
    /**
     * With <code>@TODO</code>, we can indicate the criticality level if its
     * value is different from the default value. By default, it is valued to
     * NORMAL.
     */
    @TODO(value = "Something minor to do", level = Level.MINOR)
    void doSomething6() {}
    
    /**
     * With <code>@TODO</code>, we can indicate the criticality level if its
     * value is different from the default value. By default, it is valued to
     * NORMAL.
     */
    @TODO(value = "Something normal to do", level = Level.NORMAL)
    void doSomething7() {}
    
    /**
     * With <code>@TODO</code>, we can indicate the criticality level if its
     * value is different from the default value. By default, it is valued to
     * NORMAL.
     */
    @TODO(value = "Something major to do", level = Level.MAJOR)
    void doSomething8() {}
    
    /**
     * With <code>@TODOs</code>, we can give several tasks to do on the same
     * source code element.
     */
    @TODOs({ @TODO("Something"), @TODO(value = "Something else", level = Level.MINOR),
            @TODO(value = "Major task", level = Level.MAJOR) })
    void doSomethingExtraordinary() {}
}
