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
        Calendar calendar = Calendar.getInstance();
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DATE);
        year = calendar.get(Calendar.YEAR);
    } //create an object with today’s date (see Calendar class)

    public Date today() {
        return new Date();
    }

    public boolean isValid() {
        if (this.year < THE_EIGHTYS) {

        }
        if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 5 || this.month == 6 || this.month == 10 ||this.month == 12) {
            if (this.day > 31) {
                return false;
            }
        }
        else if (this.month == 4 || this.month == 5 || this.month == 9 || this.month == 11) {
            if (this.day > 30) {
                return false;
            }
        }
        else {
            if (this.year % QUADRENNIAL == 0) {
                if (this.year % CENTENNIAL == 0) {
                    if (this.year % QUATERCENTENNIAL == 0) {
                        if (this.day > 29) {
                            return false;
                        }
                    }
                }
                else {
                    if (this.day > 29) {
                        return false;
                    }
                }
            }
            else {
                if (this.day > 28) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int compareTo(Date date) {
        if (this.equals(date)) {
            return 0;
        }
        if (this.year < date.year) {
            return -1;
        }
        if (this.year == date.year) {
            if (this.month == date.month) {
                if (this.day < date.day) {
                    return -1;
                }
            }
            else if (this.month < date.month) {
                return -1;
            }
        }
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Date) {
            Date date = (Date) obj;
            return (date.month == this.month && date.day == this.day && date.year == this.year);
        }
        return false;
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