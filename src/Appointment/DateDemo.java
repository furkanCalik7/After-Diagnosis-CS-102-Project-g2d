package Appointment;

import java.util.ArrayList;

public class DateDemo {
    public static void main(String[] args) {

        /**Day toString shows all the dates in it with the information.
        Day day1 = new Day( 1);
        System.out.println( "All Dates: " + day1.toString( day1.getAllDates() ));
        */

        /**Uncomment this part in order in order to see day.getFreeDates and day.getDate.setFull
         day1.getDate(2).setFull();
         System.out.println( "Free dates: " + day1.toString( day1.getFreeDates()));
         System.out.println( "All Dates: " + day1.toString( day1.getAllDates() ));
         day1.getDate(2).setEmpty();
         System.out.println( "Free dates: " + day1.toString( day1.getFreeDates()));
         System.out.println( "All Dates: " + day1.toString( day1.getAllDates() ));
         */


        Year y2020 = new Year( 2020);
        System.out.println( y2020.toString() );
//        System.out.println(  "Free dates: " +day1.toString( day1.getFreeDates()));

        /**
         * Calendar trial
         */
        Calendar calendar = new Calendar();
        calendar.getAppointment( 18, 1, 1, y2020 );
        System.out.println( y2020.getMonth(1).getDay(1).toString());;
    }
}
