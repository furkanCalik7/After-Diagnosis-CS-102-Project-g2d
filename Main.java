import java.sql.Date;
import java.sql.Time;

public class Main {

    public static void main(String[] args) throws Exception {
        Admin a = new Admin("Admin", "adminpassword", "asd@asd.com", "Ahmet", "Yılmaz", "M");
        MySQLAccess access = new MySQLAccess();
        Patient p = new Patient("FurkanGüzelant", "12345",
                "dff@asd.com", "Furkan", "Güzelant", "M");
        System.out.println(p.getDrugs());
    }
}
