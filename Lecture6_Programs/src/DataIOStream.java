import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataIOStream {
    public static void main(String[] args) throws Exception{
        int idA = 1234;
        String nameA ="Data  I/O Stream";
        FileOutputStream fos = new FileOutputStream("cities.txt");
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeInt(idA);
        dos.writeUTF(nameA);
        dos.close();

        FileInputStream fis = new FileInputStream("cities.txt");
        DataInputStream dis = new DataInputStream(fis);

        int Id = dis.readInt();
        System.out.println("Id: " + Id);
        String Name = dis.readUTF();
        System.out.println("Name: " + Name);
    }
}
