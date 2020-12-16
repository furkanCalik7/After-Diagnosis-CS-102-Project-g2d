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

    public Drug(String patientUsername, String name, boolean isMorning, boolean isAfternoon,
                boolean isEvening, boolean isHungry, Date startDate, Date finalDate) {
        this.patientUsername = patientUsername;
        this.name = name;
        this.isMorning = isMorning;
        this.isAfternoon = isAfternoon;
        this.isEvening = isEvening;
        this.isHungry = isHungry;
        this.startDate = startDate;
        this.finalDate = finalDate;
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
