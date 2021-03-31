package Library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List <Person> persons;
    private List <Sections> sections;
    private ArrayList<Book> books;
    private ArrayList<Reader> readers;
    private Address adress;


    public Library(String name, List<Sections> sections, ArrayList<Book> books, ArrayList<Reader> readers) {
        this.name = name;
        this.sections = sections;
        this.books = books;
        this.readers = readers;

    }
}
