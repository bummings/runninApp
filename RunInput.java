// The following imports:
//    Scanner for text input
//    LocalDateTime to generate time stamp
//    DateTimeFormatter to format time stamp
//    FileWriter to persist data in output.txt
//    IOException to handle any errors with IO

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class RunInput {
    public Double handle(Scanner scanner, ShoeInput shoeInput) {
        // initialize milesInput variable
        Double milesInput = null;
        String shoesInput = null;

        while (milesInput == null) {
            System.out.println("Enter miles: ");

            // ensure that a double is entered, otherwise reject the input a nd have the
            // user
            // input again.
            if (scanner.hasNextDouble()) {
                milesInput = scanner.nextDouble();

                // clear the scanner for any extra characters
                scanner.nextLine();
                shoesInput = shoeInput.handle(scanner);
                // use ShoeInput's method to get miles for shoe
                double previousMiles = shoeInput.getMilesForShoe(shoesInput);
                // use ShoeInput's method to set miles for shoe
                shoeInput.setMilesForShoe(shoesInput, previousMiles + milesInput);
                shoeInput.saveShoes();

                // Utilizing the LocalDateTime library to generate timestamp
                LocalDateTime now = LocalDateTime.now();

                // Create miles.txt if it does not exist.
                File file = new File("miles.txt");
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        System.out.println("Error occured while trying to create a new file.");
                    }
                }

                // Running it thru the DateTimeFormatter library to shape it nicely
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String timestamp = now.format(formatter);

                // This try catch statement will attempt to write the result to a text file for
                // data persistance and will throw an error if the attempt is unsuccessful.
                try (FileWriter fileWriter = new FileWriter("miles.txt", true)) {
                    fileWriter.write(timestamp + "," + milesInput + ", " + shoesInput + System.lineSeparator());
                } catch (IOException e) {
                    System.out.println("Problem encountered while trying to save to file: " + e.getMessage());
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Discard the invalid input
            }

        }

        return milesInput;
    }
}