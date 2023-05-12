import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Initialize scanner for input
        Scanner scanner = new Scanner(System.in);
        ShoeInput shoeInput = new ShoeInput();

        // Initialize the RunData class
        RunData runData = new RunData();
        double weeklyAverage = runData.getWeeklyAverage();

        // This is the entry point for the run tracker.
        System.out.println("Welcome to Run Tracker.");
        System.out.println("1. Enter a run");
        System.out.println("2. Enter shoes");
        System.out.println("3. See your daily average for the week");
        System.out.println("4. See shoe milage");

        // Grab user input, capitalize the input to avoid
        // any gotchas with lowercase input
        Integer userInput = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining line separator

        // Initialize an empty string for the menu
        // selection.
        switch (userInput) {
            // Enter run
            case 1:
                // Utilize the RunInput class in Main class: this will handle the logic of
                // accepting the miles ran, calculate the averages, and save them to a text file
                // for data persistance.
                RunInput runInput = new RunInput();
                Double runInputMiles = runInput.handle(scanner, shoeInput);
                System.out.println("Your miles ran today: " + runInputMiles);
                break;

            // Enter shoes
            case 2:
                String shoeInputName = shoeInput.handle(scanner);
                System.out.println("Your shoes: " + shoeInputName);
                break;

            // Displays daily average for the week
            case 3:
                System.out.println("Your weekly average: " + weeklyAverage);
                break;

            // Display shoe milages
            case 4:
                // map over the shoes and for each one display the value associated with it's
                // key.
                Map<String, Double> shoeMiles = shoeInput.getShoeMiles();
                for (Map.Entry<String, Double> entry : shoeMiles.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }
    }
}