package Library;

import java.util.ArrayList;

public interface ModifyData {
    public void addBook(ArrayList<Book> books, Book book);
    public void deleteBook(ArrayList<Book> books, Book book);
    public void enterInfo(Book book);
}