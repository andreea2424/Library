package Library;

public class Authors extends  Person{
    private String nationality;
    private String dateOfBirth;
    private String dateofDeath;
    private String literaryMovement;
    private int AuthorID;

    public Authors(int  AuthoreID,String lastName, String fistName, String nationality, String dateOfBirth, String dateofDeath, String literaryMovement) {
        super(fistName,lastName);
        this.AuthorID = AuthoreID;
        this.nationality =nationality;
        this.dateOfBirth= dateOfBirth;
        this.dateofDeath=dateofDeath;
        this.literaryMovement=literaryMovement;
    }
    public Authors(String lastName, String fistName, String nationality, String dateOfBirth, String dateofDeath, String literaryMovement) {
        super(fistName,lastName);
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

    public int getAuthorID() {
        return AuthorID;
    }

    public void setAuthorID(int authorID) {
        AuthorID = authorID;
    }

    @Override
    public String toString() {
        return '\n' +
                "Author: " + '\n' +
                "AuthorID=" + AuthorID +'\n' +
                "first name= " + firstName + '\n' +
                "last name= " + lastName + '\n' +
                "first name= " + firstName + '\n' +
                "nationality= " + nationality + '\n' +
                "date of birth= " + dateOfBirth + '\n' +
                "date of death= " + dateofDeath + '\n' +
                "literary movement= " + literaryMovement + '\n'
                ;
    }
}
