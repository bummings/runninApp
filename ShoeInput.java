import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ShoeInput {
    private Map<String, Double> shoeMiles;

    // using a Hashmap, we will use the shoe name as a key and the value will be the
    // miles associated with the shoe. Each shoe is initially set to 0 miles.
    public ShoeInput() {
        shoeMiles = new HashMap<>();
        loadShoes();
    }

    private void loadShoes() {
        try (Scanner scanner = new Scanner(new File("shoes.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // splits line in shoes.txt into two elements: shoe name and miles broken up by
                // commas
                String[] parts = line.split(",");
                // check if there is a length greater than 1, i.e. checks to see there are miles
                // associated with the shoe already. Each new shoe is set at 0 miles. ["Asics
                // Novablast",120]
                if (parts.length > 1) {
                    shoeMiles.put(parts[0], Double.valueOf(parts[1]));
                } else {
                    shoeMiles.put(parts[0], 0.0);
                }
            }
        } catch (IOException e) {
            System.out.println("Error occured while trying to load shoes: " + e);
        }
    }

    // grab shoe name
    public String handle(Scanner scanner) {
        System.out.println("Enter shoes: ");
        String shoeInput = scanner.nextLine();

        // Write shoes to shoes.txt, handle any
        // error that may occur during the IO
        // with the try catch statement.
        try (FileWriter fileWriter = new FileWriter("shoes.txt", true)) {
            fileWriter.write(shoeInput + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Problem encountered while trying to save to file: " + e.getMessage());
        }
        return shoeInput;
    }

    // use the PrintWriter class to write shoe data to shoes.txt
    public void saveShoes() {
        try (PrintWriter writer = new PrintWriter(new File("shoes.txt"))) {
            for (Map.Entry<String, Double> entry : shoeMiles.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error occured while trying to save shoes: " + e.getMessage());
        }
    }

    // shoeInput class needs a getShoeMiles() method to retrieve the current show
    // miles.
    public Map<String, Double> getShoeMiles() {
        return new HashMap<>(shoeMiles);
    }

    public void addMiles(String shoe, double miles) {
        shoeMiles.put(shoe, shoeMiles.getOrDefault(shoe, 0.0) + miles);
        saveShoes();
    }

    // Load the shoes that are in shoes.txt into the shoeMiles map, checking if
    // there are any available shoes and displays them. Allow the user to select a
    // pair (1-based index [not 0-based] so we subtract 1 at the end.)
    public String selectShoes(Scanner scanner) {
        loadShoes();

        if (shoeMiles.isEmpty()) {
            System.out.println("No shoes are available. Please add shoes first.");
            return "";
        }

        System.out.println("Select shoes for this run: ");

        int counter = 1;
        List<String> shoeList = new ArrayList<>(shoeMiles.keySet());

        for (String shoe : shoeList) {
            System.out.println(counter + ". " + shoe);
            counter++;
        }

        int shoeSelection = scanner.nextInt();
        return shoeList.get(shoeSelection - 1);
    }

    public double getMilesForShoe(String shoe) {
        return shoeMiles.getOrDefault(shoe, 0.0);
    }

    public void setMilesForShoe(String shoe, double miles) {
        shoeMiles.put(shoe, miles);
    }
}