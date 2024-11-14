import java.io.*;
public class EOF { public static void main (String arg[]){
    try
    {ObjectOutputStream outputStream = new ObjectOutputStream (new FileOutputStream ("numbers.txt"));
        outputStream.writeInt(2); outputStream.writeInt(3); outputStream.close();
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream ("numbers.txt"));
        int n;
        System.out.println("Reading ALL the integers");
        System.out.println("in the file numbers.txt.");
        try{
            while (true){
                n = inputStream.readInt();
                System.out.println(n);
            }
        }
        catch(EOFException e)
        {
            System.out.println("End of reading from file.");
        }
        inputStream.close();
    }
    catch(FileNotFoundException e)
    {
        System.out.println("Cannot find file numbers.txt.");
    }
    catch(IOException e)
    {
        System.out.println("Problem with input from file numbers.txt.");
    }}}

