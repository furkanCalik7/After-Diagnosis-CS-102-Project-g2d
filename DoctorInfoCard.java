public class DoctorInfoCard {

    private String doctorUsername;
    private String doctorEmail;
    private String doctorName;
    private String doctorSurname;
    private String doctorSex;
    private String doctorSpeciality;

    public DoctorInfoCard(String doctorUsername, String doctorEmail, String doctorName, String doctorSurname,
                          String doctorSex, String doctorSpeciality) {
        this.doctorUsername = doctorUsername;
        this.doctorEmail = doctorEmail;
        this.doctorName = doctorName;
        this.doctorSurname = doctorSurname;
        this.doctorSex = doctorSex;
        this.doctorSpeciality = doctorSpeciality;
    }

    @Override
    public String toString() {
        return "DoctorInfoCard{" +
                "doctorUsername='" + doctorUsername + '\'' +
                ", doctorEmail='" + doctorEmail + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", doctorSurname='" + doctorSurname + '\'' +
                ", doctorSex='" + doctorSex + '\'' +
                ", doctorSpeciality='" + doctorSpeciality + '\'' +
                '}';
    }
}
