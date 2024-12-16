import java.io.*;
public class RandomAccess {
    public static void main(String args[]) throws IOException
    {
        RandomAccessFile myfile = new RandomAccessFile("rand.dat", "rw");

        // Writing to the file
        myfile.writeInt(120);   // 4
        myfile.writeDouble(375.50); // 4+8
        myfile.writeInt('A' + 1); // 4+8+4
        myfile.writeBoolean(true); // 4+8+4+1
        myfile.writeChar('X'); // 4+8+4+1+2

        // Set pointer to the beginning of the file and read the next two items
        myfile.seek(0);
        System.out.println(myfile.readInt());
        System.out.println(myfile.readDouble());

        // Set pointer to the 4th item and read it
        myfile.seek(16);
        System.out.println(myfile.readBoolean());

        // Go to the end and “append”
        myfile.seek(myfile.length());  // going to the end of the file
        myfile.writeInt(2003);

        // Read 5th and 6th items
        myfile.seek(17);
        System.out.println(myfile.readChar());
        System.out.println(myfile.readInt());

        // Print file length
        System.out.println("File length: " + myfile.length());

        // Close the file
        myfile.close();
    }
}
