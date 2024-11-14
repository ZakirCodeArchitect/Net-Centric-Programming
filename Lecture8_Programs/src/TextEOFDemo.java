import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TextEOFDemo {
    public static void main(String[] args) {
        int count = 0;
        String line;

        try (BufferedReader inputStream = new BufferedReader(new FileReader("input.txt"));
             PrintWriter outputStream = new PrintWriter("output.txt")) {

            line = inputStream.readLine();
            while (line != null) {
                count++;
                outputStream.println(count + " " + line);
                line = inputStream.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("File processed. " + count + " lines read.");
    }
}