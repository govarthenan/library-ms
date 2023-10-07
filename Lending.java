public class Lending {
    private int id, bookId, memberId;
    private int due_day, due_month, due_year;
    private int lend_day, lend_month, lend_year;
    private int return_day, return_month, return_year;

    // Constructor
    public Lending(int id, int bookId, int memberId, int due_day, int due_month, int due_year, int lend_day,
            int lend_month, int lend_year, int return_day, int return_month, int return_year) {
        this.id = id;
        this.bookId = bookId;
        this.memberId = memberId;
        this.due_day = due_day;
        this.due_month = due_month;
        this.due_year = due_year;
        this.lend_day = lend_day;
        this.lend_month = lend_month;
        this.lend_year = lend_year;
        this.return_day = return_day;
        this.return_month = return_month;
        this.return_year = return_year;
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

    public void setDue_day(int due_day) {
        this.due_day = due_day;
    }

    public int getDue_month() {
        return due_month;
    }

    public void setDue_month(int due_month) {
        this.due_month = due_month;
    }

    public int getDue_year() {
        return due_year;
    }

    public void setDue_year(int due_year) {
        this.due_year = due_year;
    }

    public int getLend_day() {
        return lend_day;
    }

    public void setLend_day(int lend_day) {
        this.lend_day = lend_day;
    }

    public int getLend_month() {
        return lend_month;
    }

    public void setLend_month(int lend_month) {
        this.lend_month = lend_month;
    }

    public int getLend_year() {
        return lend_year;
    }

    public void setLend_year(int lend_year) {
        this.lend_year = lend_year;
    }

    public int getReturn_day() {
        return return_day;
    }

    public void setReturn_day(int return_day) {
        this.return_day = return_day;
    }

    public int getReturn_month() {
        return return_month;
    }

    public void setReturn_month(int return_month) {
        this.return_month = return_month;
    }

    public int getReturn_year() {
        return return_year;
    }

    public void setReturn_year(int return_year) {
        this.return_year = return_year;
    }

}
