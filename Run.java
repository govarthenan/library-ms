
// Main source file that aggregates all other classes and runs the whole program
import java.util.Scanner;

public class Run {
    // Input scanner for menu navigation
    static Scanner input = new Scanner(System.in);
    static String menuChoice; // Get the user's selection

    public static void printWelcome() {
        // Print the welcome message for the user
        System.out.println("Hi, welcome to Library Management System!");
        System.out.println("The UI can be navigated using the key displayed within brackets adjacent to every option.");
        System.out.println("At any time, you can press 'q' to exit the program.");
        System.out.println("Best of luck!");
        System.out.println("--------------------------------------------------\n");
    }

    public static void printMainMenu() {
        // Print the menu for the user to choose from
        System.out.println("\nPlease choose which section to go to.");
        System.out.println("- Books (b)");
        System.out.println("- Lendings (l)");
        System.out.println("- Members (m)");
        System.out.print("Your selection: ");
    }

    public static void printBookMenu() {
        // Print the menu with book related options
        System.out.println("\nPlease choose the operation");
        System.out.println("- Add book (a)");
        System.out.println("- Delete book by ID (d)");
        System.out.println("- List existing books (l)");
        System.out.println("- Search for a book info using ID (s)");
        System.out.print("Your selection: ");
    }

    public static void printMemberMenu() {
        // Print the menu with member related options
        System.out.println("\nPlease choose the operation");
        System.out.println("- Register member (a)");
        System.out.println("- Delete a member using ID (d)");
        System.out.println("- List existing members (l)");
        System.out.println("- Search for member info using ID (s)");
        System.out.println("Your selection: ");
    }

    public static void printLendingMenu() {
        System.out.println("\nPlease choose the operation");
        System.out.println("- Lend book with book and member IDs (a)");
        System.out.println("- Return a lent book (d)");
        System.out.println("- Show information about specific lending (i)");
        System.out.println("- List lent books (l)");
        System.out.println("- List overdue lendings (o)");
    }

    public static boolean validateMenuChoice(String choice) {
        // If 'q' was pressed, exit the program immediately
        if (choice.equals("q")) {
            System.out.println("\nExiting program...");
            System.exit(0);
        }

        if (choice.length() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Run the program in a conitnuous loop unless user wants to exit
        printWelcome();

        while (true) {
            printMainMenu(); // Print the main menu every time the program iterates
            menuChoice = input.nextLine(); // Get the user's selection

            // validate the user's selection
            if (validateMenuChoice(menuChoice)) {
                System.out.println(menuChoice + menuChoice.length());
                if (menuChoice.equals("b")) {
                    printBookMenu();
                } else if (menuChoice.equals("m")) {
                    printMemberMenu();
                } else if (menuChoice.equals("l")) {
                    printLendingMenu();
                }
            } else {
                System.out.print("Menu choice too long. Enter one character only.\n\n\n");
            }
        }
    }
}