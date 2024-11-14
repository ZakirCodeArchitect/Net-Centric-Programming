public class Date2 {

    public String month;
    public int day;
    public int year;

    public boolean setDate(String newMonth, int newDay, int newYear)
    {
        month = newMonth;
        day = newDay;
        year = newYear;
        return true;
    }

    public boolean setDate( int newDay, int newYear)
    {
        day = newDay;
        year = newYear;
        return true;
    }

    public String toString() {
        return month + " " + day + ", " + year;
    }

}
