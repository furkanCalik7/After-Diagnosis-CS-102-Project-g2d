import java.util.ArrayList;

public class Admin extends User {

    public Admin(String username, String password, String email, String name, String surname, String sex) {
        super(username, "Admin", password, email, name, surname, sex);
    }

    public boolean addDoctor(String name, String surname, String email, String sex, String speciality) {
        //generate code
        String password = "123";
        Doctor d = new Doctor(name + surname, password, email, name, surname, sex, speciality);
        MySQLAccess access = new MySQLAccess();
        try {
            access.readDataBase(d);
            return true;
        } catch (Exception e) {
            System.out.print(e);
        }
        return false;
    }

    /*public boolean addLabTech(String name, String surname, String email) {
        //generate code
        String password = "";
        LabTechician l = new LabTechnician(name + surname, password, email, name, surname);
        MySQLAccess access = new MySQLAccess();
        try {
            access.readDataBase(l);
            return true;
        } catch (Exception e) {
            System.out.print(e);
        }
        return false;
    }*/

    public ArrayList<User> searchWorker(String name) {
        MySQLAccess access = new MySQLAccess();
        return access.findWorkerByName(name);
    }




}
