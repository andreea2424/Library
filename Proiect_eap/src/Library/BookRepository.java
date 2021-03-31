package Library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepository {
    private Map<String, Book> books;

    public BookRepository() {
        books = new HashMap<String, Book>();
    }

    public List<Book> getAllBooks() {
        return new ArrayList<Book>(books.values());
    }

    public Book getBook(String isbn) {
        if (books.containsKey(isbn))
            return new Book(books.get(isbn));

        return null;
    }

    public boolean addBook(Book book) {
        Book copy = new Book(book);

        if (!books.containsKey(copy. getBookID()))
            return books.put(copy. getBookID(), copy) == null;

        return false;
    }

    public boolean deleteBook(String isbn) {
        return books.remove(isbn) != null;
    }

    public boolean updateBook(Book book) {
        Book copy = new Book(book);

        if (books.containsKey(copy. getBookID()))
            return books.put(copy. getBookID(), copy) != null;

        return false;
    }
}