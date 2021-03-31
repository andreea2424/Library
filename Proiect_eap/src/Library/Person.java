package Library;

import java.util.Objects;

public class Person {
    protected String lastName;
    protected String firstName;

    public Person() {
    }

    public Person(String fistName, String lastName) {
        this.firstName = fistName;
        this.lastName =lastName;
    }


    public  String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
