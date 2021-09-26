package albums;

import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * A class that defines a Date object by year, month, and day.
 * The Date class also has methods to check if a Date is valid, to compare
 * Date objects, and to generate a String representation of a Date object.
 * There are also getter methods defined for the day, month, and year
 * attributes.
 *
 * @author Akshar Patel, Mervin James
 */
public class Date implements Comparable<Date> {
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int THE_EIGHTYS = 1980;
    private final int year;
    private final int month;
    private final int day;

    /**
     * Constructor for the Date class which takes in a date of type String.
     * This constructor uses a StringTokenizer to break the date into tokens,
     * and then parses each token into an Integer.
     *
     * @param date the String representation of the date of an album
     */
    public Date(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");
        month = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
    } //take “mm/dd/yyyy” and create a Date object

    /**
     * Copy constructor for the Date class which takes in a Date object.
     * This constructor is used to generate a new instance of a Date object
     * with the same attributes.
     *
     * @param date the Date object representation of the date of an album
     */
    public Date(Date date) {
        this.month = date.month;
        this.day = date.day;
        this.year = date.year;
    }

    /**
     * Default constructor for the Date class.
     * This constructor generates a Date object with today's month, day, and
     * year.
     */
    public Date() {
        Calendar calendar = Calendar.getInstance();
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DATE);
        year = calendar.get(Calendar.YEAR);
    } //create an object with today’s date (see Calendar class)

    public static void main(String[] args) {
        boolean expectedResult = false;

        //test case #1, a date with the year before 1980 should be invalid.
        Date date = new Date("12/31/1979");
        boolean result = date.isValid();
        System.out.print("Test case #1: ");
        if (result == expectedResult) {
            System.out.println("Pass.");
        } else {
            System.out.println("Fail.");
        }

        //test case #2, a date with an invalid month.
        date = new Date("13/21/1999");
        result = date.isValid();
        System.out.print("Test case #2: ");
        if (result == expectedResult) {
            System.out.println("Pass.");
        } else {
            System.out.println("Fail.");
        }

        //test case #3, a date with an invalid day in January.
        date = new Date("1/32/2019");
        result = date.isValid();
        System.out.print("Test case #3: ");
        if (result == expectedResult) {
            System.out.println("Pass.");
        } else {
            System.out.println("Fail.");
        }

        //test case #4, a date with an invalid day in February in a
        //non-leap year.
        date = new Date("2/29/2019");
        result = date.isValid();
        System.out.print("Test case #4: ");
        if (result == expectedResult) {
            System.out.println("Pass.");
        } else {
            System.out.println("Fail.");
        }

        //test case #5, a date with an invalid day in March.
        date = new Date("3/32/2019");
        result = date.isValid();
        System.out.print("Test case #5: ");
        if (result == expectedResult) {
            System.out.println("Pass.");
        } else {
            System.out.println("Fail.");
        }

        //test case #6, a date with an invalid day in April.
        date = new Date("4/31/2019");
        result = date.isValid();
        System.out.print("Test case #6: ");
        if (result == expectedResult) {
            System.out.println("Pass.");
        } else {
            System.out.println("Fail.");
        }

        //test case #7, a date with an invalid day in May.
        date = new Date("5/32/2019");
        result = date.isValid();
        System.out.print("Test case #7: ");
        if (result == expectedResult) {
            System.out.println("Pass.");
        } else {
            System.out.println("Fail.");
        }

        //test case #8, a date with an invalid day in June.
        date = new Date("6/31/2019");
        result = date.isValid();
        System.out.print("Test case #8: ");
        if (result == expectedResult) {
            System.out.println("Pass.");
        } else {
            System.out.println("Fail.");
        }

        //test case #9, a date with an invalid day in July.
        date = new Date("7/32/2019");
        result = date.isValid();
        System.out.print("Test case #9: ");
        if (result == expectedResult) {
            System.out.println("Pass.");
        } else {
            System.out.println("Fail.");
        }

        //test case #10, a date with an invalid day in August.
        date = new Date("8/32/2019");
        result = date.isValid();
        System.out.print("Test case #10: ");
        if (result == expectedResult) {
            System.out.println("Pass.");
        } else {
            System.out.println("Fail.");
        }

        //test case #11, a date with an invalid day in September.
        date = new Date("9/31/2019");
        result = date.isValid();
        System.out.print("Test case #11: ");
        if (result == expectedResult) {
            System.out.println("Pass.");
        } else {
            System.out.println("Fail.");
        }

        //test case #12, a date with an invalid day in October.
        date = new Date("10/32/2019");
        result = date.isValid();
        System.out.print("Test case #12: ");
        if (result == expectedResult) {
            System.out.println("Pass.");
        } else {
            System.out.println("Fail.");
        }

        //test case #13, a date with an invalid day in November.
        date = new Date("11/31/2019");
        result = date.isValid();
        System.out.print("Test case #13: ");
        if (result == expectedResult) {
            System.out.println("Pass.");
        } else {
            System.out.println("Fail.");
        }

        //test case #14, a date with an invalid day in December.
        date = new Date("12/32/2019");
        result = date.isValid();
        System.out.print("Test case #14: ");
        if (result == expectedResult) {
            System.out.println("Pass.");
        } else {
            System.out.println("Fail.");
        }

        //test case #15, a date after the present date.
        date = new Date("12/1/2021");
        result = date.isValid();
        System.out.print("Test case #15: ");
        if (result == expectedResult) {
            System.out.println("Pass.");
        } else {
            System.out.println("Fail.");
        }

        //test case #16, a date with a negative value for day.
        date = new Date("11/-1/2019");
        result = date.isValid();
        System.out.print("Test case #16: ");
        if (result == expectedResult) {
            System.out.println("Pass.");
        } else {
            System.out.println("Fail.");
        }


    }

    /**
     * Generates a Date object with today's date information.
     *
     * @return an instance of a Date object with today's month, day, and year
     * as attributes.
     */
    public Date today() {
        return new Date();
    }

    /**
     * Determines if this Date object has valid attributes.
     *
     * @return true if this Date object has a valid date between 1980 and the
     * present, false otherwise.
     */
    public boolean isValid() {
        if (this.year < THE_EIGHTYS) {
            return false;
        }
        if (this.compareTo(today()) == 1) {
            return false;
        }
        if (this.month < 1 || this.day < 1 || this.year < 1) {
            return false;
        }
        if (this.month == 1 || this.month == 3 || this.month == 5 ||
                this.month == 7 || this.month == 8 || this.month == 10 ||
                this.month == 12) {
            return this.day <= 31;
        } else if (this.month == 4 || this.month == 6 || this.month == 9 ||
                this.month == 11) {
            return this.day <= 30;
        } else if (this.month == 2) {
            if (this.year % QUADRENNIAL == 0) {
                if (this.year % CENTENNIAL == 0) {
                    if (this.year % QUATERCENTENNIAL == 0) {
                        return this.day <= 29;
                    }
                } else {
                    return this.day <= 29;
                }
            } else {
                return this.day <= 28;
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * Compares this Date and another Date to determine Date order.
     *
     * @param date the Date object that this Date object is compared to.
     * @return -1 if this Date precedes the Date being compared to, 1 if this
     * Date postdates the Date being compared to, and 0 if both dates have
     * the equivalent attributes.
     */
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
            } else if (this.month < date.month) {
                return -1;
            }
        }
        return 1;
    }

    /**
     * Determines if this Date and another object have equivalent attributes.
     *
     * @param obj the object that this Date object is being compared to.
     * @return true if both objects are Date objects with the same
     * attributes, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Date) {
            Date date = (Date) obj;
            return (date.month == this.month && date.day == this.day &&
                    date.year == this.year);
        }
        return false;
    }

    /**
     * Generates a String representation of this Date object.
     *
     * @return the String representation of this Date object.
     */
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    /**
     * Getter method for the day property of this Date object.
     *
     * @return the month property of this Date object as an int.
     */
    public int getDay() {
        return day;
    }

    /**
     * Getter method for the month property of this Date object.
     *
     * @return the month property of this Date object as an int.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Getter method for the year property of this Date object.
     *
     * @return the year property of this Date object as an int.
     */
    public int getYear() {
        return year;
    }
}