package lv.javaguru.java2.domain;

/**
 * Created by XidenT on 06/09/2015.
 */
public class User {

    private long userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String phoneNr;
    private String email;
    private String bankAccNr;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankAccNr() {
        return bankAccNr;
    }

    public void setBankAccNr(String bankAccNr) {
        this.bankAccNr = bankAccNr;
    }
}
