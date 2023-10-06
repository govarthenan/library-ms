
// Main source file that aggregates all other classes and runs the whole program
import java.util.Scanner;

public class Run {
    // Input scanner for menu navigation
    static Scanner input = new Scanner(System.in);
    static String menuChoice; // Get the user's selection

    public static boolean validateMenuChoice(String choice) {
        if (choice.length() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void printMainMenu() {
        // Print the menu for the user to choose from
        System.out.println("Please choose which section to go to.");
        System.out.println("Books(b): ");
        System.out.println("Members(m): ");
        System.out.println("Lendings(l): ");
        System.out.print("Your selection: ");
    }

    public static void printWelcome() {
        // Print the welcome message for the user
        System.out.println("Hi, welcome to Library Management System!");
        System.out.println("The UI can be navigated using the key displayed within brackets adjacent to every option.");
        System.out.println("At any time, you can press 'q' to exit the program.");
        System.out.println("Best of luck!");
        System.out.println("--------------------------------------------------\n");
    }

    public static void main(String[] args) {
        // Run the program in a conitnuous loop unless user wants to exit
        printWelcome();

        while (true) {
            printMainMenu(); // Print the main menu every time the program iterates
            menuChoice = input.nextLine(); // Get the user's selection

            // validate the user's selection
            if (validateMenuChoice(menuChoice)) {
                System.out.println(menuChoice + "\n");
            } else {
                System.out.print("Menu choice too long. Enter one character only.\n\n\n");
            }
        }
    }
}