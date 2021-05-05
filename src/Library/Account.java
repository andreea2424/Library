package Library;

import java.util.Objects;

public  class Account {
    private String username;
    private String password;
    private String status;
    private String email;
    private String phone;
    private int readerId;

    public Account( String username,String email, String password,String phone,String status,int readerId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status =status;
        this.readerId = readerId;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getReaderId() {
        return readerId;
    }

    public String getAccountInfo(){
        return "Account username: " + username + "\nPassword: " + password + "\nStatus:" + status +"\n";
    }
    @Override
    public String toString() {
        return " Account: " +"\n" +
                "  username='" + username + "\n" +
                ", password='" + password + "\n" +
                ", email='" + email + "\n" +
                ", phone='" + phone +"\n"
                ;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(username, account.username) &&
                Objects.equals(email, account.email) &&
                Objects.equals(phone, account.phone);
    }
    @Override
    public int hashCode() {
        return Objects.hash(username, email, phone);
    }
}
