package Library.config;

import java.sql.*;

public class SqlConnection {

    private static Connection connection;
    private static String URL = "jdbc:mysql://localhost:3306/library";
    private static String USER ="root";
    private static String PASSWORD = "qwertyu";

    public static Connection getConncetion() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Successfully connected to DB");
            }
        } catch (SQLException exception) {
            throw new SqlCustomException("Cannot connect to DB", exception);
        }
        return connection;
    }

    public static void closeDataBaseConnection() {
        try {
            if( connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException exception) {
            throw new SqlCustomException("Cannot close connection to DB", exception);
        }
    }
    private SqlConnection(){

    }
}


