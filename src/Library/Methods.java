package Library;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Methods {

    private String Libraryname;
    private Library library;
    private ArrayList<Authors> authors;
    private HashSet<Account> accounts;
    private HashSet<Reader> readers;
    private  ArrayList<Book> books ;
    private ArrayList<BookLending> bookLendings;
    private static Methods instance = null;
    Calendar cal = Calendar.getInstance();

    private Methods(){
        this.authors = new ArrayList<>();
        this.readers = new HashSet<>();
        this.books = new ArrayList<>();
        this.accounts = new HashSet<>();
        this.bookLendings = new ArrayList<>();
    }
    public static Methods getInstance(){
        if(instance == null){
            instance  = new Methods();
        }
        return instance;
    }
    public void addBook(Book book){
        books.add(book);
    }
    public void setName(String name){
        if(library == null)
        {
            library = new Library();
        }
        this.Libraryname = name;
    }

    public String searchAuthorbyLastName(String lastName)
    {
        for(Authors author: authors)
        {
            if(author.getLastName().equals(lastName))
            {
                return author.getAuthorID();
            }
        }
        return null;
    }
    public Authors searchAuthorbyID(String ID)
    {
        for(Authors author: authors)
        {
            if(author.getAuthorID().equals(ID)){
                return author;}
        }
        return null;
    }
    public Book searchByTitle(String title) {
        for (Book book : books) {
           if (book.getTitle().equals(title))
            {   String author = searchAuthorbyID(book.getAuthorID()).getLastName();
                System.out.println( "Titlul cartii:" + book.getTitle()+"\n"+"Numele autorului:"+author+"\n");
                return book;
            }
        }
        return null;
    }
    public Book searchByAuthor(String lastName) {
        String id = searchAuthorbyLastName(lastName);
        if(id!=null){
            for (Book book : books) {
                if (book.getAuthorID().equals(id))
                {   String author = searchAuthorbyID(book.getAuthorID()).getLastName();
                    System.out.println( "Titlul cartii:" + book.getTitle()+"\n"+"Numele autorului:"+author+"\n");
                    return book;
                }
            }
        }
        return null;
    }
    public Book searchByTitleForReserve(String title){
        for (Book book : books) {
            if (book.getTitle().equals(title))
            {
                return book;
            }
        }
        return null;
    }
    public BookLending searchBookLend(String bookId){
        for(BookLending bookLending : bookLendings){
            if(bookLending.getBookId().equals(bookId)){
                return bookLending;
            }
        }
        return null;
    }
    public Book reserveBookItem(Book book) {
        if (book.getBorrowed().equals("true")) {//data dupa returnarea cartii
            BookLending bookLending = searchBookLend(book.getBookID());
            if (bookLending != null) {
                try {
                    String firstDate = bookLending.getReturnDate();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = formatter.parse(firstDate);
                    cal.setTime(date);
                    cal.add(Calendar.DAY_OF_MONTH, 1);
                    String nextDate;
                    nextDate =formatter.format(cal.getTime());
                    bookLending.setReservationDate(nextDate);
                    System.out.println("The book you have requested is already booked, it will be available again on: " + nextDate);
                    return null;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        if (book.getReserved().equals("true"))
        {
            System.out.println("The book you have requested is already reserved");
            return null;
        }
        else if (book.getReserved().equals("false"))
        {
            System.out.println("The book that you want to reserve," + book.getTitle() + ",is available. Your reservation is available 24h.");
            book.setReserved("true");
            audit("A book was reserved");
            return book;
        }
        return null;
    }

    public void addAuthor(Authors author){
        authors.add(author);
    }
    public void searchBkLend(){
        for(BookLending bookLending : bookLendings) {
            System.out.println(bookLending.getBookId());
        }
    }
    public void extendsTheDate(Book book) {
        if (book.getReserved().equals("true")) {
            System.out.println("The book you have requested is already reserved,you can't extent the return");
        } else {
            BookLending bookLending = searchBookLend(book.getBookID());
            if(bookLending != null){
            try {
                String firstDate = bookLending.getReturnDate();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date date = formatter.parse(firstDate);
                cal.setTime(date);
                cal.add(Calendar.DAY_OF_MONTH, 14);
                String nextDate;
                nextDate = formatter.format(cal.getTime());
                bookLending.setReturnDate(nextDate);
                System.out.println("The next return date of the book is:" + nextDate);
                audit("A date of return was extended.");
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
        }
            else {
                System.out.println("Something went wrong >.<");
            }
        }

    }
        public void reserveStudyRoom(StudyRoom studyRoom){
        if( studyRoom.getCapacity() > 0)
        {
            System.out.println("Your place has been reserved");
            studyRoom.setCapacity(9);
        }
        else
        {
            System.out.println("We no longer have seats available in this study room, please try another one.");
        }
    }
    /*public void createAccount(Account account){
        this.account = account;
    }*/
    public Account checkInformation(String username, String password){
        for(Account account: accounts){
            if(username.equals(account.getUsername()) && password.equals(account.getPassword())){
                return account;
            }
        }
        return null;
    }
    public int getLastId(){
      int reader = readers.size()-1;
      return reader;
    }
    public void addReader(Reader reader){
        readers.add(reader);
    }
    public void addAccount(Account account){

        accounts.add(account);
    }
    public ArrayList<Book> deleteBook(String id){
        for(Book book:books){
         if(book.getBookID().equals(id)){
             books.remove(book);return books;
         }
        }
        return null;
    }

    public void audit(String mesg) {
        cal.setTime(new Date());
        SimpleDateFormat format4 = new SimpleDateFormat("dd-M-yyyy hh:mm");
        String data = format4.format(cal.getTime());
        File file = new File("audit.csv");
        try {
            FileWriter writer = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(writer);
            StringBuffer oneLine = new StringBuffer();
            oneLine.append(mesg);
            oneLine.append(",");
            oneLine.append(data);
            bw.write(oneLine.toString());
            bw.write("\n");
            bw.close();
        }
        catch (IOException ioException){}
}
    public void writeInCSV() throws IOException {
        WritingCSV writingCSV = WritingCSV.getInstance();
        writingCSV.addAccountsUpdate(accounts);
        writingCSV.addBookUpdate(books);
        writingCSV.addReadersUpdate(readers);
        writingCSV.addBookLendingUpdate(bookLendings);
        writingCSV.addAuthorsUpdate(authors);
    }
    public void readFromCSV() throws IOException {
        ReadingCSV readingCSV= ReadingCSV.getInstance();
        readingCSV.loadAccounts(accounts);
        readingCSV.loadAuthors(authors);
        readingCSV.loadBook(books);
        readingCSV.loadReaders(readers);
        readingCSV.loadBookLendings(bookLendings);
    }

}


