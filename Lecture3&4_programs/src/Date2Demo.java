
public class Date2Demo {
    public static void main(String[] args)
    {
        Date2 myDate;
        myDate = new Date2();

        myDate.setDate("march",11,2003);
        String date1 = myDate.toString();
        System.out.println(date1);

        myDate.setDate(12,2003);
        System.out.println(myDate.toString());

    }
}
