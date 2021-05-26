package Library;

public class Book {

    private int bookID;
    private String title ;
    private int authorID;
    private String subject;
    private String nrOfPages;
    private String language;
    private String borrowed;
    private String reserved;
    private String price;
    private String publicationDate;
    private Authors author;

    public Book(int bookID, String title, int author, String subject, String nrOfPages, String language,String borrowed, String reserved,String price, String publicationDate) {
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
    public Book(int bookID, int author, String subject, String nrOfPages, String language,String borrowed, String reserved,String price, String publicationDate) {
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
    public Book( String title, int author, String subject, String nrOfPages, String language,String borrowed, String reserved,String price, String publicationDate) {
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


    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNrOfPages() {
        return nrOfPages;
    }

    public void setNrOfPages(String nrOfPages) {
        this.nrOfPages = nrOfPages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(String borrowed) {
        this.borrowed = borrowed;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return '\n' +
                "Book:"+'\n' +
                "bookID= " + bookID +'\n' +
                "Title= " + title + '\n' +
                "Subject= " + subject + '\n' +
                "Number of pages= " + nrOfPages + '\n' +
                "Language= " + language + '\n' +
                "Borrowed= " + borrowed + '\n' +
                "Reserved= " + reserved + '\n' +
                "Price= " + price + '\n' +
                "Publication date= " + publicationDate ;
    }
}
