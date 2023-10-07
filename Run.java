
// Main source file that aggregates all other classes and runs the whole program
import java.util.Scanner;
import java.util.ArrayList;

public class Run {
    // Input scanner for menu navigation
    static Scanner input = new Scanner(System.in);
    static String menuChoice; // Get the user's selection

    // Database
    static ArrayList<Book> books = new ArrayList<Book>();
    static ArrayList<Member> members = new ArrayList<Member>();

    // AutoID trackers
    static int autoIdBook = 0;
    static int autoIdMember = 0;

    public static void printArrayList(ArrayList<?> list) { // DEBUG
        for (Object item : list) {
            System.out.println(item);
        }
    }

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
        System.out.println("- Search for books (s)");
        System.out.print("Your selection: ");
    }

    public static void printMemberMenu() {
        // Print the menu with member related options
        System.out.println("\nPlease choose the operation");
        System.out.println("- Register member (a)");
        System.out.println("- Delete a member using ID (d)");
        System.out.println("- List existing members (l)");
        System.out.println("- Search for member info using ID (s)");
        System.out.print("Your selection: ");
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

    public static void addBook() {
        String name, author, publisher, description; // Variables to store user input

        System.out.println("\nAdd Book To the Shelf");

        // Take input from user
        System.out.print("Enter book name: ");
        name = input.nextLine();

        System.out.print("Enter author: ");
        author = input.nextLine();

        System.out.print("Enter publisher: ");
        publisher = input.nextLine();

        System.out.print("Enter one line description: ");
        description = input.nextLine();

        // Create new book and add it to the database
        Book newBook = new Book(1, "", "", "", "");
        newBook.setId(autoIdBook);
        newBook.setName(name);
        newBook.setAuthor(author);
        newBook.setPublisher(publisher);
        newBook.setDescription(description);
        books.add(newBook);

        autoIdBook++; // Increment auto ID
    }

    public static void listBooks(ArrayList<Book> books) {
        // // Display a simple list of all the recorded books' full details
        // System.out
        // .println("\nBook ID" + "\t\t\t" + "Book Name" + "\t\t\t" + "Author Name" +
        // "\t\t\t" + "Publisher Name");
        // System.out.println("```````" + "\t\t\t" + "`````````" + "\t\t\t" +
        // "```````````" + "\t\t\t" + "``````````````");
        // // System.out.print("\n");

        // for (Book book : books) {
        // System.out.println(book.id + "\t\t\t" + book.name + "\t\t\t" + book.author +
        // "\t\t\t" + book.publisher);
        // }

        // Define the format for each column
        String format = "%-8s %-30s %-20s %-20s%n";

        // Print the header row
        System.out.format(format, "Book ID", "Book Name", "Author Name", "Publisher Name");
        System.out.format(format, "-------", "---------", "-----------", "--------------");

        // Print the book details
        for (Book book : books) {
            System.out.format(format, book.getId(), book.getName(), book.getAuthor(), book.getPublisher());
        }
    }

    public static void deleteBook(ArrayList<Book> books) {
        int targetBookId; // ID of the book to be deleted, from user input.
        System.out.print("Enter Book ID to delete: ");
        targetBookId = input.nextInt();
        input.nextLine(); // consume newline character

        // Simply iterate through the list of books, remove book if ID matches
        for (Book book : books) {

            if (book.getId() == targetBookId) {
                System.out.println("\nFound book " + book.getName() + ". Deleting!!!");
                books.remove(book); // Remove by object
                return;
            }
        }

        System.out.println("\nNo such book found! Pleae check and try again.");
    }

    public static void searchBook(ArrayList<Book> books) {
        // Get string to search from user
        String searchString;
        System.out.print("Enter string to search in one line: ");
        searchString = input.nextLine();

        // ArrayList to hold books that got a search hit
        ArrayList<Book> searchResults = new ArrayList<Book>();

        // Iterate through list of books and see if the search string is in any of the
        // string attributes
        for (Book book : books) {
            if (book.getName().toLowerCase().contains(searchString)) {
                searchResults.add(book);
            } else if (book.getAuthor().toLowerCase().contains(searchString)) {
                searchResults.add(book);
            } else if (book.getPublisher().toLowerCase().contains(searchString)) {
                searchResults.add(book);
            } else if (book.getDescription().toLowerCase().contains(searchString)) {
                searchResults.add(book);
            }
        }

        // Display books if there are any search results
        if (searchResults.size() > 0) {
            System.out.println("\nDisplaying search results...");
            listBooks(searchResults);
        } else {
            System.out.println("\nNo results found for this search!");
        }

    }

    public static void addMember() {
        String name, email;

        System.out.println("\nAdd a new member");

        // Take input from user
        System.out.print("Enter member name: ");
        name = input.nextLine();

        System.out.print("Enter email: ");
        email = input.nextLine();

        // Create new book and add it to the database
        Member newMember = new Member(1, "", "");
        newMember.setId(autoIdMember);
        newMember.setName(name);
        newMember.setEmail(email);
        members.add(newMember);

        autoIdBook++; // Increment auto ID
    }

    public static void main(String[] args) {
        // Debug data
        // Create instances with default values
        Book book1 = new Book(0, "", "", "", "");
        Book book2 = new Book(0, "", "", "", "");
        Book book3 = new Book(0, "", "", "", "");

        // Use setter methods to assign values to attributes
        book1.setId(-3);
        book1.setName("Harry Potter");
        book1.setAuthor("JK Rowling");
        book1.setPublisher("Indigo");
        book1.setDescription("Book about muggles and wizards.");

        book2.setId(-2);
        book2.setName("Percy Jackson");
        book2.setAuthor("Martin GR");
        book2.setPublisher("Pearson");
        book2.setDescription("Book about human children of ancient greek gods");

        book3.setId(-1);
        book3.setName("Lord of the rings");
        book3.setAuthor("KR Tolkien");
        book3.setPublisher("Sarasavi");
        book3.setDescription("Book about ancient civilizations in another world altogether");

        // Add debug data to books ArrayList
        books.add(book1);
        books.add(book2);
        books.add(book3);

        // Run the program in a conitnuous loop unless user wants to exit
        printWelcome();

        while (true) {
            printMainMenu(); // Print the main menu every time the program iterates
            menuChoice = input.nextLine(); // Get the user's selection

            // validate the user's selection
            if (validateMenuChoice(menuChoice)) {
                System.out.println(menuChoice + menuChoice.length());

                if (menuChoice.equals("b")) {
                    printBookMenu(); // Print section menu
                    menuChoice = input.nextLine(); // User selection of operation

                    // See which operation the user input corresponds to and call it
                    if (menuChoice.equals("a")) {
                        addBook();
                    } else if (menuChoice.equals("l")) {
                        listBooks(books);
                    } else if (menuChoice.equals("d")) {
                        deleteBook(books);
                    } else if (menuChoice.equals("s")) {
                        searchBook(books);
                    }

                } else if (menuChoice.equals("m")) {
                    printMemberMenu();
                    menuChoice = input.nextLine(); // User selection of operation

                    // See which operation the user input corresponds to and call it
                    if (menuChoice.equals("a")) {
                        addMember();
                    }

                    printArrayList(members);

                } else if (menuChoice.equals("l")) {
                    printLendingMenu();
                }

            } else {
                System.out.print("Menu choice too long. Enter one character only.\n\n\n");
            }

        }
    }
}