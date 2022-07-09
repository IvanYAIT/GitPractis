package dishes.ingredients;

import java.time.LocalDateTime;
import java.util.Objects;

public class Ingredient {
    private final IngredientType type;
    private final String supplier;
    private final LocalDateTime productionDateTime;
    private final LocalDateTime bestBeforeDateTime;

    public Ingredient(IngredientType type, String supplier, LocalDateTime productionDateTime, LocalDateTime bestBeforeDateTime) {
        this.type = type;
        this.supplier = supplier;
        this.productionDateTime = productionDateTime;
        this.bestBeforeDateTime = bestBeforeDateTime;
    }

    public IngredientType getType() {
        return type;
    }

    public String getSupplier() {
        return supplier;
    }

    public LocalDateTime getProductionDateTime() {
        return productionDateTime;
    }

    public LocalDateTime getBestBeforeDateTime() {
        return bestBeforeDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return type == that.type &&
                supplier.equals(that.supplier) &&
                productionDateTime.equals(that.productionDateTime) &&
                bestBeforeDateTime.equals(that.bestBeforeDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, supplier, productionDateTime, bestBeforeDateTime);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "type=" + type +
                ", supplier='" + supplier + '\'' +
                ", productionDateTime=" + productionDateTime +
                ", bestBeforeDateTime=" + bestBeforeDateTime +
                "}\n";
    }
}
