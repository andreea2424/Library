package Library.repository;

import Library.Book;
import Library.BookLending;
import Library.config.SqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookLendingsRepository {
    public static BookLending getBookLendingById(int bookID) {
        String sql = "SELECT * FROM bookslendings WHERE bookID=?";
        Connection connection = SqlConnection.getConncetion();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                //    public BookLending(String bookId, String reservationDate, String borrowedDate, String returnDate, String memberId) {
                BookLending booklenging = new BookLending(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3),resultSet.getString(4),resultSet.getInt(5));
                booklenging.setBookId(resultSet.getInt(1));
                return booklenging;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void addDateOfReservation(int id, String Date) {
        String sql = "UPDATE bookslendings SET reservationDate=? WHERE bookID=?";
        Connection connection = SqlConnection.getConncetion();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,Date);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public static void insertBookLending(BookLending bookLending) {
        String sql = "INSERT INTO bookslendings(bookId,reservationDate,borrowedDate,returnDate,memberId) VALUES (?,?,?,?,?)";
        Connection connection = SqlConnection.getConncetion();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,bookLending.getBookId());
            statement.setString(2,bookLending.getReservationDate());
            statement.setString(3,bookLending.getBorrowedDate());
            statement.setString(4,bookLending.getReturnDate());
            statement.setInt(5,bookLending.getMemberId());

            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


}
