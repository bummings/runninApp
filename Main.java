import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to run tracker, bruh ");
        System.out.println("What do you want to do? \n1. Enter a run\n2. Enter shoes ");

        String userInput = scanner.nextLine().toUpperCase();
        
        String result = "";
        switch (userInput) {
            case "1":
                result = "How many miles did you run today?";
                double milesRan = scanner.nextDouble();
                System.out.println("OK bruh you ran " + milesRan + " miles.");
                System.out.println("I am really proud of you wow man amazing");
                
                try (FileWriter fileWriter = new FileWriter("selection.txt", true)) {
                    fileWriter.write(milesRan + System.lineSeparator());
                } catch (IOException e) {
                    System.out.println("big time problem bruh" + e.getMessage());
                }
                break;
            case "2":
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