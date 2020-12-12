package Appointment;

import java.util.ArrayList;

public class Calendar {
    ArrayList<Year> years;

    /**
     * Creates a calendar with many years. (For now only 2020 is added.)
     */
    public Calendar(){
        years = new ArrayList<Year>();
        years.add( new Year(2020) );
    }

    /**
     * Sets the given interval as full
     * @param dateNum
     * @param dayNum
     * @param monthNum
     * @param year
     */
    public void getAppointment( int dateNum, int dayNum, int monthNum, Year year){
        year.getMonth( monthNum).getDay( dayNum).getDate( dateNum ).setFull();
    }

}
