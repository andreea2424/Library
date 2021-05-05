package Library;

public class Book {

    private String bookID;
    private String title ;
    private String authorID;
    private String subject;
    private String nrOfPages;
    private String language;
    private String borrowed;
    private String reserved;
    private String price;
    private String publicationDate;
    private Authors author;

    public Book(String bookID, String title, String author, String subject, String nrOfPages, String language,String borrowed, String reserved,String price, String publicationDate) {
        this.bookID = bookID;
        this.title = title;
        this.authorID = author;
        this.subject = subject;
        this.nrOfPages = nrOfPages;
        this.language = language;
        this.borrowed = borrowed;
        this.reserved = reserved;
        this.price = price;
        this.publicationDate = publicationDate;

    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    public String getAuthorID() {
        return authorID;
    }

    public  String getTitle() {
        return title;
    }

    public String getNrOfPages() {
        return nrOfPages;
    }

    public String getSubject() {
        return subject;
    }

    public String getLanguage() {
        return language;
    }

    public String getPrice() {
        return price;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getBorrowed() {
        return borrowed;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }


    @Override
    public String toString() {
        return "\n"+""+bookID + "," + title + "," + authorID + "," + subject + "," + nrOfPages + "," + language + "," + reserved + "," + borrowed + "," + price + "," + publicationDate;
    }
    public String getBookID() {
        return bookID;
    }

}
