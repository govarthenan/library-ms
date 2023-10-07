public class Lending {
    private int id, bookId, memberId, due_day, due_month, due_year;

    // Constructor
    public Lending(int id, int bookId, int memberId, int due_day, int due_month, int due_year) {
        this.id = id;
        this.bookId = bookId;
        this.memberId = memberId;
        this.due_day = due_day;
        this.due_month = due_month;
        this.due_year = due_year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getDue_day() {
        return due_day;
    }

    public void setDue_day(int date) {
        this.due_day = date;
    }

    public int getDue_month() {
        return due_month;
    }

    public void setDue_month(int month) {
        this.due_month = month;
    }

    public int getDue_year() {
        return due_year;
    }

    public void setDue_year(int year) {
        this.due_year = year;
    }
}
