package Library;

import java.util.Date;

public class BookLending {
    private int bookId;//id ul cartii respective
    private String reservationDate;//data pana la care rezervarea facuta este valabila
    private String borrowedDate;//data la care cartea a fost imprumutata
    private String returnDate;//data la care cartea va fi inapoiata
    private int memberId;// id ul cititorului care a impumutat cartea

    public BookLending(int bookId, String reservationDate, String borrowedDate, String returnDate, int memberId) {
        this.bookId = bookId;
        this.reservationDate = reservationDate;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.memberId = memberId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}
