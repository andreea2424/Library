package Library;

public class Person {
    protected String lastName;
    protected String firstName;

    public Person(String fistName, String lastName) {
        this.firstName = fistName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
