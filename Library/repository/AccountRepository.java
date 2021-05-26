package Library.repository;

import Library.Account;
import Library.Book;
import Library.config.SqlConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    public static void insertAccounts(Account account){

        String sql = "INSERT INTO accounts(username,email,password,phone,status,readerIDA) VALUES (?,?,?,?,?,?)";
        Connection connection = SqlConnection.getConncetion();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,account.getUsername());
            statement.setString(2,account.getEmail());
            statement.setString(3,account.getPassword());
            statement.setString(4,account.getPhone());
            statement.setString(5,account.getStatus());
            statement.setInt(6,account.getReaderId());

            statement.executeUpdate();
            System.out.println("Account added.");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void updateAccount(String email, String password, String newPassword) {
        String sql = "UPDATE accounts SET password=? WHERE email=? ";
        Connection connection = SqlConnection.getConncetion();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setString(1,password);
            preparedStatement.setString(2,email);
            preparedStatement.setString(1, newPassword);

            preparedStatement.executeUpdate();

            System.out.println("Updated password of member with email " + email);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public static List<Account> getAllAccounts() {
        String sql = "SELECT * FROM accounts";
        Connection connection = SqlConnection.getConncetion();
        List<Account> allStudents = new ArrayList<Account>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Account currentAccount = new Account(resultSet.getString(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6));
                currentAccount.setPhone(resultSet.getString(1));
                allStudents.add(currentAccount);
                System.out.println(currentAccount);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return allStudents;
    }
    public static void deleteAccountByReadeID(int rID){
        Connection connection = SqlConnection.getConncetion();
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM accounts WHERE readerIDA = ?");
            st.setInt(1,rID);
            st.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

}
