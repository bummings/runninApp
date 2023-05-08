import java.util.Scanner;;

public class Main {
    public static void main(String[] args) {
        // Initialize scanner for input
        Scanner scanner = new Scanner(System.in);

        // This is the entry point for the run tracker.
        System.out.println("Welcome to run tracker, bruh ");
        System.out.println("What do you want to do? \n1. Enter a run\n2. Enter shoes ");

        // Grab user input, capitalize the input to avoid
        // any gotchas with lowercase input
        String userInput = scanner.nextLine().toUpperCase();

        // Initialize an empty string for the menu
        // selection.
        String result = "";
        switch (userInput) {
            case "1":
                // Utilize the RunInput class in Main
                // class: this will handle the logic of
                // accepting the miles ran, calculate the
                // averages, and save them to a text file
                // for data persistance.
                RunInput runInput = new RunInput();
                Double runInputMiles = runInput.handle(scanner);
                System.out.println("Your miles ran bruh: " + runInputMiles);

                break;
            case "2":
                result = "You selected TWO";
                break;
            default:
                System.out.println("Invalid input bruh");
                break;
        }
        System.out.println(result);

        // Closing the scanner to get rid of compiler
        // warnings.
        scanner.close();
    }
}