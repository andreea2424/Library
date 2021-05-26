package Library;

import Library.config.InitializeTable;
import Library.config.SqlConnection;
import Library.repository.*;

import java.io.*;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LibraryService {

    private static LibraryService instance = null;
    private PrintStream out;
    private Scanner in;
    private Read read;
    Calendar cal = Calendar.getInstance();

    private LibraryService() {
        this.out = System.out;
        this.in = new Scanner(System.in);
        this.read=new Read(this.in,this.out);

    }
    public static LibraryService getInstance(){
        if(instance == null)
        {
            instance  = new LibraryService();
        }
        return instance;
    }
    public void getBook(){
        String name = read.displayText("Name of the book");
        System.out.println(BooksRepository.getBookByTitle(name));
    }

    public void addBookItem(){

        String nameOfAuthor = read.displayText("Before you add a book the author has to be in the database already."+"\n"+"Please enter the last name of the author:");
        if(AuthorsRepository.getAuthorByLastName(nameOfAuthor) ==null)
        {
            out.print("We cound't find the author, please add the author first!");
        }
        else {
            out.print("The author is in out datebase!");
            int id = read.displayTextforInt("Enter the id:");
            String name = read.displayText("Enter the name:");
            String subject = read.displayText("What is the subject/gender of the book?");
            String nrOfPages = read.displayText("Enter the number of pages:");
            String language = read.displayText("Enter the language:");
            String borrowed = "false";
            String reserved ="false";
            String price = read.displayText("Enter the price:");
            String publicationDate =read.displayText("Enter the the year of publication :");
            int authore = AuthorsRepository.getAuthorByLastName(nameOfAuthor).getAuthorID() ;
            Book bookToAdd = new Book(id,name,authore,subject,nrOfPages,language,borrowed,reserved,price,publicationDate);
            BooksRepository.insertBook(bookToAdd);
            BookLending bookLending = new BookLending(bookToAdd.getBookID(),"NONE","NONE","NONE",0);
            BookLendingsRepository.insertBookLending(bookLending);
        }
    }

    public void addAuthor(){

             int id = read.displayTextforInt("Enter the id:");
            String lastName = read.displayText("Enter the last name:");
            String fistName = read.displayText("Enter the first name:");
            String nationality= read.displayText("Enter the nationality:");
            String dateOfBirth = read.displayText("Enter the date of birth:");
            String dateofDeath =  read.displayText("Enter the date of death:");
            String literaryMovement = read.displayText("Enter the literary movement:");
            Authors authorToAdd = new Authors(id,lastName,fistName,nationality,dateOfBirth,dateofDeath,literaryMovement);
            AuthorsRepository.insertAuthor(authorToAdd);
    }

   public Book reserveBookItem(){
       String name = read.displayText("What is the name of the book that you want to reserve?");
       //Book bookToReserve = new Book(bookID,name);
       Book bookToReserve = BooksRepository.getBookByTitle(name);

       if(bookToReserve!= null){
           System.out.println(bookToReserve.getBorrowed().equals("true"));
               if (bookToReserve.getBorrowed().equals("true")) {//data dupa reurnarea cartii
                   if (bookToReserve.getReserved().equals("true"))
                   {
                       System.out.println("The book you have requested is already reserved.");
                       return null;
                   }
                   BookLending bookLending = BookLendingsRepository.getBookLendingById(bookToReserve.getBookID());
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
                           BookLendingsRepository.addDateOfReservation(bookToReserve.getBookID(),nextDate);
                           return null;
                       } catch (ParseException e) {
                           e.printStackTrace();
                       }
                   }
               }
               if (bookToReserve.getReserved().equals("true"))
               {
                   System.out.println("The book you have requested is already reserved.");
                   return null;
               }
               else if (bookToReserve.getReserved().equals("false"))
               {
                   System.out.println("The book that you want to reserve," + bookToReserve.getTitle() + ",is available. Your reservation is available 24h.");
                   BooksRepository.updateBookReservedStatus(bookToReserve.getBookID());
                   return bookToReserve;
               }
               return null;
           }
       else
       {
           out.print("The book that you are looking for is not in our database atm.");
       }
       return null;
   }

   public void updateReader(){
       int id =read.displayTextforInt("Enter the id of the member that you want to modify:");
       String lastName = read.displayText("Enter the new name:");
       ReadersRepository.updateReaderFirstnameById(lastName,id);
   }
   public void createAccount(){
       //String firstName = read.displayText("Enter your first name:");
       //String lastName = read.displayText("Enter your last name:");
       //int booksCheckedOut = 0;

       //Reader reader = new Reader(readerID, firstName, lastName, booksCheckedOut);
       //ReadersRepository.insertReader(new Reader(readerID, firstName, lastName, booksCheckedOut));
       int readerID =read.displayTextforInt("Enter member id:");
       String username = read.displayText("Enter your username:");
       String email = read.displayText("Enter your email:");
       String password = read.displayText("Enter your password:");
       String phone = read.displayText("Enter your phone:");
       String status = "NONE";
       Account account = new Account(username, email, password, phone, status, readerID);
       AccountRepository.insertAccounts(account);
   }
   public void updateAccount(){
       String email = read.displayText("Enter your email:");
       String password = read.displayText("Enter the password of your account:");
       String newpassword = read.displayText("Enter the new password:");
       AccountRepository.updateAccount(email,password,newpassword);
   }
   public void deleteBook(){
       String title = read.displayText("Enter the title of the book:");
       BooksRepository.deleteBookByTitle(title);
   }
    public void deleteAccount(){
        int id = read.displayTextforInt("Enter the member id:");
        AccountRepository.deleteAccountByReadeID(id);
        ReadersRepository.deleteReaderByReadeID(id);
    }
    public void deleteAuthor(){
        int id = read.displayTextforInt("Enter the id:");
        AuthorsRepository.deleteAuthor(id);
    }
    public void ListOfCommands(){
        out.print("\n1 - Connected to the library database. \n");
        out.print("2 - Print all books in the file.\n");
        out.print("3 - Print ll authors in the file.\n");
        out.print("4 - Print all readers in the file.\n");
        out.print("5 - Print all accounts in the file.\n");
        out.print("6 - List of commands.\n");
        out.print("7 - Add a book to the library.\n");
        out.print("8 - Delete a book.\n");
        out.print("9 - Reserve a book before you borrow it.\n");
        out.print("10 - Delete all tables.\n");
        out.print("11 - Add an author in the database.\n");
        out.print("12 - Reset your password.\n");
        out.print("13 - Update member by id.\n");
        out.print("14 - Search for a book in the database.\n");
        out.print("15 - Create an account.\n");
        out.print("16 - Delete account.\n");
        out.print("17 - Delete author.\n");


    }
    private boolean ProcessCommandForReaders() throws IOException {
        int operation = read.getPositiveIntLn();
        switch(operation){
            case 1:
                InitializeTable.setUpDb();
                return false;
            case 2:
                BooksRepository.getAllBooks();
                return false;
            case 3:
                AuthorsRepository.getAllAuthors();
                return false;
            case 4:
                ReadersRepository.getAllReaders();
                return false;
            case 5:
                AccountRepository.getAllAccounts();
                return false;
            case 6:
                ListOfCommands();
                return false;
            case 7:
                addBookItem();
                return false;
            case 8:
                deleteBook();
                return false;
            case 9:
                reserveBookItem();
                return false;
            case 10:
                InitializeTable.deleteAllTables();
                return false;
            case 11:
                addAuthor();
                return false;
            case 12:
                updateAccount();
                return false;
            case 13:
                updateReader();
                return false;
            case 14:
                getBook();
                return false;
            case 15:
                createAccount();
                return false;
            case 16:
                deleteAccount();
                return false;
            case 17:
                deleteAuthor();
                return false;
            case 0:
                out.println("~~See you later~~");
                return true;
            default:
                out.println("You entered an incorrect number.:(");
                ListOfCommands();
                return false;
        }
    }

    public void Run() throws IOException {
        InitializeTable.setUpDb();
        boolean exit = false;
        ListOfCommands();
        while (!exit){
            out.println("\nIf you want to close the program just enter 0.");
            out.println("Enter a number for the program to do something:");
            exit =  ProcessCommandForReaders();
        }
        SqlConnection.closeDataBaseConnection();
    }
}



