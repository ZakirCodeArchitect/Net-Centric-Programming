import java.io.*;

public class FileCopyWithBuffer{
    public static void main(String[] args) {
        String inFileStr = "ncp.jpg";
        String outFileStr = "ncp-out.jpg";
        long startTime, elapsedTime;  // for speed benchmarking
        // Check file length
        File fileIn = new File(inFileStr);
        System.out.println("File size is " + fileIn.length() + " bytes");
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFileStr)); BufferedOutputStream out = new 	BufferedOutputStream(new FileOutputStream(outFileStr))) {
            startTime = System.nanoTime();
            int byteRead;
            while ((byteRead = in.read()) != -1) {
                out.write(byteRead);
            }
            elapsedTime = System.nanoTime() - startTime;
            System.out.println("Elapsed Time is " + (elapsedTime / 1000000.0) + " msec");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


