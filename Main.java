import java.sql.Date;
import java.sql.Time;

public class Main {

    public static void main(String[] args) throws Exception {
        LoginModel lm = new LoginModel();
        System.out.println(lm.isLogin("NewUser", "mypassword", "Patient"));

    }
}
