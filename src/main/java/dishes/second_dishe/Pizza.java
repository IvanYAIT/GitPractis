package dishes.second_dishe;

import dishes.ingredients.Ingredient;
import dishes.types.SecondDish;

import java.util.ArrayList;
import java.util.List;

public class Pizza implements SecondDish {
    private final String name;
    private final List<Ingredient> ingredients;
    private final boolean cheeseBumpers;
    private final String doughBase;

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public boolean isCheeseBumpers() {
        return cheeseBumpers;
    }

    public String getDoughBase() {
        return doughBase;
    }

    private Pizza(String name, List<Ingredient> ingredients, boolean cheeseBumpers, String doughBase) {
        this.name = name;
        this.ingredients = ingredients;
        this.cheeseBumpers = cheeseBumpers;
        this.doughBase = doughBase;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", cheeseBumpers=" + cheeseBumpers +
                ", doughBase='" + doughBase + '\'' +
                '}';
    }

    public static PizzaBuilder builder(){
        return new PizzaBuilder();
    }

    public static class PizzaBuilder {
        private String name;
        private List<Ingredient> ingredients;
        private boolean cheeseBumpers;
        private String doughBase;

        private PizzaBuilder() {
            ingredients = new ArrayList<>();
        }

        public PizzaBuilder setName(String name){
            this.name = name;
            return this;
        }

        public PizzaBuilder addIngredient(Ingredient ingredient){
            ingredients.add(ingredient);
            return this;
        }

        public PizzaBuilder removeIngredient(Ingredient ingredient){
            this.ingredients.remove(ingredient);
            return this;
        }

        public PizzaBuilder resetIngredient(){
            ingredients.clear();
            return this;
        }

        public PizzaBuilder setCheeseBumpers(boolean needCheeseBumpers){
            cheeseBumpers = needCheeseBumpers;
            return this;
        }

        public PizzaBuilder setDoughBase(String doughBase){
            this.doughBase = doughBase;
            return this;
        }

        public Pizza build(){
            if(name == null || name.isEmpty()){
                name = "custom";
            }
            if(doughBase == null || doughBase.isEmpty()){
                doughBase = "Standard";
            }
            if(ingredients.isEmpty()){
                throw new RuntimeException("Попытка создания пиццы без ингредиентов");
            } else {
                return new Pizza(name, new ArrayList<>(ingredients), cheeseBumpers, doughBase);
            }
        }
    }
}
