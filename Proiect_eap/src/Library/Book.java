package Library;

import java.util.Date;

public class Book {

    private String title ;
    private String subject;
    private int nrOfPages;
    private String language;
    private Authors authors;
    private String bookID;
    private Date borrowed;
    private boolean reserved;
    private Date dueDate;
    private double price;
    private Date publicationDate;
    private BookLocation placedAt;

    public Book() {
    }

    public Book(String title, int nrPages, int price, Authors authors) {
        this.authors=authors;
        this.title = title;
        this.nrOfPages=nrOfPages;
        this.price= price;
    }
    public Book(String title, Authors authors) {
        this.authors=authors;
        this.title = title;
        this.nrOfPages=nrOfPages;
        this.price= price;
    }

    public Book(Book book) {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public  String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors.getFirstName();
    }

    public void setAuthors(String name) {
        authors.setFirstName(name);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public void setNrOfPages(int nrOfPages) {
        this.nrOfPages = nrOfPages;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setBorrowed(Date borrowed) {
        this.borrowed = borrowed;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setPlacedAt(BookLocation placedAt) {
        this.placedAt = placedAt;
    }

    @Override
    public String toString() {
        return  "\n"+"Book{" +
                "title='" + title + "\n" +
                ", subject='" + subject + "\n" +
                ", nrOfPages=" + nrOfPages +
                ", language='" + language + "\n" +
                ", authors=" + authors +"\n" +
                ", bookID='" + bookID + "\n" +
                ", borrowed=" + borrowed +"\n" +
                ", reserved=" + reserved +"\n" +
                ", dueDate=" + dueDate +"\n" +
                ", price=" + price +"\n" +
                ", publicationDate=" + publicationDate +"\n" +
                ", placedAt=" + placedAt +"\n" ;
    }

    public String getBookID() {
        return bookID;
    }
}
