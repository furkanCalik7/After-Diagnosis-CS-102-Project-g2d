package Appointment;
import java.util.ArrayList;

public class Month {
    ArrayList<Day> days;
    String monthName;
    int monthNum;
   public Month(String name, int monthNum ){
       monthName = name;
       this.monthNum = monthNum;
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

    public Day getDay( int num){
       return days.get(num);
    }
}
