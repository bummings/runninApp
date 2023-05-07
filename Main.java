import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to run tracker, bruh ");
        System.out.println("What do you want to do? \nInput ONE or TWO: ");

        String userInput = scanner.nextLine().toUpperCase();
        
        String result = "";
        switch (userInput) {
            case "ONE":
                result = "You selected ONE";
                break;
            case "TWO":
                result = "You selected TWO";
                break;
            default:
                System.out.println("Invalid input bruh");
                break;
        }    
        System.out.println(result);

        try (FileWriter fileWriter = new FileWriter("selection.txt", true)) {
            fileWriter.write(result + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("big time problem bruh" + e.getMessage());
        }
    }
}