package Library;

import java.io.*;
import java.util.*;

public class LibraryService {

    private static LibraryService instance = null;
    private PrintStream out;
    private Scanner in;
    private Read read;
    private static Methods methods;

    private LibraryService() {
        this.out = System.out;
        this.in = new Scanner(System.in);
        this.read=new Read(this.in,this.out);
        this.methods=Methods.getInstance();
    }
    public static LibraryService getInstance(){
        if(instance == null)
        {
            instance  = new LibraryService();
        }
        return instance;
    }

    public void addBookItem(){

        String nameOfAuthor = read.displayText("Before you add a book the author has to be in the database already."+"\n"+"Please enter the last name of the author:");
        if(methods.searchAuthorbyLastName(nameOfAuthor) ==null)
        {
            out.print("We cound't find the author, please add the author first!");
        }
        else {
            out.print("The author is in out datebase!");
            String bookID = read.displayText("Enter a bookID:");
            String name = read.displayText("Enter the name:");
            String subject = read.displayText("What is the subject of the book?");
            String nrOfPages = read.displayText("Enter the number of pages:");
            String language = read.displayText("Enter the language:");
            String borrowed = "false";
            String reserved ="false";
            String price = read.displayText("Enter the price:");
            String publicationDate =read.displayText("Enter the the year of publication :");
            String authore = methods.searchAuthorbyLastName(nameOfAuthor) ;
            Book bookToAdd = new Book(bookID,name,authore,subject,nrOfPages,language,borrowed,reserved,price,publicationDate);
            methods.addBook(bookToAdd);
            BookLending bookLending = new BookLending(bookID,"NONE","NONE","NONE","NONE");
            out.print(bookToAdd);
        }
    }

    public void addAuthor(){
            String AuthoreID = read.displayText("Enter an ID:");
            String lastName = read.displayText("Enter the last name:");
            String fistName = read.displayText("Enter the first name:");
            String nationality= read.displayText("Enter the nationality:");
            String dateOfBirth = read.displayText("Enter the date of birth:");
            String dateofDeath =  read.displayText("Enter the date of death:");
            String literaryMovement = read.displayText("Enter the literary movement:");
            Authors authorToAdd = new Authors(AuthoreID,lastName,fistName,nationality,dateOfBirth,dateofDeath,literaryMovement);
            methods.addAuthor(authorToAdd);
    }
    public void setLibraryName(){
        String name = read.displayText("The name of the library is: ");
        methods.setName(name);
    }

    public void reserveBookItem(){
        String name = read.displayText("What is the name of the book that you want to reserve?");
        //Book bookToReserve = new Book(bookID,name);
        Book bookToReserve = methods.searchByTitleForReserve(name);
        if(bookToReserve!= null){
            methods.reserveBookItem(bookToReserve);
        }
        else
        {
            out.print("The book that you are looking for is not in our database atm.");
        }
    }
    public void extendReturnDate(){
        String name = read.displayText("What is the name of the book that you want to extend the date of the return?");
        if(methods.searchByTitleForReserve(name) != null) {
            Book book= methods.searchByTitle(name);
            methods.extendsTheDate(book);
        }
        else
        {
            out.print("Looks like you spelled the name wrong :(");
        }

    }
    public void printTabel(String file){
        read.display(file);
    }

    public boolean enterTheAccount() {
        out.print("If you want to have access to out services you need an acoount.\n");
        String respond = read.displayText("Do you already have an account?yes/no?\n");
        if (respond.equals("no")) {
            String firstName = read.displayText("Enter your first name:");
            String lastName = read.displayText("Enter your last name:");
            int booksCheckedOut = 0;
            int readerID = methods.getLastId() + 1;
            Reader reader = new Reader(readerID, firstName, lastName, booksCheckedOut);
            methods.addReader(reader);
            String username = read.displayText("Enter your username:");
            String email = read.displayText("Enter your email:");
            String password = read.displayText("Enter your password:");
            String phone = read.displayText("Enter your phone:");
            String status = "NONE";
            Account account = new Account(username, email, password, phone, status, readerID);
            methods.addAccount(account);
            out.print("The account has been created.");
            methods.audit("An account has been created.");
            return false;
        } else if (respond.equals("yes")) {
            String username = read.displayText("Enter your username:");
            String password = read.displayText("Enter your password:");
            if (methods.checkInformation(username, password) != null) {
                out.print("Your username and password are correct!");
                methods.audit("A user entered the program.");
                return false;
            } else {
                out.print("Your account, password or both are wrong.:(");
                return true;
            }
        }
        return true;
    }
    public void searchBookBytitle(){
        String title = read.displayText("Enter the name of the book:");
        if(methods.searchByTitle(title)==null) {
            out.print("The book that you are looking for is not in out database at the moment.");
        }
    }
    public void searchBookByAuthor() {
        String name = read.displayText("Enter the last name of the author:");
        if(methods.searchByAuthor(name)==null) {
            out.print("The book that you are looking for is not in out database at the moment.");
        }
    }
    public void deleteBook(){
        String id = read.displayText("Enter the id of the book that you want to delete:");
        methods.deleteBook(id);
    }
    public void updateAccount(){
    }

    public void ListOfCommands(){
        out.print("\n1 - Set the name of the library.\n");
        out.print("2 - Print all books in the file.\n");
        out.print("3 - Print ll authors in the file.\n");
        out.print("4 - Print all readers in the file.\n");
        out.print("5 - Print all accounts in the file.\n");
        out.print("6 - List of commands.\n");
        out.print("7 - Add a book to the library.\n");
        out.print("8 - Delete a book.\n");
        out.print("9 - Reserve a book before you borrow it.\n");
        out.print("10 - Extern the date of return of a book.\n");
        out.print("11 - Add an author in the database.\n");
        out.print("12 - Update your account.\n");
        out.print("13 - Search a book by a title.\n");
        out.print("14 - Search a book by author.\n");

    }
    private boolean ProcessCommandForReaders() throws IOException {
        int operation = read.getPositiveIntLn();
        switch(operation){
            case 1:
                setLibraryName();
                methods.audit("The name of the library was set.");
                return false;
            case 2:
                printTabel("books");
                methods.audit("All the books in the file have been displayed.");
                return false;
            case 3:
                printTabel("authors");
                methods.audit("All the authors in the file have been displayed");
                return false;
            case 4:
                printTabel("readers");
                methods.audit("All the readers in the file have been displayed");
                return false;
            case 5:
                printTabel("accountsForReaders");
                methods.audit("All the accounts in the file have been displayed");
                return false;
            case 6:
                ListOfCommands();
                return false;
            case 7:
                addBookItem();
                methods.audit("A book has been added in the file.");
                return false;
            case 8:
                deleteBook();
                methods.audit("A book has been deleted.");
                return false;
            case 9:
                reserveBookItem();
                return false;
            case 10:
                extendReturnDate();
                return false;
            case 11:
                addAuthor();
                methods.audit("An author was added.");
                return false;
            case 12:
                updateAccount();//TO DO
                methods.audit("An account was updated.");
                return false;
            case 13:
                searchBookBytitle();
                methods.audit("An book was searched.");
                return false;
            case 14:
                searchBookByAuthor();
                methods.audit("An book was searched.");
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
        methods.readFromCSV();
        boolean exit = enterTheAccount();
        ListOfCommands();
        while (!exit){
            out.println("\nIf you want to close the program just enter 0.");
            out.println("Enter a number for the program to do something:");
            exit =  ProcessCommandForReaders();
        }
        methods.writeInCSV();
    }
}



