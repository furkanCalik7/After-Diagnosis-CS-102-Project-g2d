package Appointment;
import java.util.ArrayList;

public class Month {
    ArrayList<Day> days;
    String monthName;

    Month(String name ){
        monthName = name;
    }

    public void setMonthName( String name ){
        name = this.monthName;
    }


}
