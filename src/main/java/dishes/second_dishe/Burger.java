package dishes.second_dishe;

import dishes.ingredients.Ingredient;
import dishes.types.SecondDish;

import java.util.ArrayList;
import java.util.List;

public class Burger implements SecondDish {
    private final String name;
    private final List<Ingredient> ingredients;
    private final boolean gilded;

    private Burger(String name, List<Ingredient> ingredients, boolean gilded) {
        this.name = name;
        this.ingredients = ingredients;
        this.gilded = gilded;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    public boolean isGilded() {
        return gilded;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", gilded=" + gilded +
                '}';
    }

    public static BurgerBuilder builder(){
        return new BurgerBuilder();
    }

    public static class BurgerBuilder {
        private String name;
        private List<Ingredient> ingredients;
        private boolean gilded;

        private BurgerBuilder() {
            ingredients = new ArrayList<>();
        }

        public BurgerBuilder setName(String name){
            this.name = name;
            return this;
        }

        public BurgerBuilder addIngredient(Ingredient ingredient){
            ingredients.add(ingredient);
            return this;
        }

        public BurgerBuilder removeIngredient(Ingredient ingredient){
            ingredients.remove(ingredient);
            return this;
        }

        public BurgerBuilder resetIngredient(){
            ingredients.clear();
            return this;
        }

        public BurgerBuilder setGilded(boolean needGilded){
            gilded = needGilded;
            return this;
        }

        public Burger build(){
            if(name == null || name.isEmpty()){
                name = "custom";
            }
            if(ingredients.isEmpty()){
                throw new RuntimeException("Попытка создания пиццы без ингредиентов");
            } else {
                return new Burger(name, new ArrayList<>(ingredients), gilded);
            }
        }
    }
}
