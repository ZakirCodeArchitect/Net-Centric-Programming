import java.io.*;

public class byteArrayIOStream {
    public static void main(String[] args)
    {
        File file1 = new File("b.txt");
        File file2 = new File("c.txt");

        try
        {
            FileInputStream fin = new FileInputStream(file1);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int byteRead;

            while((byteRead = fin.read(buffer)) != -1 )
            {
                bout.write(buffer,0,byteRead);
            }
            fin.close();

            ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
            FileOutputStream fout = new FileOutputStream(file2);

            while ((byteRead = bin.read(buffer)) != -1)
            {
                fout.write(buffer,0,byteRead);
            }

            fout.close();
            bin.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
