package Doctor.Model;

import Admin.model.UserInfoCard;

public class DoctorInfoCard extends UserInfoCard {

    private String doctorSpeciality;

    public DoctorInfoCard(int user_id, String doctorUsername, String doctorEmail, String doctorName, String doctorSurname,
                          String doctorSex, String doctorSpeciality) {
        super(user_id, "Doctor", doctorUsername,  doctorEmail, doctorName, doctorSurname, doctorSex);
        this.doctorSpeciality = doctorSpeciality;
    }

    public String getDoctorUsername() {
        return username;
    }

    public String getDoctorSpeciality() {
        return doctorSpeciality;
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
