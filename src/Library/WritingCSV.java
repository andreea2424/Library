package Library;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
public class WritingCSV {
    private static WritingCSV instance = null;
    public static WritingCSV getInstance(){
        if(instance == null){
            instance  = new WritingCSV();
        }
        return instance;
    }
    final static  String CSV_SEPARATOR = ",";
    public void addBookUpdate(ArrayList<Book> books) throws IOException {
        PrintWriter writerr = new PrintWriter("books.csv");
        writerr.print("");
        writerr.close();

        for (Book book : books) {

            File file = new File("books.csv");
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(writer);
            PrintWriter pr = new PrintWriter(writer);
            try {
                file.delete();
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(book.getBookID().trim().length() == 0 ? "" : book.getBookID());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(book.getTitle().trim().length() == 0 ? "" : book.getTitle());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(book.getAuthorID().trim().length() == 0 ? "" : book.getAuthorID());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(book.getSubject().trim().length() == 0 ? "" : book.getSubject());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(book.getNrOfPages());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(book.getLanguage());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(book.getBorrowed());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(book.getReserved());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(book.getPrice());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(book.getPublicationDate());
                oneLine.append(CSV_SEPARATOR);
                // System.out.println(oneLine.toString());
                bw.write(oneLine.toString());
                bw.write("\n");
                bw.close();
                bw.flush();
                writer.flush();
                writer.close();
            } catch (IOException ioException) {
            }
        }
    }
    public void addReadersUpdate(HashSet<Reader>readers) throws IOException {
        PrintWriter writerr = new PrintWriter("readers.csv");
        writerr.print("");
        writerr.close();

        for (Reader reader : readers) {

            File file = new File("readers.csv");
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(writer);
            PrintWriter pr = new PrintWriter(writer);
            try {
                file.delete();
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(reader.getReaderID());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(reader.getFirstName().trim().length() == 0 ? "" : reader.getFirstName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(reader.getLastName().trim().length() == 0 ? "" : reader.getLastName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(reader.getTotalBooksCheckedout());
                // System.out.println(oneLine.toString());
                bw.write(oneLine.toString());
                bw.write("\n");
                bw.close();
                bw.flush();
                writer.flush();
                writer.close();
            } catch (IOException ioException) {
            }
        }
    }

    public void addAccountsUpdate(HashSet<Account> accounts) throws IOException {
        PrintWriter writerr = new PrintWriter("accountsForReaders.csv");
        writerr.print("");
        writerr.close();
        writerr.flush();

        for (Account account : accounts) {

            FileWriter writer = new FileWriter("accountsForReaders.csv", true);
            BufferedWriter bw = new BufferedWriter(writer);
            PrintWriter pr = new PrintWriter(writer);
            try {
                //file.delete();
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(account.getUsername());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(account.getEmail().trim().length() == 0 ? "" : account.getEmail());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(account.getPassword().trim().length() == 0 ? "" : account.getPassword());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(account.getPhone());
               // System.out.println(account.getPhone());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(account.getStatus().trim().length() == 0 ? "" : account.getStatus());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(account.getReaderId());
                // System.out.println(oneLine.toString());
                bw.write(oneLine.toString());
                bw.write("\n");
                bw.close();
                bw.flush();
                writer.flush();
                writer.close();
            } catch (IOException ioException) {
            }
        }
    }
    public void addBookLendingUpdate(ArrayList<BookLending> bookLendings) throws IOException {
        PrintWriter writerr = new PrintWriter("bookLending.csv");
        writerr.print("");
        writerr.close();
        writerr.flush();

        for (BookLending bookLen : bookLendings) {

            FileWriter writer = new FileWriter("bookLending.csv", true);
            BufferedWriter bw = new BufferedWriter(writer);
            PrintWriter pr = new PrintWriter(writer);
            try {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(bookLen.getBookId());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(bookLen.getReservationDate());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(bookLen.getBorrowedDate());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(bookLen.getReturnDate());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(bookLen.getMemberId());
                oneLine.append(CSV_SEPARATOR);
                bw.write(oneLine.toString());
                bw.write("\n");
                bw.close();
                bw.flush();
                writer.flush();
                writer.close();
            } catch (IOException ioException) {
            }
        }
    }
    public void addAuthorsUpdate(ArrayList<Authors> authors) throws IOException {
        PrintWriter writerr = new PrintWriter("authors.csv");
        writerr.print("");
        writerr.close();
        writerr.flush();

        for (Authors author : authors) {

            FileWriter writer = new FileWriter("authors.csv", true);
            BufferedWriter bw = new BufferedWriter(writer);
            PrintWriter pr = new PrintWriter(writer);
            try {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(author.getAuthorID());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(author.getLastName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(author.getFirstName());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(author.getNationality());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(author.getDateOfBirth());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(author.getDateofDeath());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(author.getLiteraryMovement());
                oneLine.append(CSV_SEPARATOR);
                bw.write(oneLine.toString());
                bw.write("\n");
                bw.close();
                bw.flush();
                writer.flush();
                writer.close();
            } catch (IOException ioException) {
            }
        }
    }
}