package JDBC;

public class UserInfoCard {

    protected String username;
    protected String email;
    protected String name;
    protected String surname;
    protected String sex;

    public UserInfoCard(String username, String email, String name, String surname, String sex) {
        this.username = username;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "UserInfoCard{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
