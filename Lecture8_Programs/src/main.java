import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class main{
    public static void main(String[] args)
    {
        PrintWriter outputStream = null;
        try
        {
            outputStream = new PrintWriter(new FileOutputStream("out.txt"));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening the file out.txt. "
                    + e.getMessage());
            System.exit(0);
        }

        System.out.println("Enter three lines of text:");
        String line = null;
        int count;
        Scanner keyboard = new Scanner(System.in);
        for (count = 1; count <= 3; count++)
        {
            line = keyboard.nextLine();
            outputStream.println(count + " " + line);
        }
        outputStream.close();
        System.out.println("... written to out.txt.");
    }

}




