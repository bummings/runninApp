import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;;

public class ShoeInput {
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
}