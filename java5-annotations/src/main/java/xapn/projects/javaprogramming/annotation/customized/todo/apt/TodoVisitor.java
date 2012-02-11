/**
 * 
 */
package xapn.projects.javaprogramming.annotation.customized.todo.apt;

import xapn.projects.javaprogramming.annotation.customized.todo.TODO;
import xapn.projects.javaprogramming.annotation.customized.todo.TODOs;

import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.Messager;
import com.sun.mirror.declaration.Declaration;
import com.sun.mirror.util.DeclarationVisitor;
import com.sun.mirror.util.SimpleDeclarationVisitor;

/**
 * <code>@TODO</code> Visitor.
 * 
 * @author Xavier Pigeon
 */
public class TodoVisitor extends SimpleDeclarationVisitor implements DeclarationVisitor {
    
    protected final AnnotationProcessorEnvironment environment;
    /** Indicate if the "-Arelease" option is part of the command line. */
    protected final boolean isRelease;
    
    /**
     * Constructor to which the annotation processor provide the APT
     * environment.
     * 
     * @param environment the APT environment
     */
    public TodoVisitor(AnnotationProcessorEnvironment environment) {
        this.environment = environment;
        isRelease = environment.getOptions().containsKey(TodoAnnotationProcessorFactory.RELEASE);
    }
    
    /**
     * <p>
     * Display the annotation message during the development stage.
     * </p>
     * <p>
     * The MAJOR messages are displayed as warnings.</br> The NORMAL messages
     * are displayed as notes.</br> The MINOR messages are displayed as simple
     * notes, without their positions in the source code.
     * </p>
     * 
     * @param declaration the declaration containing the annotation
     * @param todo the annotation to be displayed
     */
    public void printDebuggingInfo(Declaration declaration, TODO todo) {
        Messager messager = environment.getMessager();
        
        switch (todo.level()) {
        case MAJOR:
            messager.printWarning(declaration.getPosition(), declaration.getSimpleName() + ": " + todo.value());
            break;
        case NORMAL:
            messager.printNotice(declaration.getPosition(), declaration.getSimpleName() + ": " + todo.value());
            break;
        case MINOR:
            messager.printNotice(declaration.getSimpleName() + ": " + todo.value());
            break;
        }
    }
    
    /**
     * Display the <code>@TODO</code> annotations in the console.
     * 
     * @param declaration the type declaration
     * @param todo the annotation
     */
    public void printMessage(Declaration declaration, TODO todo) {
        if (isRelease) {
            printReleaseError(declaration, todo);
        } else {
            printDebuggingInfo(declaration, todo);
        }
    }
    
    /**
     * <p>
     * Display the annotation message during the compilation in release way.
     * </p>
     * <p>
     * The MAJOR messages are displayed as errors.</br> The NORMAL messages are
     * displayed as warnings.</br> The MINOR messages are displayed as notes.
     * </p>
     * 
     * @param declaration the declaration containing the annotation
     * @param todo the annotation to be displayed
     */
    public void printReleaseError(Declaration declaration, TODO todo) {
        Messager messager = environment.getMessager();
        
        switch (todo.level()) {
        case MAJOR:
            messager.printError(declaration.getPosition(), declaration.getSimpleName() + ": " + todo.value());
            break;
        case NORMAL:
            messager.printWarning(declaration.getPosition(), declaration.getSimpleName() + ": " + todo.value());
            break;
        case MINOR:
            messager.printNotice(declaration.getPosition(), declaration.getSimpleName() + ": " + todo.value());
            break;
        }
    }
    
    /**
     * For each declaration of any type, a message is displayed if the
     * <code>@TODO</code> annotation is met.</br>
     * In the same way, a message is displayed for all the <code>@TODO</code>
     * contained in the <code>@TODOs</code> annotation.
     */
    @Override
    public void visitDeclaration(Declaration declaration) {
        // One verifies if the declaration has a @TODO annotation.
        TODO todo = declaration.getAnnotation(TODO.class);
        // In this case, it is displayed:
        if (todo != null) {
            printMessage(declaration, todo);
        }
        
        // The same thing is done for the @TODOs annotation:
        TODOs todos = declaration.getAnnotation(TODOs.class);
        if (todos != null) {
            // One display the messages for all the TODOs:
            for (TODO t : todos.value()) {
                printMessage(declaration, t);
            }
        }
    }
}
