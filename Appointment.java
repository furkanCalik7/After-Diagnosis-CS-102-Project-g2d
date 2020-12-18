import java.sql.Time;
import java.sql.Date;

public class Appointment {
    final int NOT_APPROVED = 0;
    final int APPROVED =  1;

    private String doctorUsername;
    private String patientUsername;
    private Date date;
    private Time start_time;
    private Time end_time;

    public Appointment(String doctorUsername, String patientUsername, Date date, Time start_time, Time end_time) {
        this.doctorUsername = doctorUsername;
        this.patientUsername = patientUsername;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                ", doctorUsername='" + doctorUsername + '\'' +
                ", patientUsername='" + patientUsername + '\'' +
                ", date=" + date +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                '}';
    }
}