import java.util.List;
import java.util.Locale;

public abstract class Animals {
    private String type;
    private String name;
    private int age;

    public Animals(String type, String name, int age) {
        this.type = type;
        this.name = name;
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Abstract method for feeding the animal
    public abstract void feed(int numberOfMeals, List<String> outputlines);

    // Abstract method for cleaning the habitat
    public abstract void cleanHabitat(List<String> outputlines);
}

class Lion extends Animals {
    public Lion(String name, int age) {
        super("Lion", name, age);
    }

    @Override
    public void feed(int numberOfMeals, List<String> outputlines) {
        double mealSize = 0.0;
        mealSize += 5 + ((getAge() - 5) * 0.05);
        mealSize = mealSize * numberOfMeals;
        outputlines.add(getName() + " has been given " + String.format(Locale.US, "%.3f", mealSize) + " kgs of meat");

    }

    @Override
    public void cleanHabitat(List<String> outputlines) {
        outputlines.add("Cleaning " + getName() + "'s habitat: Removing bones and refreshing sand.");
    }
}

class Elephant extends Animals {
    public Elephant(String name, int age) {
        super("Elephant", name, age);
    }

    @Override
    public void feed(int numberOfMeals,List<String> outputlines) {
        double mealSize = 0.0;
        mealSize += 10 + ((getAge() - 20) * 0.015);
        mealSize = mealSize * numberOfMeals;
        outputlines.add(getName() + " has been given " + String.format(Locale.US, "%.3f", mealSize) + " kgs assorted fruits and hay");
    }

    @Override
    public void cleanHabitat(List<String> outputlines) {
        outputlines.add("Cleaning " + getName() + "'s habitat: Washing the water area.");
    }
}

class Penguin extends Animals {
    public Penguin(String name, int age) {
        super("Penguin", name, age);
    }

    @Override
    public void feed(int numberOfMeals,List<String> outputlines) {
        double mealSize = 0.0;
        mealSize += 3 + ((getAge() - 4) * 0.04);
        mealSize = mealSize * numberOfMeals;
        outputlines.add(getName() + " has been given " + String.format(Locale.US, "%.3f", mealSize) + " kgs of various kinds of fish");
    }

    @Override
    public void cleanHabitat(List<String> outputlines) {
        outputlines.add("Cleaning " + getName() + "'s habitat: Replenishing ice and scrubbing walls.");
    }
}

class Chimpanzee extends Animals {
    public Chimpanzee(String name, int age) {
        super("Chimpanzee", name, age);
    }

    @Override
    public void feed(int numberOfMeals,List<String> outputlines) {

        double mealSizeMeat = 0.0;
        mealSizeMeat += 3.0 + ((getAge() - 10) * 0.0125);
        mealSizeMeat = mealSizeMeat * numberOfMeals;

        double mealSizePlant = 0.0;
        mealSizePlant += 3.0 + ((getAge() - 10) * 0.0125);
        mealSizePlant = mealSizePlant * numberOfMeals;

        outputlines.add(getName() + " has been given "
                + String.format(Locale.US, "%.3f", mealSizeMeat) + " kgs of meat and "
                + String.format(Locale.US, "%.3f", mealSizePlant) + " kgs of leaves");
    }

    @Override
    public void cleanHabitat(List<String> outputlines) {
        outputlines.add("Cleaning " + getName() + "'s habitat: Sweeping the enclosure and replacing branches.");
    }
}
