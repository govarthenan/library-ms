public class Book {
    private int id;
    private String name, author, publisher, description;
    boolean isAvailable;

    // Constructor
    public Book(int id, String name, String author, String publisher, String description, boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.description = description;
        this.isAvailable = isAvailable;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
