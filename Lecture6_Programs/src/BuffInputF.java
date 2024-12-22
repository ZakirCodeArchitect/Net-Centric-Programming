import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class BuffInputF {
    public static void main(String[] args) throws Exception {
        byte[] buffer = new byte[1024];
        String file1 = "b.txt";
        File filein = new File(file1);
        FileInputStream fi = new FileInputStream(filein);
        BufferedInputStream bi = new BufferedInputStream(fi);
        int bytesRead = 0;

        while ((bytesRead = bi.read(buffer)) != -1)
        {
            String chunk = new String(buffer,0,bytesRead);
            System.out.print(chunk);
        }
        bi.close();
    }
}
