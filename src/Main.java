import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Creating object
        AnimalsReader animalReader = new AnimalsReader();
        List<Animals> animals = animalReader.readAnimals(args[0]);

        PersonsReader personsReader = new PersonsReader();
        List<Persons> persons = personsReader.readPersons(args[1]);

        FoodsReader foodsReader = new FoodsReader();
        Map<String, Foods> foods = foodsReader.readFoods(args[2]);

        OutputWriter outputWriter = new OutputWriter(args[4]);

        // Execute commands
        ZooSystem zooSystem = new ZooSystem(animals, persons, foods, outputWriter);
        zooSystem.runCommands(args[3]);
    }
}
