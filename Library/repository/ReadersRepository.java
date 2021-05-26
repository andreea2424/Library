package Library.repository;

import Library.Reader;
import Library.config.SqlConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReadersRepository {
    public static void insertReader(Reader reader){

        String sql = "INSERT INTO accounts(readerID,lastName,firstName,TotalBooksCheckedout) VALUES (?,?,?,?)";
        Connection connection = SqlConnection.getConncetion();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,reader.getReaderID());
            statement.setString(2,reader.getLastName());
            statement.setString(3,reader.getFirstName());
            statement.setInt(4,reader.getTotalBooksCheckedout());
            statement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Reader getReaderById(int ReaderID) {
        String sql = "SELECT * FROM readers WHERE ReaderID=?";
        Connection connection = SqlConnection.getConncetion();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ReaderID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                Reader reader = new Reader(resultSet.getString(2), resultSet.getString(3),resultSet.getInt(4));
                reader.setReaderID(resultSet.getInt(1));
                System.out.println(reader);
                return reader;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateReaderFirstnameById(String newFirstName, int id) {
        String sql = "UPDATE readers SET lastName=? WHERE ReaderID=?";
        Connection connection = SqlConnection.getConncetion();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newFirstName);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();

            System.out.println("Updated member with id " + id);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public static List<Reader> getAllReaders() {
        String sql = "SELECT * FROM readers";
        Connection connection = SqlConnection.getConncetion();
        List<Reader> allReaders = new ArrayList<Reader>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Reader reader = new Reader(resultSet.getString(2), resultSet.getString(3),resultSet.getInt(4));
                reader.setReaderID(resultSet.getInt(1));
                allReaders.add(reader);
                System.out.println(reader);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return allReaders;
    }
    public static void deleteReaderByReadeID(int rID){
        Connection connection = SqlConnection.getConncetion();
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM readers WHERE readerID = ?");
            st.setInt(1,rID);
            st.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
