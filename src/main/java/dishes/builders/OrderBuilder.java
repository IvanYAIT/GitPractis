package dishes.builders;

import dishes.types.*;
import main_program.Order;

public class OrderBuilder {

    private Snack snack;
    private FirstDish firstDish;
    private SecondDish secondDish;
    private Dessert dessert;
    private Drink drink;

    public OrderBuilder addSnack(Snack snack){
        this.snack = snack;
        return this;
    }

    public OrderBuilder addDessert(Dessert dessert){
        this.dessert = dessert;
        return this;
    }

    public OrderBuilder addFirstDish(FirstDish firstDish){
        this.firstDish = firstDish;
        return this;
    }

    public OrderBuilder addSecondDish(SecondDish secondDish){
        this.secondDish = secondDish;
        return this;
    }

    public OrderBuilder addDrink(Drink drink){
        this.drink = drink;
        return this;
    }

    public Order build(){
        if(snack == null && firstDish == null && secondDish == null && dessert == null && drink == null){
            throw new RuntimeException("Попытка создания пустого заказа");
        } else{
            return new Order(snack, firstDish, secondDish, dessert, drink);
        }
    }
}
