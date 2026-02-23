import java.io.*;
import java.util.*;

public class PersonsReader {

    public List<Persons> readPersons(String filename) {
        List<Persons> persons = new ArrayList<>();  // Create a list to hold contacts

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0].trim();

                String name = parts[1].trim();
                int id = Integer.parseInt(parts[2].trim());

                Persons person = createPerson(type, name, id);
                if (person != null) {
                    persons.add(person);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }
    // Method that creates the appropriate object according to the type of person.
    private Persons createPerson(String type, String name, int id) {
        switch (type.toLowerCase()) {
            case "visitor":
                return new Visitor(name, id);
            case "personnel":
                return new Personnel(name, id);
            default:
                return null;
        }
    }
}
