package Library;

public class Authors extends  Person{
    private String nationality;
    private String dateOfBirth;
    private String dateofDeath;
    private String literaryMovement;
    private String AuthorID;

    public Authors(String AuthoreID,String lastName, String fistName, String nationality, String dateOfBirth, String dateofDeath, String literaryMovement) {
        super(fistName,lastName);
        this.AuthorID = AuthoreID;
        this.nationality =nationality;
        this.dateOfBirth= dateOfBirth;
        this.dateofDeath=dateofDeath;
        this.literaryMovement=literaryMovement;
    }


    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateofDeath() {
        return dateofDeath;
    }

    public void setDateofDeath(String dateofDeath) {
        this.dateofDeath = dateofDeath;
    }

    public String getLiteraryMovement() {
        return literaryMovement;
    }

    public void setLiteraryMovement(String literaryMovement) {
        this.literaryMovement = literaryMovement;
    }

    public String getAuthorID() {
        return AuthorID;
    }

    public void setAuthorID(String authorID) {
        AuthorID = authorID;
    }

    @Override
    public String toString() {
        return "Authors{}";
    }
}
