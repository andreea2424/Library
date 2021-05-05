package Library;

import java.util.Objects;

public class Reader extends Person  {

    private int TotalBooksCheckedout;
    private int ReaderID;
    private Account account;
    public Reader(int readerID,String fistName, String lastName, int totalBooks) {
        super(fistName, lastName);
        this.ReaderID =readerID;
        this.TotalBooksCheckedout=totalBooks;
    }

    public int getReaderID() {
        return ReaderID;
    }

    public int getTotalBooksCheckedout() {
        return TotalBooksCheckedout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return ReaderID == reader.ReaderID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ReaderID);
    }
}
