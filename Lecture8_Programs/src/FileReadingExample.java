import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReadingExample {
    public static void main(String[] args) {
        String fileName = null;  // Declared outside try block for use in catch

        try {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter file name:");
            fileName = keyboard.next();

            BufferedReader inputStream = new BufferedReader(new FileReader(fileName));
            String line = inputStream.readLine();

            System.out.println("The first line in " + fileName + " is:");
            System.out.println(line);

            // Additional code for reading more lines can go here

            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found.");
        } catch (IOException e) {
            System.out.println("Error reading from file " + fileName);
        }
    }
}
