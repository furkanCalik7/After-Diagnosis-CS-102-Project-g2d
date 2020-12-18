package Doctor.Model;

import Patient.Model.Code;
import Patient.Model.PatientInfoCard;

import java.sql.Date;

public class PatientSlot {
     static final int CURRENT_PATIENT = 1;
     static final int EXPIRED_PATIENT = 0;

    private PatientInfoCard patientInfo;
    private String doctor_username;
    private int status;
    private Code code;
    private Date start_date;

    public PatientSlot(String doctor_username, PatientInfoCard patient_info, int status, Code code, Date start_date) {
        this.patientInfo = patient_info;
        this.doctor_username = doctor_username;
        this.status = status;
        this.code = code;
        this.start_date = start_date;
    }
}
