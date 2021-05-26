package Library.repository;

import Library.StudyRoom;
import Library.config.SqlConnection;

import java.sql.*;

public class StudyRoomRepository {
    public static void insertStudyRoom(StudyRoom studyroom){
        String sql = "INSERT INTO studyroom(capacity,name,session,type) VALUES (?,?,?,?)";
        Connection connection = SqlConnection.getConncetion();
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,StudyRoom.getCapacity());
            statement.setString(2,StudyRoom.getName());
            statement.setDouble(3, StudyRoom.getTimeSession());
            statement.setString(4,StudyRoom.getType());
            statement.executeUpdate();
            System.out.println("Added study room.");
        }
        catch (SQLException e){
           e.printStackTrace();
        }
    }

}
