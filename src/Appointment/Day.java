package Appointment;

import java.util.ArrayList;

public class Day {

    String dayName;
    int dayNum;
    private ArrayList<Date> allDates;
    private ArrayList<Date> freeDates;

    public Day( int num ){
        dayNum = num;
        allDates = new ArrayList<Date>();
        freeDates = allDates;
        createADay();
    }

    public void createADay(){
        initializeDates();
        createDates();
    }

    /**
     * Creates the dates for the arraylist.
     */
    public void initializeDates(){
        for(int i = 0; i < 19; i++){
            allDates.add( new Date(i, "" ) );
        }
    }

    /**
     * Creates all dates and names them.
     */
    public  void createDates() {
        for(int i = 8, j = 0; j < allDates.size(); i++, j += 2){
            allDates.set(j, new Date(j ,(i + ":00") ) );
        }
        for(int i = 8, j = 1; j < allDates.size(); i++, j += 2){
            allDates.set(j, new Date(j ,(i + ":30") ) );
        }
    }

    public String toString( ArrayList<Date> d ){
        String str = "";
        String isFull = "";
        for( int i = 0; i < d.size(); i++){
            if( d.get(i).isFull() ){
                isFull = "Full";
            }
            else {
                isFull = "Empty";
            }
            str = str  + d.get(i).getInterval() + " " + isFull + " - ";

        }
        return str;
    }

    /**
     * Updates freedates by checking every element.
     */
    public void updateFreeDates(){
        Date fullDate;
        freeDates = new ArrayList<Date>();
        for(int i = 0; i < allDates.size(); i++){
            if( !allDates.get(i).isFull() ){
                freeDates.add( allDates.get(i) );
            }
        }
    }

    //getters
    public ArrayList<Date> getFreeDates(){
        updateFreeDates();
        return freeDates;
    }

    public ArrayList<Date> getAllDates(){
        return allDates;
    }

    public Date getDate(int dateNum){
        return allDates.get( dateNum );
    }

}
