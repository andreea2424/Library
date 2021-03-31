package Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public  class Librarian extends Person implements ModifyData{
    private int capacity = 5;
   // private Map<String, Book> books;

    public void addBook(ArrayList<Book> books,Book book){
        books.add(book);
    };
    public void deleteBook(ArrayList<Book> books,Book book){

        books.remove(book);
    }

    public void enterInfo(Book book)
    {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter book ID: ");
        book.setBookID(input.next());

        System.out.println("Enter language: ");
        book.setLanguage(input.next());

        System.out.println("Enter subject: ");
        book.setSubject(input.next());

        System.out.println("Enter due date: ");
       // book.setDueDate(input.next());

        System.out.println("Enter number of pages : ");
        //book.setNrOfPages(input.next());

        System.out.println("Enter price: ");
        //book.setPrice(input.next());

        System.out.println("Enter publication date: ");
        //book.setPublicationDate(input.next());

        System.out.println("Enter borrowed: ");
        //book.setBorrowed(input.next());


    }
    /*public void addMember(String name, String telephoneNumber)
    {
        // if the member capacity has been reached
        if(members.size() == capacity) {
            // do this
            System.out.println("The Library is not currently taking new members as we are full, please enroll at a different library.");
        }
        //otherwise do this:
        else {
            name = name;
            tele = telephoneNumber;
            id = 0;
        }
    }*/
}
