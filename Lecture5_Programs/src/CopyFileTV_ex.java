import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileTV_ex {
    public static void main(String[] args) {
        FileInputStream fin = null;
        FileOutputStream fout = null;

        try {
            // Initialize input and output streams
            fin = new FileInputStream("a1.txt");
            fout = new FileOutputStream("xyz.txt");

            // Use a buffer to copy the file
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fin.read(buffer)) > 0) {
                fout.write(buffer, 0, bytesRead);
                System.out.println("bytesRead : " + bytesRead);
            }

            // Check the file size and perform additional read/write
//            int size = fin.available();
//            byte[] b = new byte[size];
//            fin.read(b, 0, size);
//            fout.write(b, 0, size);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close resources in the finally block to ensure they are closed even if an exception occurs
            try {
                if (fin != null) fin.close();
                if (fout != null) fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
