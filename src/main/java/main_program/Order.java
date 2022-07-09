package main_program;

import dishes.types.*;

public class Order {

    private Snack snack;
    private FirstDish firstDish;
    private SecondDish secondDish;
    private Dessert dessert;
    private Drink drink;

    public Order(Snack snack, FirstDish firstDish, SecondDish secondDish, Dessert dessert, Drink drink) {
        this.snack = snack;
        this.firstDish = firstDish;
        this.secondDish = secondDish;
        this.dessert = dessert;
        this.drink = drink;
    }
}
