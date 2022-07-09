package dishes.builders;

import dishes.ingredients.Ingredient;
import dishes.second_dishe.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder {
    private String name;
    private List<Ingredient> ingredients;
    private boolean cheeseBumpers;
    private String doughBase;

    public PizzaBuilder() {
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
