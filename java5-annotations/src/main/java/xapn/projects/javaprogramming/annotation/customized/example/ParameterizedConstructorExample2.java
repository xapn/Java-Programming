/**
 * 
 */
package xapn.projects.javaprogramming.annotation.customized.example;

import xapn.projects.javaprogramming.annotation.customized.emptyconstructor.IEmptyConstructor;

/**
 * Example of using the <code>@EmptyConstructor</code> annotation.
 * 
 * @author Xavier Pigeon
 */
class ParameterizedConstructorExample2 implements IEmptyConstructor {
    
    @SuppressWarnings("unused")
    private int intField;
    
    /**
     * Constructor with one parameter.
     * 
     * @param intField
     */
    public ParameterizedConstructorExample2(int intField) {
        this.intField = intField;
    }
}
