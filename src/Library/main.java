package Library;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        /*
        //connecting with db
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root", "root","qwertyu");
            System.out.println("Conectare reusita!!!");
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM library.books";
            ResultSet rs = stmt.executeQuery(sql);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        LibraryService Service = LibraryService.getInstance();
        Service.Run();
    }

}
