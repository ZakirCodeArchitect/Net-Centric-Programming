import java.io.*;

public class BufferedIOStream {
    public static void main(String[] args) throws IOException {

        File file1 = new File("b.txt");
        File file2 = new File("dest.txt");

        try(
            BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file1));
            BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(file2));
        ) {


            byte[] buffer = new byte[1024]; //byte array
            int byteRead;

            while ((byteRead = bin.read(buffer)) != -1) {
                String chunk = new String(buffer, 0, byteRead);
                System.out.println("Data Read from File :" + chunk);
                bout.write(buffer, 0, byteRead);
            }


        }catch (IOException e)
        {
            System.out.println(e);
        }


    }
}
