package Library;

import java.util.Date;

public class BookLending {
    private String bookId;//id ul cartii respective
    private String reservationDate;//data pana la care rezervatia facuta este valabila
    private String borrowedDate;//data la care cartea a fost imprumutata
    private String returnDate;//data la care cartea va fi inapoiata
    private String memberId;// id ul cititorului care a impumutat cartea

    public BookLending(String bookId, String reservationDate, String borrowedDate, String returnDate, String memberId) {
        this.bookId = bookId;
        this.reservationDate = reservationDate;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.memberId = memberId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
