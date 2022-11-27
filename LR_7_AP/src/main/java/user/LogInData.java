package user;

public class LogInData {
    private String name;
    private String surname;
    private String email;
    private String password;

    public LogInData() {
    }

    public LogInData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public LogInData(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LogInData{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
