/**
 * 
 */
package xapn.projects.java.dsl.pizza;

/**
 * A better PizzaBuilder.
 * Let's look at some ways to improve the fluency and context of this API.
 * <ul>
 * <li>First, in order to improve the API's fluency, we'll rename its methods.
 * Instead of traditional setter methods, we can name the methods based on
 * intent.</li>
 * <li>Second, in order to provide context and method chaining, we can rewrite
 * the methods to automatically return the PizzaBuilder a user is working with.</li>
 * </ul>
 * 
 * @author Xavier Pigeon
 */
class BetterPizzaBuilder {
    
    /**
     * New builder in action: a better PizzaBuilder makes a better Pizza.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Pizza pizza = new BetterPizzaBuilder().prepareDough().addSauce(2).addCheese(2, "Mozzarella")
                .addToppings("Olives", "Tomatoes", "Bell Peppers").bake().get();
    }
    
    public BetterPizzaBuilder addCheese(int amount, String type) {
        return this;
    }
    
    public BetterPizzaBuilder addSauce(int amount) {
        return this;
    }
    
    public BetterPizzaBuilder addToppings(String... toppings) {
        return this;
    }
    
    public BetterPizzaBuilder bake() {
        return this;
    }
    
    public Pizza get() {
        return null;
    }
    
    public BetterPizzaBuilder prepareDough() {
        return this;
    }
}
