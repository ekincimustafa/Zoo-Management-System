import java.io.*;
import java.util.*;

public class AnimalsReader {
    public List<Animals> readAnimals(String filename) {
        List<Animals> animals = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0].trim();
                String name = parts[1].trim();
                int age = Integer.parseInt(parts[2].trim());
                Animals animal = createAnimal(type, name, age);
                if (animal != null) {
                    animals.add(animal);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return animals;
    }

    private Animals createAnimal(String type, String name, int age) {
        switch (type.toLowerCase()) {
            case "lion":
                return new Lion(name, age);
            case "elephant":
                return new Elephant(name, age);
            case "penguin":
                return new Penguin(name, age);
            case "chimpanzee":
                return new Chimpanzee(name, age);
            default:
                return null;
        }
    }
}
