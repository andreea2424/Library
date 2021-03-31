package Library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public interface Search {
    public void searchByTitle(HashMap<String,Book> test, String title) ;
    public void searchByAuthor(HashMap<Authors, ArrayList<Book>> test, Authors author) ;
    public static String createAccount(String e, String u, String p, String n, HashSet<Account> accounts) {
        return null;
    }
    public int getTotalBooksCheckedout();

}
