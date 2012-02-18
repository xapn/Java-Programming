/**
 * 
 */
package xapn.projects.java.dsl.pizza;

/**
 * PizzaBuilder provides an API for making pizza, with a traditional Java
 * syntax.
 * 
 * @author Xavier Pigeon
 */
class PizzaBuilder {
    
    /**
     * The above example has a few problems. First, it has no context, hence the
     * repeated use of the pizzaBuilder object reference. Second, there is an
     * imposed ordering: the get() method must be the last method to be called.
     * Ordering is a necessary evil in some scenarios, though it would be great
     * if you could avoid it altogether. In cases where you cannot avoid
     * ordering, you can enforce it with tact, by using method chaining to set
     * the return types of methods. Users of your API will then have to follow a
     * certain method order, but doing so will come naturally.
     * 
     * @param args
     */
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        PizzaBuilder pizzaBuilder = new PizzaBuilder();
        pizzaBuilder.setDough();
        pizzaBuilder.setSauce(2);
        pizzaBuilder.setCheese(2, "Mozzarella");
        pizzaBuilder.setToppings("Olives", "Tomatoes", "Bell Peppers");
        pizzaBuilder.bake();
        Pizza pizza = pizzaBuilder.get();
    }
    
    public void bake() {}
    
    public Pizza get() {
        return new Pizza();
    }
    
    public void setCheese(int amount, String type) {}
    
    public void setDough() {}
    
    public void setSauce(int amount) {}
    
    public void setToppings(String... toppings) {}
}
