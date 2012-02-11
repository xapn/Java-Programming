/**
 * 
 */
package xapn.projects.javaprogramming.annotation.customized.example;

import xapn.projects.javaprogramming.annotation.customized.emptyconstructor.EmptyConstructor;

/**
 * Example of using the <code>@EmptyConstructor</code> annotation.
 * 
 * @author Xavier Pigeon
 */
@EmptyConstructor
class ParameterizedConstructorExample1 {
    
    @SuppressWarnings("unused")
    private int intField;
    
    /**
     * Constructor with one parameter.
     * 
     * @param intField
     */
    public ParameterizedConstructorExample1(int intField) {
        this.intField = intField;
    }
}
