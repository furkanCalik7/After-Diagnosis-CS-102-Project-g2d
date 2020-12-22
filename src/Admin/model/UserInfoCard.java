package Admin.model;

public class UserInfoCard {
    protected int user_id;
    protected String username;
    protected String email;
    protected String name;
    protected String surname;
    protected String sex;

    public UserInfoCard(int user_id,String username, String email, String name, String surname, String sex) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSex() {
        return sex;
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