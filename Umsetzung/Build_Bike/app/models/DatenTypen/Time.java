package models.DatenTypen;

import java.util.Calendar;

/**
 * Created by dima on 19.06.15.
 */
public enum Time {

    MILL(1.0/1000.0),
    SEC(1.0),
    MIN(60.0),
    HOUR(60.0*60.0);


    private double value;

    private Time(double v){
        this.value = v;
    }

    public double toSec(double v){
        System.out.println("Value: "+ this.value);
        System.out.println("Input: "+v);
        return this.value * v;
    }

    public double toMin(double v){
        return toSec(v) / 60;
    }

    public double toHour(double v){
        return toMin(v) / 60;
    }

    public static String getTimeStamp(){

        Calendar cal    = Calendar.getInstance();
        String Hour     = Integer.toString(cal.get(Calendar.HOUR));
        String Minutes  = Integer.toString(cal.get(Calendar.MINUTE));
        String Seconds  = Integer.toString(cal.get(Calendar.SECOND));
        String Day      = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String Month    = Integer.toString(cal.get(Calendar.MONTH)+1);
        String Year     = Integer.toString(cal.get(Calendar.YEAR));

        return Day+Month+Year+Hour+Minutes+Seconds;
    }

    public static String getDate(){

        Calendar cal    = Calendar.getInstance();
        String Day      = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        String Month    = Integer.toString(cal.get(Calendar.MONTH)+1);
        String Year     = Integer.toString(cal.get(Calendar.YEAR));

        return Day+"."+Month+"."+Year;
    }

    public static String getTime(){
        Calendar cal    = Calendar.getInstance();
        int Hour     = cal.get(Calendar.HOUR);
        int Minutes  = cal.get(Calendar.MINUTE);
        int Seconds  = cal.get(Calendar.SECOND);

        return timeDefaultConvention(Hour,Minutes,Seconds);
    }

    private static String timeDefaultConvention(int hour, int min, int sec){
        String h = hour+"";
        String m = min+"";
        String s = sec+"";

        if(hour < 10) h = "0"+hour;
        if(min < 10) m = "0"+min;
        if(sec < 10) s = "0"+sec;

        return h+":"+m+":"+s;
    }
}
