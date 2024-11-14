public class Date1 {

    public String month;
    public int day;
    public int year;

    public void setDate(String Month, int Day, int Year)
    {
        month = Month;
        day = Day;
        year = Year;
    }

    public String toString()
    {
        return month + " " + day + ", " + year;
    }


}
