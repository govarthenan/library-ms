
// Main source file that aggregates all other classes and runs the whole program
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;

public class Run {
    // Input scanner for menu navigation
    static Scanner input = new Scanner(System.in);
    static String menuChoice; // Get the user's selection

    // Database
    static ArrayList<Book> books = new ArrayList<Book>();
    static ArrayList<Member> members = new ArrayList<Member>();
    static ArrayList<Lending> lendings = new ArrayList<Lending>();

    // AutoID trackers
    static int autoIdBook = 0;
    static int autoIdMember = 0;
    static int autoIdLending = 0;

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
        System.out.println("- Search for member (s)");
        System.out.print("Your selection: ");
    }

    public static void printLendingMenu() {
        System.out.println("\nPlease choose the operation");
        System.out.println("- Lend book with book and member IDs (a)");
        System.out.println("- Return a lent book (d)");
        System.out.println("- Show information about specific lending (i)");
        System.out.println("- List lent books (l)");
        System.out.println("- List overdue lendings (o)");
        System.out.print("Your selection: ");
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
        Book newBook = new Book(1, "", "", "", "", true);
        newBook.setId(autoIdBook);
        newBook.setName(name);
        newBook.setAuthor(author);
        newBook.setPublisher(publisher);
        newBook.setDescription(description);
        books.add(newBook);

        autoIdBook++; // Increment auto ID
    }

    public static void listBooks(ArrayList<Book> books) {
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
        searchString = input.nextLine().toLowerCase();

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

    public static void listMembers(ArrayList<Member> members) {
        // Define the format for each column
        String format = "%-10s %-20s %-20s%n";

        // Print the header row
        System.out.format(format, "Member ID", "Member Name", "Member Email");
        System.out.format(format, "-------", "---------", "-----------");

        // Print the book details
        for (Member member : members) {
            System.out.format(format, member.getId(), member.getName(), member.getEmail());
        }
    }

    public static void searchMember(ArrayList<Member> members) {
        // Get string to search from user
        String searchString;
        System.out.print("Enter string to search: ");
        searchString = input.nextLine().toLowerCase();

        // ArrayList to hold books that got a search hit
        ArrayList<Member> searchResults = new ArrayList<Member>();

        // Iterate through list of books and see if the search string is in any of the
        // string attributes
        for (Member member : members) {
            if (member.getName().toLowerCase().contains(searchString)) {
                searchResults.add(member);
            } else if (member.getEmail().toLowerCase().contains(searchString)) {
                searchResults.add(member);
            }
        }

        // Display books if there are any search results
        if (searchResults.size() > 0) {
            System.out.println("\nDisplaying search results...");
            listMembers(searchResults);
        } else {
            System.out.println("\nNo results found for this search!");
        }
    }

    public static void deleteMember(ArrayList<Member> members) {
        int targetMemberId; // ID of the book to be deleted, from user input.
        System.out.print("Enter Member ID to delete: ");
        targetMemberId = input.nextInt();
        input.nextLine(); // consume newline character

        // Simply iterate through the list of books, remove book if ID matches
        for (Member member : members) {

            if (member.getId() == targetMemberId) {
                System.out.println("\nFound book " + member.getName() + ". Deleting!!!");
                members.remove(member); // Remove by object
                return;
            }
        }

        System.out.println("\nNo such book found! Pleae check and try again.");
    }

    public static int[] getDate() {
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // Month is zero-based, so add 1
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // return array containing day, month and year
        int[] date = { day, month, year };
        return date;
    }

    public static void toggleBookAvailability(int bookId, boolean isAvailable) {
        // Iterate through the list of books, find the book with the given ID and
        // toggle its availability
        for (Book book : books) {
            if (book.getId() == bookId) {
                book.setAvailable(isAvailable);
                return;
            }
        }
    }

    public static void addLending() {
        // Get and assign date values
        int[] date = getDate();
        int current_day, current_month, current_year;
        current_day = date[0];
        current_month = date[1];
        current_year = date[2];

        // Get book ID from user
        int bookId;
        System.out.print("Enter book ID to lend: ");
        bookId = input.nextInt();
        input.nextLine(); // consume newline character

        // Get member ID from user
        int memberId;
        System.out.print("Enter member ID to lend to: ");
        memberId = input.nextInt();
        input.nextLine(); // consume newline character

        // Get due day, month and year from user
        int due_day, due_month, due_year;

        System.out.print("Enter due day: ");
        due_day = input.nextInt();
        input.nextLine(); // consume newline character

        System.out.print("Enter due month: ");
        due_month = input.nextInt();
        input.nextLine(); // consume newline character

        System.out.print("Enter due year: ");
        due_year = input.nextInt();
        input.nextLine(); // consume newline character

        // Create new lending and add it to the database
        Lending newLending = new Lending(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
        newLending.setId(autoIdLending);
        newLending.setBookId(bookId);
        newLending.setMemberId(memberId);
        newLending.setDue_day(due_day);
        newLending.setDue_month(due_month);
        newLending.setDue_year(due_year);
        newLending.setLend_day(current_day);
        newLending.setLend_month(current_month);
        newLending.setLend_year(current_year);

        lendings.add(newLending); // Add it to the database

        autoIdLending++; // Increment auto ID

        // Toggle book availability
        toggleBookAvailability(bookId, false);
    }

    public static void returnLending(ArrayList<Lending> lendings) {
        // Get and assign date values
        int[] date = getDate();
        int current_day, current_month, current_year;
        current_day = date[0];
        current_month = date[1];
        current_year = date[2];

        // Get book ID from user
        int bookId;
        System.out.print("Enter book ID to return: ");
        bookId = input.nextInt();
        input.nextLine(); // consume newline character

        // Iterate through the list of lendings, find the lending with the given book
        // ID and return it
        for (Lending lending : lendings) {
            if (lending.getBookId() == bookId) {
                lending.setReturn_day(current_day);
                lending.setReturn_month(current_month);
                lending.setReturn_year(current_year);

                // Delete lending from database
                lendings.remove(lending);

                // Calculate fine
                double fine = lending.calculateFine(lending.getReturn_day(), lending.getReturn_month(),
                        lending.getReturn_year());
                if (fine > 0) {
                    System.out.println("\nFine for this lending is Rs. " + fine);
                }

                // Toggle book availability
                toggleBookAvailability(bookId, true);
                return;
            }
        }

        System.out.println("\nNo such book/lending found! Pleae check and try again.");
    }

    public static void listLendings(ArrayList<Lending> lendings) {
        // Display lending ID, book ID, member ID, due date(concatenated)

        // Define the format for each column
        String format = "%-10s %-10s %-10s %-10s%n";

        // Print the header row
        System.out.format(format, "Lending ID", "Book ID", "Member ID", "Due Date");
        System.out.format(format, "----------", "-------", "---------", "--------");

        // Print the book details
        for (Lending lending : lendings) {
            System.out.format(format, lending.getId(), lending.getBookId(), lending.getMemberId(),
                    lending.getDue_day() + "/" + lending.getDue_month() + "/" + lending.getDue_year());
        }

    }

    public static void listOverdueLendings(ArrayList<Lending> lendings) {
        // Get and assign date values
        int[] date = getDate();
        int current_day, current_month, current_year;
        current_day = date[0];
        current_month = date[1];
        current_year = date[2];

        // Define the format for each column
        String format = "%-10s %-10s %-10s %-15s%n";

        // Print the header row
        System.out.format(format, "Lending ID", "Book ID", "Member ID", "Overdue By");
        System.out.format(format, "----------", "-------", "---------", "--------");

        // Print the book details
        for (Lending lending : lendings) {
            int overdueBy = lending.overdueDays(current_day, current_month, current_year);

            if (overdueBy > 0) {
                System.out.format(format, lending.getId(), lending.getBookId(), lending.getMemberId(), overdueBy);
            }
        }
    }

    public static void showLendingInfo(ArrayList<Lending> lendings, ArrayList<Book> books,
            ArrayList<Member> members) {
        // Based on the lendingId, show all available information about the specific
        // lending
        // Concatenate the day, month and year values to show the date
        // Print the book name and member name instead of their IDs
        // Print the fine if there is one
        // Since this method is run for only one lending, no need to print in a table
        // format

        // Get lending ID from user
        System.out.print("Enter lending ID to show information about: ");
        int lendingId = input.nextInt();
        input.nextLine(); // consume newline character

        // Get and assign date values
        int[] date = getDate();
        int current_day, current_month, current_year;
        current_day = date[0];
        current_month = date[1];
        current_year = date[2];

        // Iterate through the list of lendings, find the lending with the given ID and
        // return it
        for (Lending lending : lendings) {
            if (lending.getId() == lendingId) {
                // Get book name
                String bookName = "";
                for (Book book : books) {
                    if (book.getId() == lending.getBookId()) {
                        bookName = book.getName();
                        break;
                    }
                }

                // Get member name
                String memberName = "";
                for (Member member : members) {
                    if (member.getId() == lending.getMemberId()) {
                        memberName = member.getName();
                        break;
                    }
                }

                // Calculate fine
                double fine = lending.calculateFine(current_day, current_month, current_year);

                // Print the lending information
                System.out.println("\nLending ID: " + lending.getId());
                System.out.println("Book ID: " + lending.getBookId());
                System.out.println("Book Name: " + bookName);
                System.out.println("Member ID: " + lending.getMemberId());
                System.out.println("Member Name: " + memberName);
                System.out.println("Due Date: " + lending.getDue_day() + "/" + lending.getDue_month() + "/"
                        + lending.getDue_year());
                System.out.println("Lending Date: " + lending.getLend_day() + "/" + lending.getLend_month() + "/"
                        + lending.getLend_year());

                if (lending.getReturn_day() != -1) {
                    System.out.println("Return Date: " + lending.getReturn_day() + "/" + lending.getReturn_month()
                            + "/" + lending.getReturn_year());
                }

                if (fine > 0) {
                    System.out.println("Fine: Rs. " + fine);
                }

                return;
            }
        }

    }

    public static void main(String[] args) {
        // Debug data
        // Create instances with default values
        Book book1 = new Book(0, "", "", "", "", true);
        Book book2 = new Book(0, "", "", "", "", true);
        Book book3 = new Book(0, "", "", "", "", true);

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

        // Create 5 such members and add them to the members ArrayList
        Member member1 = new Member(0, "", "");
        Member member2 = new Member(0, "", "");
        Member member3 = new Member(0, "", "");
        Member member4 = new Member(0, "", "");
        Member member5 = new Member(0, "", "");

        member1.setId(-5);
        member1.setName("John Doe");
        member1.setEmail("jdoe@gm");
        members.add(member1);

        member2.setId(-4);
        member2.setName("Gova Raja");
        member2.setEmail("graja@ym");

        member3.setId(-3);
        member3.setName("Samantha");
        member3.setEmail("sam@ym");

        member4.setId(-2);
        member4.setName("Tary Sam");
        member4.setEmail("kamal@ym");

        member5.setId(-1);
        member5.setName("Nimal");
        member5.setEmail("nimal@ym");

        members.add(member1);
        members.add(member2);
        members.add(member3);
        members.add(member4);
        members.add(member5);

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
                    } else if (menuChoice.equals("l")) {
                        listMembers(members);
                    } else if (menuChoice.equals("s")) {
                        searchMember(members);
                    } else if (menuChoice.equals("d")) {
                        deleteMember(members);
                    }

                } else if (menuChoice.equals("l")) {
                    printLendingMenu();
                    menuChoice = input.nextLine(); // User selection of operation

                    if (menuChoice.equals("a")) {
                        addLending();
                    } else if (menuChoice.equals("d")) {
                        returnLending(lendings);
                    } else if (menuChoice.equals("l")) {
                        listLendings(lendings);
                    } else if (menuChoice.equals("o")) {
                        listOverdueLendings(lendings);
                    } else if (menuChoice.equals("i")) {
                        showLendingInfo(lendings, books, members);
                    }
                }

            } else {
                System.out.print("Menu choice too long. Enter one character only.\n\n\n");
            }

        }
    }
}