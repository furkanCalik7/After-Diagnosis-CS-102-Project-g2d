package Appointment;
import java.util.ArrayList;

public class Date {

    private int dateNum;
    private String interval;
    private boolean isFull;

    /**
     * Constructs a single date with the specified num.
     * @param num
     */
    public Date( int num, String interval ){
        dateNum = num;
        this.interval = interval;
        isFull = false;
    }

    //getters
    public int getDateNum(){
        return this.dateNum;
    }

    public boolean isFull(){
        return this.isFull;
    }

    public String getInterval(){
        return this.interval;
    }

    // Setters

    public void setFull(){
        this.isFull = true;
        System.out.println( "Date " + this.interval + " is set full");
    }

    public void setEmpty(){
        this.isFull = false;
        System.out.println( "Date " + this.interval + " is set empty");

    }

    public void setDateNum( int num){
        this.dateNum = num;
    }

    public void setInterval( String str ){
        this.interval = str;
    }
}
