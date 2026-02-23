import java.io.*;
import java.util.*;

public class CommandsReader {

    public List<String> readCommands(String filename) {
        List<String> commands = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                commands.add(line.trim());
            }
        } catch (IOException e)  {
            e.printStackTrace();
        }
        return commands;
    }
    // Method to process commands from a file
    // Store output in a list
    public void processCommands(String filename, ZooSystem zooSystem, List<String> outputLines) {
        List<String> commands = readCommands(filename);
        for (String command : commands) {
            processCommand(command, zooSystem, outputLines);
        }
    }
    // Private method to process a single command
    private void processCommand(String command, ZooSystem zooSystem, List<String> outputLines) {
        String[] parts = command.split(",");
        String operation = parts[0].trim().toLowerCase(); // Get the operation

        switch (operation) {
            case "list food stock":
                zooSystem.listFoodStock(outputLines);
                break;

            case "animal visitation": {
                int personId = Integer.parseInt(parts[1].trim());
                String animalName = parts[2].trim();
                zooSystem.animalVisitation(personId, animalName, outputLines);
                break;
            }

            case "feed animal": {
                try {
                    int personId = Integer.parseInt(parts[1].trim());
                    String animalName = parts[2].trim();
                    int numberOfMeals = Integer.parseInt(parts[3].trim());
                    zooSystem.feedAnimal(personId, animalName, numberOfMeals, outputLines);
                }catch (NumberFormatException e){
                    outputLines.add("***********************************");
                    outputLines.add("***Processing new Command***");
                    outputLines.add("Error processing command: " + command);
                    outputLines.add("Error:" + e.getMessage());
                }
                break;
            }
            default:
                break;
        }
    }
}
