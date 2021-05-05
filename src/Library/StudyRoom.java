package Library;

public class StudyRoom {
    private int capacity;
    private String name;
    private double timeSession;
    private String type;//Study room with or without a PC

    public StudyRoom( String name, double timeSession, String type) {
        this.capacity = 10;
        this.name = name;
        this.timeSession = 2.30;
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getTimeSession() {
        return timeSession;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }
}
