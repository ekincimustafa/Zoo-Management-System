import java.util.HashMap;
import java.util.Map;

public class Foods {
    private String type;
    private double amount;
    private static Map<String, Foods> foodStock = new HashMap<>();  // We use map for key and value

    public Foods(String type, double amount) {
        this.type = type;
        this.amount = amount;
        foodStock.put(type, this);  // Adds food to the stock map
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    // Method consuming food throws exception if there is no enough food
    public void consume(double amount) throws CustomExceptions.InsufficientFoodException {
        if (this.amount < amount) {
            throw new CustomExceptions.InsufficientFoodException(getType());
        }
        this.amount -= amount;
    }
    // Static method that returns food of a specific type
    public static Foods getFood(String type) {
        return foodStock.get(type);
    }
}
