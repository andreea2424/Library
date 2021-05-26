package Library;

import Library.config.InitializeTable;
import Library.config.SqlConnection;
import Library.repository.StudyRoomRepository;

import java.io.IOException;
import java.sql.*;

public class main {
    public static void main(String[] args) throws IOException {

        LibraryService Service = LibraryService.getInstance();
        Service.Run();
    }
}
