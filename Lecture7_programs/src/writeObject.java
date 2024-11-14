import java.io.*;
public class writeObject {
    public static void main(String[] args) throws Exception {
        Junk obj1 = new Junk("Object 1");
        Junk obj2 = new Junk("Object 2");
        ObjectOutputStream objectOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("b.txt")));
        objectOut.writeObject(obj1); // Write object
        objectOut.writeObject(obj2); // Write object
        objectOut.writeUTF("testing");
        objectOut.close(); // Close the output stream
        ObjectInputStream objectIn = null;
        int Count = 0;
        Junk object = null;
        objectIn = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream("b.txt")));
        while (Count < 2) {
            object = (Junk) objectIn.readObject(); Count++;
            System.out.println("Object " + Count + ": " + object.toStr());     }
        System.out.println(objectIn.readUTF());
        objectIn.close();
    }
}

class Junk implements Serializable {
    String str;
    public Junk(String s)
    {  str = s;  }
    public String toStr(){
        return str;  }
}
