import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize scanner for input
        Scanner scanner = new Scanner(System.in);

        // This is the entry point for the run tracker.
        System.out.println("Welcome to run tracker. ");
        System.out.println("What do you want to do? \n1. Enter a run\n2. Enter shoes\n ");

        // Grab user input, capitalize the input to avoid
        // any gotchas with lowercase input
        Integer userInput = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining line separator

        // Initialize an empty string for the menu
        // selection.
        switch (userInput) {
            case 1:
                // Utilize the RunInput class in Main
                // class: this will handle the logic of
                // accepting the miles ran, calculate the
                // averages, and save them to a text file
                // for data persistance.
                RunInput runInput = new RunInput();
                Double runInputMiles = runInput.handle(scanner);
                System.out.println("Your miles ran today: " + runInputMiles);
                break;

            case 2:
                ShoeInput shoeInput = new ShoeInput();
                String shoeInputName = shoeInput.handle(scanner);
                System.out.println("Your shoes: " + shoeInputName);
                break;

            default:
                System.out.println("Invalid input bruh");
                break;
        }

        // Closing the scanner to get rid of compiler
        // warnings.
        // scanner.close();
    }
}