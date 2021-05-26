package Library.config;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitializeTable {

    public static void setUpDb() {
        try(Connection dataBaseConnection = SqlConnection.getConncetion();
            Statement statement = dataBaseConnection.createStatement();)
        {
            String sql = "CREATE TABLE IF NOT EXISTS StudyRoom(id int PRIMARY KEY AUTO_INCREMENT,"+
                    "capacity int, name varchar(15), session double ,type varchar(15))";
            String sql2 = "CREATE TABLE IF NOT EXISTS Authors(AuthorID int PRIMARY KEY AUTO_INCREMENT,"+
                    "firstName varchar(15),lastName varchar(15),nationality varchar(15) ,dateOfBirth varchar(15),dateOfDeath varchar(15),literaryMovement varchar(15))";
            String sql3 = "CREATE TABLE IF NOT EXISTS Readers(ReaderID int PRIMARY KEY AUTO_INCREMENT,"+
                    "firstName varchar(15),lastName varchar(15),TotalBooksCheckedout int)";
            String sql4 = "CREATE TABLE IF NOT EXISTS Books(bookID int PRIMARY KEY AUTO_INCREMENT,"+
            "  title VARCHAR(40) , AuthorIDB  INT, subject VARCHAR(30), nrOfPages VARCHAR(30), language VARCHAR(30), borrowed VARCHAR(30), reserved VARCHAR(30), price INT(5), publicationYear INT(4))";
            String sql5 = "CREATE TABLE IF NOT EXISTS Accounts(username VARCHAR(30),email VARCHAR(30),password VARCHAR(30),phone INT(10) PRIMARY KEY , status VARCHAR(30),readerIDA INT(4))";
            String sql6 = "CREATE TABLE IF NOT EXISTS BooksLendings(bookId  int, reservationDate VARCHAR(30), borrowedDate VARCHAR(30), returnDate VARCHAR(30), memberId int )";
            statement.executeUpdate(sql);
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);
            statement.executeUpdate(sql4);
            statement.executeUpdate(sql5);
            statement.executeUpdate(sql6);
            System.out.println("Successfully created tables.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteAllTables() {
        try(Connection dataBaseConnection = SqlConnection.getConncetion();
            Statement statement = dataBaseConnection.createStatement();)
        {
            String sql =  "DROP TABLE StudyRoom ";
            String sql2 = "DROP TABLE Authors";
            String sql3 = "DROP TABLE Readers";
            String sql4 = "DROP TABLE Books ";
            String sql5 = "DROP TABLE Accounts";
            String sql6 = "DROP TABLE BooksLeandings";
            statement.executeUpdate(sql);
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);
            statement.executeUpdate(sql4);
            statement.executeUpdate(sql5);
            statement.executeUpdate(sql6);
            System.out.println("Successfully created tables.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {
          String sql = "CREATE TABLE REGISTRATION " +
                   "(id INTEGER not NULL, " +
                   " first VARCHAR(255), " +
                   " last VARCHAR(255), " +
                   " age INTEGER, " +
                   " PRIMARY KEY ( id ))";

         stmt.executeUpdate(sql);
         System.out.println("Created table in given database...");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}*/
    private InitializeTable() {
    }
}