
public class Date1Demo {
    public static void main(String[] args)
    {
        Date1 myDate;
        myDate = new Date1();

        myDate.month = "July";
        myDate.day = 4;
        myDate.year = 2007;

        myDate.setDate("march",3,2003);

        String  dateString = myDate.toString();
        System.out.println(dateString);


    }
}
