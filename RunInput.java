//    FileWriter for data persistance
//    IOException for catching errors for data persistance

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;
import java.io.IOException;

public class RunInput {
    public Double handle(Scanner scanner) {
        System.out.println("Enter miles: ");
        Double milesInput = scanner.nextDouble();

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);

        try (FileWriter fileWriter = new FileWriter("output.txt", true)) {
            fileWriter.write(timestamp + ": " + milesInput + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Problem encountered while trying to save to file: " + e.getMessage());
        }
        return milesInput;
    }
}