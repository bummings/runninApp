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

public class RunInput {
    public Double handle(Scanner scanner) {
        // initialize milesInput variable
        Double milesInput = null;

        while (milesInput == null) {
            System.out.println("Enter miles: ");

            // ensure that a double is entered,
            // otherwise reject the input and
            // have the user input again.
            if (scanner.hasNextDouble()) {
                milesInput = scanner.nextDouble();
                // Utilizing the LocalDateTime library
                // to generate timestamp,and running
                // it thru the DateTimeFormatter
                // library to shape it more cohesively
                // for the output.txt file for
                // persistance.
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String timestamp = now.format(formatter);

                // This try catch statement will attempt to
                // write the result to a text file for data
                // persistance and will throw an error if
                // the attempt is unsuccessful.
                try (FileWriter fileWriter = new FileWriter("miles.txt", true)) {
                    fileWriter.write(timestamp + ": " + milesInput + System.lineSeparator());
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