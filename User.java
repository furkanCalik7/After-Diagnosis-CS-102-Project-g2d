public abstract class User {

    String username;
    String password;
    String email;
    String name;
    String surname;
    String sex;
    String userType;


    public User(String username, String userType, String password, String email, String name, String surname, String sex) {
        this.username = username;
        this.password = password;
        this.email  = email;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.userType = userType;
    }

    // +isOnline(): boolean
    public void setUserName(String uname) {
        username = uname;
    }

    public void setPassword(String pass) {
        password = pass;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
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
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
