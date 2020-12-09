public class Main {

    public static void main(String[] args) throws Exception {
        MySQLAccess access = new MySQLAccess();
        User u = new User("fguzelant", "password", "fguzelant@hotmailcom", "Furkan", "Güzelant");
        access.readDataBase(u);
    }
}
