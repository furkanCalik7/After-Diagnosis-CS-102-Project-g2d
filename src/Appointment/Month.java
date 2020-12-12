package Appointment;
import java.util.ArrayList;

public class Month {
    ArrayList<Day> days;
    String monthName;

   public Month(String name ){
       monthName = name;
       days = new ArrayList<Day>();
    }

    public void setMonthName( String name ){
        name = this.monthName;
    }

    public void addDay( Day day){
        days.add( day );
    }

    public String toString(){
        String result =  "";
        for( int i = 0; i < days.size(); i++){
            result = result + " Day: " + ( days.get(i).getDayNum() + 1 );
        }
        return result;
    }

    //getters

    public ArrayList<Day> getAllDays(){
       return days;
    }

    public String getMonthName(){
       return monthName;
    }

}
