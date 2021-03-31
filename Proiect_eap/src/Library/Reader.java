package Library;

import java.util.*;

public class Reader extends Person  implements Search{

    private int TotalBooksCheckedout;
    private Account account;

    public Reader() {
    }

    public Reader(String fistName, String lastName) {
        super(fistName, lastName);

    }

    public Reader(String fistName, String lastName, Account account) {
        super(fistName, lastName);
        this.account = account;
    }

    public int getTotalBooksCheckedout(){

        return TotalBooksCheckedout;
    };
    public void reserveBookItem(Book book){
        System.out.println("The book that you have reserved is:"+ book.getTitle());
    }
    public void searchByTitle(HashMap<String,Book> test,String title) {
        System.out.println(test.get(title));
    }

    public void searchByAuthor(HashMap<Authors, ArrayList<Book>> test, Authors author) {
        System.out.println(test.get(author));
    }

    public void createAccount(Account account){
                this.account = account;

    }
    public Account getAccount() {
        System.out.println(account);
        return account;

    }

    /*public String deleteAccount(String e,ArrayeList<Account> accounts){
        Account e =
        accounts.remove(a);
        return "Account deleted.";
    }
*/
}
