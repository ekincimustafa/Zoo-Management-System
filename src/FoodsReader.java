import java.io.*;
import java.util.*;

public class FoodsReader {

    public Map<String, Foods> readFoods(String filename) {
        Map<String, Foods> foods = new HashMap<>();
        // The use of HashMap provides quick and easy access to specific type of food.
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0].trim();
                double amount = Double.parseDouble(parts[1].trim());
                // Add food type and quantity to HashMap
                foods.put(type, new Foods(type, amount));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foods;
    }
}
