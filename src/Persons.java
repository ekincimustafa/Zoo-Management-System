import java.util.*;

public abstract class Persons {
    private String type;
    private String name;
    private int id;

    public Persons(String type, String name, int id) {
        this.type = type;
        this.name = name;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    /*

    We used the abstract class structure because subclasses should also use it
    Allows each subclass to define its own specific behaviour.
    Reduces code repetition and facilitates maintenance.
    Abstract classes, supports polymorphism.

     */
    // Abstract method for visiting an animal
    public abstract void visitAnimal(Animals animal,List<String> outputlines);

    // Abstract method for feeding an animal
    public abstract void feedAnimal(Animals animal, int numberOfMeals,List<String> outputlines);
}

class Visitor extends Persons {
    public Visitor(String name, int id) {
        super("Visitor", name, id);
    }

    @Override
    public void visitAnimal(Animals animal,List<String> outputlines) {
        outputlines.add(getName() + " successfully visited " + animal.getName() + ".");
    }

    @Override
    public void feedAnimal(Animals animal, int numberOfMeals,List<String> outputlines) {
        outputlines.add(getName() + " tried to feed " + animal.getName());
    }
}

class Personnel extends Persons {
    public Personnel(String name, int id) {
        super("Personnel", name, id);
    }

    @Override
    public void visitAnimal(Animals animal,List<String> outputLines) {
        outputLines.add(getName() + " started cleaning " + animal.getName() + "'s habitat.");
        animal.cleanHabitat(outputLines);
    }

    @Override
    public void feedAnimal(Animals animal, int numberOfMeals,List<String> outputlines) {
        animal.feed(numberOfMeals,outputlines);
    }
}