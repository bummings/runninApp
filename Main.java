import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to run tracker, bruh ");
        System.out.println("What do you want to do? \nInput ONE or TWO: ");

        String userInput = scanner.nextLine().toUpperCase();
        
        switch (userInput) {
            case "ONE":
                System.out.println("You selected ONE");
                break;
            case "TWO":
                System.out.println("You selected TWO");
                break;
            default:
                System.out.println("Invalid input bruh");
                break;
        }    
    }
}