package Library.repository;

import Library.Authors;
import Library.Book;
import Library.config.SqlConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorsRepository {

        public static Authors getAuthorByLastName(String lastName) {
            String sql = "SELECT * FROM authors WHERE lastName=?";
            Connection connection = SqlConnection.getConncetion();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,lastName);
                ResultSet resultSet = preparedStatement.executeQuery();//problema
                if (resultSet.next()) {
                    Authors authors = new Authors(resultSet.getString(1), resultSet.getString(2),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));
                    authors.setAuthorID(resultSet.getInt(1));
                    System.out.println(authors);
                    return authors;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
    }
    public static void insertAuthor(Authors author){

        String sql = "INSERT INTO authors(AuthorID,firstName,lastName,nationality,dateOfBirth,dateOfDeath,literaryMovement) VALUES (?,?,?,?,?,?,?)";
        Connection connection = SqlConnection.getConncetion();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,author.getAuthorID());
            statement.setString(2,author.getFirstName());
            statement.setString(3,author.getLastName());
            statement.setString(4,author.getNationality());
            statement.setString(5, author.getDateOfBirth());
            statement.setString(6,author.getDateofDeath());
            statement.setString(7, author.getLiteraryMovement());

            statement.executeUpdate();
            System.out.println("Added author");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static List<Authors> getAllAuthors() {
        String sql = "SELECT * FROM authors";
        Connection connection = SqlConnection.getConncetion();
        List<Authors> allAuthors = new ArrayList<Authors>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Authors author = new Authors(resultSet.getString(2), resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7));
                author.setAuthorID(resultSet.getInt(1));
                allAuthors.add(author);
                System.out.println(author);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return allAuthors;
    }
    public static void deleteAuthor(int ID){
        Connection connection = SqlConnection.getConncetion();
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM authors WHERE AuthorID = ?");
            st.setInt(1,ID);
            st.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
