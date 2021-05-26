package Library.repository;

import Library.Book;
import Library.config.SqlConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BooksRepository {

    public static Book getBookById(int bookID) {
        String sql = "SELECT * FROM books WHERE bookID=?";
        Connection connection = SqlConnection.getConncetion();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Book book = new Book(resultSet.getString(2), resultSet.getInt(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10));
                book.setBookID(resultSet.getInt(1));
                System.out.println(book);
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deleteBookByTitle(String title){
        Connection connection = SqlConnection.getConncetion();
        try {
        PreparedStatement st = connection.prepareStatement("DELETE FROM books WHERE title = ?");
        st.setString(1,title);
        st.executeUpdate();
    } catch(Exception e) {
        System.out.println(e);
    }
    }
    public static Book getBookByTitle(String title) {
        String sql = "SELECT * FROM books WHERE title=?";
        Connection connection = SqlConnection.getConncetion();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Book book = new Book(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10));
                book.setBookID(resultSet.getInt(1));
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void insertBook(Book book){

        String sql = "INSERT INTO books(bookID,title,authorIDB,subject,nrOfPages,language,borrowed,reserved,price,publicationYear) VALUES (?,?,?,?,?,?,?,?,?,?)";
        Connection connection = SqlConnection.getConncetion();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,book.getBookID());
            statement.setString(2,book.getTitle());
            statement.setInt(3,book.getAuthorID());
            statement.setString(4,book.getSubject());
            statement.setString(5,book.getNrOfPages());
            statement.setString(6,book.getLanguage());
            statement.setString(7,book.getBorrowed());
            statement.setString(8,book.getReserved());
            statement.setString(9,book.getPrice());
            statement.setString(10,book.getPublicationDate());

            statement.executeUpdate();
            System.out.println("Added book");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void updateBookReservedStatus(int id) {
        String sql = "UPDATE books SET reserved=? WHERE bookID=?";
        Connection connection = SqlConnection.getConncetion();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"true");
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

            System.out.println("Updated name of student with id " + id);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

   public static List<Book>getAllBooks() {
        String sql = "SELECT * FROM books";
        Connection connection = SqlConnection.getConncetion();
        List<Book> allBooks = new ArrayList<Book>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql); // executeQuery - pentru ca avem QUERY

            while (resultSet.next()) {
                Book books = new Book(resultSet.getString(2), resultSet.getInt(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10));
                books.setBookID(resultSet.getInt(1));
                allBooks.add(books);
                System.out.println(books);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return allBooks;
    }

}
