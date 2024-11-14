import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingInts {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("in.txt"));

        int number;

        while (inFile.hasNextInt()) {
            number = inFile.nextInt();

            // ... process the integer ...
        }

        inFile.close();
    }
}