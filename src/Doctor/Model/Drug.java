package Doctor.Model;

import java.sql.Date;

public class Drug {


    // private String doctorUsername;
    private String patientUsername;
    private String name;
    private boolean isMorning;
    private boolean isAfternoon;
    private boolean isEvening;
    private boolean isHungry;
    private Date startDate;
    private Date finalDate;
    private int dose;

    public Drug(String patientUsername, String name, boolean isMorning, boolean isAfternoon,
                boolean isEvening, boolean isHungry, Date startDate, Date finalDate, int dose) {
        this.patientUsername = patientUsername;
        this.name = name;
        this.isMorning = isMorning;
        this.isAfternoon = isAfternoon;
        this.isEvening = isEvening;
        this.isHungry = isHungry;
        this.startDate = startDate;
        this.finalDate = finalDate;
        this.dose = dose;
    }


    public int getDose() {
        return dose;
    }

    public String getName() {
        return name;
    }

    public String getPatientUsername() {
        return patientUsername;
    }

    public boolean isEvening() {
        return isEvening;
    }

    public boolean isAfternoon() {
        return isAfternoon;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public boolean isMorning() {
        return isMorning;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    @Override
    public String toString() {
        return "Drug{" +
                ", patientUsername='" + patientUsername + '\'' +
                ", name='" + name + '\'' +
                ", isMorning=" + isMorning +
                ", isAfternoon=" + isAfternoon +
                ", isEvening=" + isEvening +
                ", isHungry=" + isHungry +
                ", startDate=" + startDate +
                ", finalDate=" + finalDate +
                '}';
    }
}