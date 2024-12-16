import java.util.*;
import java.io.*;

public class StudentRecordReader {
    private DataInputStream dataInput;

    public StudentRecordReader(String inputFile) throws IOException {
        dataInput = new DataInputStream(new FileInputStream(inputFile));
    }

    public List<Student> readAll() throws IOException {
        List<Student> listStudent = new ArrayList<>();
        try {
            while (true) {
                String name = dataInput.readUTF();
                boolean gender = dataInput.readBoolean();
                int age = dataInput.readInt();
                float grade = dataInput.readFloat();
                Student student = new Student(name, gender, age, grade);
                listStudent.add(student);
            }
        } catch (EOFException e) {
            // End of file reached, expected when reading all records
        } finally {
            dataInput.close(); // Ensure the stream is closed
        }
        return listStudent;
    }

    public static void main(String[] args) {
        try {
            StudentRecordReader reader = new StudentRecordReader("students.txt");
            List<Student> listStudent = reader.readAll();

            for (Student student : listStudent) {
                System.out.print(student.getName() + "\t");
                System.out.print(student.getGender() + "\t");
                System.out.print(student.getAge() + "\t");
                System.out.println(student.getGrade());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
