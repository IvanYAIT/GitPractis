package main_program;

import dishes.builders.OrderBuilder;
import dishes.builders.PizzaBuilder;
import dishes.desserts.Cake;
import dishes.drinks.Water;
import dishes.first_dishe.Soup;
import dishes.ingredients.Ingredient;
import dishes.ingredients.IngredientType;
import dishes.second_dishe.Burger;
import dishes.second_dishe.Pizza;
import dishes.snacks.CheeseSticks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Order order1 = new OrderBuilder()
                .addSnack(new CheeseSticks())
                .addDessert(new Cake())
                .addFirstDish(new Soup())
                .build();
//        Order order2 = new OrderBuilder()
//                .addDrink(new Water())
//                .addSecondDish(new Burger())
//                .build();

//        Pizza pizza1 = makePizza();
//
//        System.out.println(pizza1.toString());

        Burger burger1 = Burger.builder().addIngredient(new Ingredient(IngredientType.BEEF, "sup", LocalDateTime.now(), LocalDateTime.now())).build();
        System.out.println(burger1.toString());
        List<Ingredient> ingredients = burger1.getIngredients();

        ingredients.add(new Ingredient(IngredientType.BEEF_CHOP, "sup", LocalDateTime.now(), LocalDateTime.now()));
        System.out.println(burger1.toString());
        //Burger burger = makeBurger();
        //System.out.println(burger.toString());
    }

    public static Pizza makePizza() {
        PizzaBuilder pizzaBuilder = new PizzaBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Здраствуйте!");
        System.out.println("Выберите основу для риццы: 1 - тонкая, 2 - стандартная, 3 - толстая, 4 - закрытая");

        String doughBase;

        try {
            String answer = reader.readLine();
            switch (answer) {
                case "1":
                    doughBase = "thin";
                    break;
                case "3":
                    doughBase = "lush";
                    break;
                case "4":
                    doughBase = "closed";
                    break;
                default:
                    doughBase = "standard";
                    break;
            }
            pizzaBuilder.setDoughBase(doughBase);
        } catch (IOException e) {
            System.out.println("При выборе основы пиццы возникла ошибка");
        }

        try {
            String answer;
            System.out.println("Добату ингредиент: \n"
                    + Arrays.stream(IngredientType.values())
                    .map(ingredientType -> ingredientType.getId() + " - " + ingredientType.getRuName())
                    .collect(Collectors.joining(", ")));
            System.out.println("Введите \"стоп\" для заввершения ввода");
            while (!(answer = reader.readLine()).equals("стоп")) {
                Ingredient ingredient = new Ingredient(
                        IngredientType.getById(Integer.parseInt(answer)),
                        "our supplier",
                        LocalDateTime.now(),
                        LocalDateTime.MAX
                );
                pizzaBuilder.addIngredient(ingredient);
            }
        } catch (IOException e) {
            System.out.println("При добаление ингридиентов возникла ошибка");
        }

        return pizzaBuilder.build();
    }

    public static Burger makeBurger() {
        Burger.BurgerBuilder burgerBuilder = Burger.builder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Здраствуйте!");

        try {
            String answer;
            System.out.println("Добавте ингредиент: \n"
                    + Arrays.stream(IngredientType.values())
                    .map(ingredientType -> ingredientType.getId() + " - " + ingredientType.getRuName())
                    .collect(Collectors.joining(", ")));
            System.out.println("Введите \"стоп\" для заввершения ввода");
            while (!(answer = reader.readLine()).equals("стоп")) {
                Ingredient ingredient = new Ingredient(
                        IngredientType.getById(Integer.parseInt(answer)),
                        "our supplier",
                        LocalDateTime.now(),
                        LocalDateTime.MAX
                );
                burgerBuilder.addIngredient(ingredient);
            }
        } catch (IOException e) {
            System.out.println("При добаление ингридиентов возникла ошибка");
        }

        System.out.println("Позолотить бургер: 1 - да 2 - нет");
        boolean gilded = false;

        try {
            String answer = reader.readLine();
            if(answer.equals("1")){
                gilded = true;
            }
            burgerBuilder.setGilded(gilded);
        } catch (IOException e) {
            System.out.println("Ошибка при выборе позолотить бургуер");
        }

        System.out.println("Напишите название бургера");
        try {
            String answer = reader.readLine();
            burgerBuilder.setName(answer);
        } catch (IOException e){
            System.out.println("Ошибка при водет имени");
        }

        return burgerBuilder.build();
    }
}
