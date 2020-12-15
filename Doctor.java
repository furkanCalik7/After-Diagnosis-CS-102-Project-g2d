public class Doctor extends User{

    String speciality;
    String doctorID;

    public Doctor(String username, String password, String email, String name, String surname, String sex,
    String speciality) {
        super(username, "Doctor", password, email, name, surname, sex);
        this.speciality = speciality;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    @Override
    public String toString() {
        return super.toString() + "Doctor{" +
                "speciality='" + speciality + '\'' +
                '}';
    }
}
