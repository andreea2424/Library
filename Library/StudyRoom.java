package Library;

public class StudyRoom {
    private int idStudyRoom;
    private static int capacity;
    private static String name;
    private static double session;
    private static String type;//Study room with or without a PC

    public StudyRoom(int capacity, String name, double timeSession, String type) {
        this.capacity = capacity;
        this.name = name;
        this.session = timeSession;
        this.type = type;
    }

    public int getIdStudyRoom() {
        return idStudyRoom;
    }

    public void setIdStudyRoom(int idStudyRoom) {
        this.idStudyRoom = idStudyRoom;
    }

    public static int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static double getTimeSession() {
        return session;
    }

    public void setTimeSession(double timeSession) {
        this.session = timeSession;
    }

    public static String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
