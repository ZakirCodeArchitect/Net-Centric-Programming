import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class WriteCharactersToFiles {
    // main itself is a thread created by Java Virtual Machine.
    public static void main(String[] args) {
        try {
            File fileA = new File("file1.txt");
            // Create FileOutputStream objects for file1 and file2
            FileOutputStream file1 = new FileOutputStream(fileA);
            FileOutputStream file2 = new FileOutputStream("file2.txt");

            // Write characters with decimal values 1 to 100 to file1
            for (int i = 1; i <= 100; i++) {
                file1.write(i);
            }

            // Write characters with decimal values 101 to 200 to file2
            for (int i = 1; i <= 100; i++) {
                file2.write(i);
            }

            // Close the file streams
            file1.close();
            file2.close();

            System.out.println("Characters written to file1.txt and file2.txt successfully.");


            /*
            Qno.1 Why should write operations on File 2 wait until File 1 Write operations completes?
                - Because of sequential logic.
                - natural structure of the program, like in a single-threaded program.
            Qno.2 Can write to two files happen simultaneously?
                - by leveraging multi-threading or asynchronous I/O.
             */
        } catch (IOException e) {
            // Handle any IO exceptions
            System.err.println("An error occurred while writing to the files: " + e.getMessage());
        }
    }
}
