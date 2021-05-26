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
        public Reader(String fistName, String lastName, int totalBooks) {
            super(fistName, lastName);
            this.TotalBooksCheckedout=totalBooks;
        }
        public int getTotalBooksCheckedout() {
            return TotalBooksCheckedout;
        }

        public void setTotalBooksCheckedout(int totalBooksCheckedout) {
            TotalBooksCheckedout = totalBooksCheckedout;
        }

        public int getReaderID() {
            return ReaderID;
        }

        public void setReaderID(int readerID) {
            ReaderID = readerID;
        }

        public Account getAccount() {
            return account;
        }

        public void setAccount(Account account) {
            this.account = account;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Library.Reader reader = (Library.Reader) o;
            return ReaderID == reader.ReaderID;
        }

        @Override
        public int hashCode() {
            return Objects.hash(ReaderID);
        }

        @Override
        public String toString() {
            return "Reader{" +
                    "TotalBooksCheckedout=" + TotalBooksCheckedout +
                    ", ReaderID=" + ReaderID +
                    ", account=" + account +
                    ", lastName='" + lastName + '\'' +
                    ", firstName='" + firstName + '\'' +
                    '}';
        }
    }


