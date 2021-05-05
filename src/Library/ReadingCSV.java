package Library;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class ReadingCSV {
    private static ReadingCSV instance = null;
    public static ReadingCSV getInstance(){
        if(instance == null){
            instance  = new ReadingCSV();
        }
        return instance;
    }
    //adauga datele din fisierele csv ca obiecte in program pentru a putea fi mai usor modificate
    public void loadAccounts(HashSet<Account> accounts) throws FileNotFoundException {
        int i = 0;
        FileReader file = new FileReader("accountsForReaders.csv");
        try (BufferedReader br = new BufferedReader(file)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String username = values[0];
                String email = values[1] ;
                String password =values[2];
                String phone = values[3];
                String status = values[4];
                int readerId =Integer.parseInt(values[5]);
                Account account = new Account(username,email,password,phone,status,readerId);
                accounts.add(account);
            }
            br.close();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadReaders(HashSet<Reader> readers){
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("readers.csv"))) {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0]);
                int nr = Integer.parseInt(values[3]);
                Reader reader = new Reader(id,values[1],values[2],nr);
                readers.add(reader);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadBookLendings(ArrayList<BookLending> booklen){
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("bookLending.csv"))) {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] values = line.split(",");
                    BookLending bookLending = new BookLending(values[0], values[1], values[2], values[3], values[4]);
                    booklen.add(bookLending);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadBook(ArrayList<Book> books) throws IOException {

        int i= 0;
        try (BufferedReader br = new BufferedReader(new FileReader("books.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                    Book book = new Book(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9]);
                    books.add(book);}

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadAuthors(ArrayList<Authors> authors) throws FileNotFoundException {
        int i = 0;
        FileReader file =new FileReader("authors.csv");
        try (BufferedReader br = new BufferedReader(file)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String authID = values[0];
                String FirstName = values[1] ;
                String LastName =values[2];
                String Nationality = values[3];
                String DateOfBirth=values[4];
                String DateofDeath =values[5];
                String LiteraryMovement = values[6];
                Authors author = new Authors(authID,LastName,FirstName,Nationality,DateOfBirth,DateofDeath,LiteraryMovement);
                authors.add(author);
            }
            br.close();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
