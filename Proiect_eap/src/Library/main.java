package Library;

import java.util.*;

public class main {
    public static void main(String[] args) {

        ArrayList<Reader >Members = new ArrayList<Reader>();
        HashSet<Account> accounts = new HashSet<Account>();
        Librarian Librarian = new Librarian();
        ArrayList<Sections> Sections = new ArrayList<Sections>();
        ArrayList<Book>Books = new ArrayList<>();

        HashMap<Authors, ArrayList<Book>> searchByAuthor = new HashMap<Authors, ArrayList<Book>>();

        Library Lello = new Library("Lello",Sections,Books,Members);
        Scanner s = new Scanner(System.in);
        //Authors
        Authors Eliade = new Authors("Mircea", "Eliade");
        Authors Austen = new Authors("Austen", "Jane Austen");
        Authors Woolf = new Authors("Woolf", "Virginia");
        //Books
        Book aRoomOfOnesOwn = new Book("A Room of One's Own", Woolf);
        Book toTheLighthouse = new Book(" To the Lighthouse", Woolf);
        Book mrsDalloway = new Book("Mrs.Dalloway", Woolf);
        Book orlando = new Book("Orlando", Woolf);
        Book theWaves = new Book("The Waves", Woolf);
        Book senseAndSensibility = new Book("Sense and Sensibility", Austen);
        Book prideAndPrejudice = new Book("Pride and Prejudice", Austen);
        Book persuasion = new Book("Persuasion",Austen);

        //Key Title 1
        HashMap<String, Book> search = new HashMap<>();
        search.put(senseAndSensibility.getTitle(), senseAndSensibility);
        search.put(prideAndPrejudice.getTitle(), prideAndPrejudice);
        search.put(aRoomOfOnesOwn.getTitle(), aRoomOfOnesOwn);
        search.put(toTheLighthouse.getTitle(), toTheLighthouse);
        search.put(mrsDalloway.getTitle(), mrsDalloway);
        search.put(orlando.getTitle(), orlando);
        search.put(theWaves.getTitle(), theWaves);

        //Key Author
        ArrayList<Book> bookOfWoolf = new ArrayList<Book>();

        bookOfWoolf.add(aRoomOfOnesOwn);
        bookOfWoolf.add(toTheLighthouse);
        bookOfWoolf.add(orlando);
        bookOfWoolf.add(mrsDalloway);
        bookOfWoolf.add(theWaves);

        ArrayList<Book> bookOfAusten = new ArrayList<Book>();

        bookOfAusten.add(senseAndSensibility);
        bookOfAusten.add(prideAndPrejudice);

        //Adding the books to Books ArrayList
        for (int i = 0; i < bookOfAusten.size(); i++) {
            Books.add(bookOfAusten.get(i));
            System.out.println(Books);
        }
        for (int i = 0; i < bookOfWoolf.size(); i++) {
            Books.add(bookOfWoolf.get(i));
            System.out.println(Books);
        }

        searchByAuthor.put(Austen, bookOfAusten);
        searchByAuthor.put(Woolf, bookOfWoolf);

        //Librarian adds a book
        Librarian.addBook(Books,persuasion);
        //An account is created and assigned to a person
        Account newAccount = new Account("francescanin@s.unibuc.ro"," francescanin309","parola123456"," 0725481852");
        Account newtAccount = new Account("francescanin@s.unibuc.ro"," francescanin309","parola123456"," 0725481852");
        Reader Francesca = new Reader("Francesca","Nin",newAccount);
        Francesca.getAccount();
        //The account is added in Hashset object accounts to avoid duplicates
        accounts.add(newAccount);
        //Librarian enters more dates about a book  like book id
        Librarian.enterInfo(persuasion);
        Librarian.deleteBook(Books, prideAndPrejudice);
        System.out.println(Books);

    }
}

