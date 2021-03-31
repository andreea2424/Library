package Library;

public class Authors extends Person{
    private String nationality;
    private String dateOfBirth;
    private String dateofDeath;
    private String literaryMovement;

    public Authors(String lastName,String fistName,String nationality,String dateOfBirth, String dateofDeath,String literaryMovement) {
        super(fistName,lastName);
        this.nationality =nationality;
        this.dateOfBirth= dateOfBirth;
        this.dateofDeath=dateofDeath;
        this.literaryMovement=literaryMovement;
    }

    public Authors(String lastName,String fistName) {
        super(lastName,fistName);
    }
    public void setNationality(String nationality) {

        this.nationality = nationality;
    }
    public void setDateOfBirth(String dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }
    public void setDateofDeath(String dateofDeath) {

        this.dateofDeath = dateofDeath;
    }
    public void setLiteraryMovement(String literaryMovement) {
        this.literaryMovement = literaryMovement;
    }

    @Override
    public String toString() {
        return "Authors{}";
    }
}
