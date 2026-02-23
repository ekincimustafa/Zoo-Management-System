import java.util.*;

public class ZooSystem {
    private List<Animals> animals;
    private List<Persons> persons;
    private Map<String, Foods> foods;
    private OutputWriter outputWriter;
    public static List<String> outputLines = new ArrayList<>();
    // Static because it can be accessed by class name without creating any object

    public ZooSystem(List<Animals> animals, List<Persons> persons, Map<String, Foods> foods, OutputWriter outputWriter) {
        this.animals = animals;
        this.persons = persons;
        this.foods = foods;
        this.outputWriter = outputWriter;
    }

    public void runCommands(String commandsFile) {
        outputLines.add("***********************************");
        outputLines.add("***Initializing Animal information***");
        for (Animals animal : animals) {
            outputLines.add("Added new " + animal.getType() + " with name " + animal.getName() + " aged " + animal.getAge() + ".");
        }
        // for each is good for reading the elements in the list. Because of that I used it
        outputLines.add("***********************************");
        outputLines.add("***Initializing Visitor and Personnel information***");
        for (Persons person : persons) {
            outputLines.add("Added new " + person.getType() + " with id " + person.getId() + " and name " + person.getName() + ".");
        }

        outputLines.add("***********************************");
        outputLines.add("***Initializing Food Stock***");
        for (Map.Entry<String, Foods> entry : foods.entrySet()) {
            double amount = entry.getValue().getAmount();
            String formattedAmount = String.format(Locale.US, "%.3f", amount);
            outputLines.add("There are " + formattedAmount + " kg of " + entry.getKey() + " in stock");
        }

        // To execute commands
        CommandsReader commandsReader = new CommandsReader();
        commandsReader.processCommands(commandsFile, this, outputLines);
        /*
        This represents the current object of that class.
        when processing commands that the methods of that class can be called
         */
        outputWriter.writeOutput(outputLines);  // for printing
    }

    public void listFoodStock(List<String> outputLines) {
        outputLines.add("***********************************");
        outputLines.add("***Processing new Command***");
        outputLines.add("Listing available Food Stock:");
        for (Map.Entry<String, Foods> entry : foods.entrySet()) {
            double amount = entry.getValue().getAmount();
            String formattedAmount = String.format(Locale.US, "%.3f", amount);
            outputLines.add(entry.getKey() + ": " + formattedAmount + " kgs");
        }
    }

    public void animalVisitation(int personId, String animalName, List<String> outputLines) {
        outputLines.add("***********************************");
        outputLines.add("***Processing new Command***");
        try {
            Persons person = findPersonById(personId);
            // I wrote here first because I want to print it even if there is no animal
            if (person instanceof Personnel) {
                outputLines.add(person.getName() + " attempts to clean " + animalName + "'s habitat.");
            } else if (person instanceof Visitor) {
                outputLines.add(person.getName() + " tried  to register for a visit to " + animalName + ".");
            }
            Animals animal = findAnimalByName(animalName);
            person.visitAnimal(animal, outputLines);

        } catch (CustomExceptions.PersonNotFoundException |
                 CustomExceptions.UnknownAnimalTypeException e) {
            outputLines.add("Error: " + e.getMessage());
        }
    }

    public void feedAnimal(int personId, String animalName, int numberOfMeals, List<String> outputLines) {
        outputLines.add("***********************************");
        outputLines.add("***Processing new Command***");
        try {
            // for error throwing it not found
            Persons person = findPersonById(personId);
            Animals animal  = findAnimalByName(animalName);

            // first print message and then throw exception
            if (!(person instanceof Personnel)) {
                person.feedAnimal(animal, numberOfMeals, outputLines);
                throw new CustomExceptions.UnauthorizedActionException();
            }

            outputLines.add(person.getName() + " attempts to feed " + animal.getName() + ".");
            // First calculate food amount
            if (animal instanceof Lion) {
                double mealSize = 0;
                mealSize += 5 + ((animal.getAge() - 5) * 0.05);
                mealSize = mealSize * numberOfMeals;
                Foods.getFood("Meat").consume(mealSize);
            } else if (animal instanceof Elephant) {
                double mealSize = 0;
                mealSize += 10 + ((animal.getAge() - 20) * 0.015);
                mealSize = mealSize * numberOfMeals;
                Foods.getFood("Plant").consume(mealSize);
            } else if (animal instanceof Penguin) {
                double mealSize = 0;
                mealSize += 3 + ((animal.getAge() - 4) * 0.04);
                mealSize = mealSize * numberOfMeals;
                Foods.getFood("Fish").consume(mealSize);
            } else if (animal instanceof Chimpanzee) {
                double mealSizeMeat = 0.0;
                mealSizeMeat += 3.0 + ((animal.getAge() - 10) * 0.0125);
                mealSizeMeat = mealSizeMeat * numberOfMeals;
                Foods.getFood("Meat").consume(mealSizeMeat);

                double mealSizePlant = 0.0;
                mealSizePlant += 3.0 + ((animal.getAge() - 10) * 0.0125);
                mealSizePlant = mealSizePlant * numberOfMeals;
                Foods.getFood("Plant").consume(mealSizePlant);
            }

            // After create feeding message
            person.feedAnimal(animal, numberOfMeals, outputLines);

        } catch (CustomExceptions.UnauthorizedActionException |
                 CustomExceptions.PersonNotFoundException |
                 CustomExceptions.UnknownAnimalTypeException |
                 CustomExceptions.InsufficientFoodException e) {
            outputLines.add("Error:" + e.getMessage());
        } catch (NumberFormatException e) {
            return;
        }
    }
    // Finding person by id
    private Persons findPersonById(int id) throws CustomExceptions.PersonNotFoundException {
        for (Persons person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        throw new CustomExceptions.PersonNotFoundException(id);
    }

    // Finding animal by name
    private Animals findAnimalByName(String name) throws CustomExceptions.UnknownAnimalTypeException {
        for (Animals animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        throw new CustomExceptions.UnknownAnimalTypeException(name);
    }
}
