package Doctor.Model;

import Admin.model.UserInfoCard;

public class DoctorInfoCard extends UserInfoCard {

    private String doctorSpeciality;

    public DoctorInfoCard(String doctorUsername, String doctorEmail, String doctorName, String doctorSurname,
                          String doctorSex, String doctorSpeciality) {
        super(doctorUsername, doctorEmail, doctorName, doctorSurname, doctorSex);
        this.doctorSpeciality = doctorSpeciality;
    }

    public String getDoctorUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "DoctorInfoCard{" +
                "doctorUsername='" + username + '\'' +
                ", doctorEmail='" + email + '\'' +
                ", doctorName='" + name + '\'' +
                ", doctorSurname='" + surname + '\'' +
                ", doctorSex='" + sex + '\'' +
                ", doctorSpeciality='" + doctorSpeciality + '\'' +
                '}';
    }

}
