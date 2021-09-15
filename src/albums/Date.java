package albums;

import java.util.Calendar;
import java.util.StringTokenizer;

/*
This class defines the Date abstract data type with year, month, and day.
 */
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int THE_EIGHTYS = 1980;

    public Date(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");
        month = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
    } //take “mm/dd/yyyy” and create a Date object

    public Date() {

    } //create an object with today’s date (see Calendar class)

    public Date today() {
        return new Date();
    }

    public boolean isValid() {

    }

    @Override
    public int compareTo(Date date) {

    }

    @Override
    public boolean equals(Object obj) {

    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}