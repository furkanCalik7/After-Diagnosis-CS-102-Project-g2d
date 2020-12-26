package Doctor.Model;

import Patient.Model.Code;
import Patient.Model.PatientInfoCard;

import java.sql.Date;

public class PatientSlot {
    public static final int CURRENT_PATIENT = 1;
    public static final int EXPIRED_PATIENT = 0;

    private PatientInfoCard patientInfo;
    private String doctor_username;
    private int status;
    private String code_id;
    private Date start_date;

    public PatientSlot(String doctor_username, PatientInfoCard patient_info, int status, String code_id, Date start_date) {
        this.patientInfo = patient_info;
        this.doctor_username = doctor_username;
        this.status = status;
        this.code_id = code_id;
        this.start_date = start_date;
    }

    public PatientInfoCard getPatientInfo() {
        return patientInfo;
    }

    public String getDoctor_username() {
        return doctor_username;
    }

    public int getStatus() {
        return status;
    }

    public String getCode_id() {
        return code_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    @Override
    public String toString() {
        return "PatientSlot{" +
                "patientInfo=" + patientInfo +
                ", doctor_username='" + doctor_username + '\'' +
                ", status=" + status +
                ", code_id='" + code_id + '\'' +
                ", start_date=" + start_date +
                '}';
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
