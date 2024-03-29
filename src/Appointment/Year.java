package Appointment;

import java.util.ArrayList;

public class Year {
    ArrayList<Month> allMonths;
    int yearNo;

    /**
     * Creates a year
     * @param yearNo number of the year. ie: y2020
     */
    public Year( int yearNo){
        this.yearNo = yearNo;
        allMonths = new ArrayList<Month>();
        createMonths();
    }

    /**
     * Creates all months in a year and fills them with days.
     */
    public void createMonths(){
        //Add all the months to the year.
        allMonths.add( new Month( "January", 0));
        allMonths.add( new Month( "February", 1));
        allMonths.add( new Month( "March", 2));
        allMonths.add( new Month( "April", 3));
        allMonths.add( new Month( "May", 4));
        allMonths.add( new Month( "June", 5));
        allMonths.add( new Month( "July", 6));
        allMonths.add( new Month( "August", 7));
        allMonths.add( new Month( "September", 8));
        allMonths.add( new Month( "October", 9));
        allMonths.add( new Month( "November", 10));
        allMonths.add( new Month( "December", 11));

        //Fills all the months accordingly
        monthFill( allMonths.get(0), 31);
        monthFill( allMonths.get(1), 28);
        monthFill( allMonths.get(2), 31);
        monthFill( allMonths.get(3), 30);
        monthFill( allMonths.get(4), 31);
        monthFill( allMonths.get(5), 30);
        monthFill( allMonths.get(6), 31);
        monthFill( allMonths.get(7), 31);
        monthFill( allMonths.get(8), 30);
        monthFill( allMonths.get(9), 31);
        monthFill( allMonths.get(10), 30);
        monthFill( allMonths.get(11), 31);
    }

    /**
     * Fills a given month.
     * @param month Month that will be filled
     * @param monthLength Length of the month
     */
    private void monthFill( Month month, int monthLength ){
        for( int i = 0; i < monthLength; i++){
            month.addDay( new Day( i ));
        }
    }


    public String toString(){
        String result = "";
        for( int i = 0; i < allMonths.size(); i++){
           result += "Month: " + ( i+1) + allMonths.get(i).toString() + "\n";
        }
        return result;
    }

    //Getters
    public ArrayList<Month> getAllMonths(){
        return allMonths;
    }

    public Month getMonth( int num){
        return allMonths.get(num);
    }
}
