import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingLines {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inFile = new Scanner(new File("in.txt"));

        String line;

        while (inFile.hasNextLine()) {
            line = inFile.nextLine();

            // ... process the line of text ...
        }

        inFile.close();
    }
}