package dishes.ingredients;

public enum IngredientType {

    BEAN(1, "Фасоль"),
    BEEF_CHOP(2, "Говяжья котлета"),
    CHICKEN_CHOP(3, "Куриная котлета"),
    BEEF(4, "Говядина"),
    CHICKEN(5, "Курица"),
    CUCUMBER(6, "Огурец"),
    KETCHUP(7, "Кетчуп"),
    POTATO(8, "Картофель"),
    SALAD(9,"Лист салата"),
    TOMATO(10, "Помидор"),
    OLIVES(11, "Оливки"),
    CHEESE(12, "Сыр");

    private final String ruName;
    private final int id;

    IngredientType(int id, String name) {
        this.id = id;
        ruName = name;
    }

    public String getRuName() {
        return ruName;
    }
    public int getId() {
        return id;
    }

    public static IngredientType getById(int id) {
        return IngredientType.values()[id - 1];
    }

}
