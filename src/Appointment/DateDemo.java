import java.util.ArrayList;

public class DateDemo {
    public static void main(String[] args) {

        Day day1 = new Day( 1);
        System.out.println( "All Dates: " + day1.toString( day1.getAllDates() ));
        day1.getDate(2).setFull();
//        System.out.println( "Free dates: " + day1.toString( day1.getFreeDates()));
        System.out.println( "All Dates: " + day1.toString( day1.getAllDates() ));

//        for( int i = 0; i < day1.getFreeDates().size(); i++){
//            System.out.println( day1.getFreeDates().get(i).getDateNum() );
//        }
        day1.getDate(2).setEmpty();
        System.out.println( "All Dates: " + day1.toString( day1.getAllDates() ));

        day1.getDate(2).setFull();
        day1.getDate(5).setFull();
        day1.getDate(8).setFull();
        day1.getDate(10).setFull();
        System.out.println( "All Dates: " + day1.toString( day1.getFreeDates()));

//        System.out.println(  "Free dates: " +day1.toString( day1.getFreeDates()));

    }
}
