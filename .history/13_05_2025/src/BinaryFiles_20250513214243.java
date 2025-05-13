import java.io.*;
import java.util.Random;

public class BinaryFiles {
    public static void main(String[] args) {
        writeEmp("sample.txt");
        readEmp("sample.txt");

    }

    public static void writeEmp(String path) {
        try (DataOutputStream outStream = new DataOutputStream(new FileOutputStream(path))) {
            String[] namesString = { "Victor, Ahmed, John, Fatima, Dan" };
            for (int i = 0; i < 5; i++) {
                outStream.writeInt(i+1);
                outStream.writeInt(i);
                outStream.writeInt(((int) (Math.random() * (12 - 8)) + 8));
                outStream.writeUTF(String.format("%.2f", ((Math.random() * (6 - 2)) + 2)));
                //outStream.writeUTF("Student ID: " + (i + 1) + ", Name: " + i + ", Grade: "
                        +  + ", GPA: " + String.format("%.2f", ((Math.random() * (6 - 2)) + 2)));
            }

        } catch (IOException e) {
            System.out.println("oops: " + e.getMessage());
        }
    }

    public static void readEmp(String path) {
        try (DataInputStream inStream = new DataInputStream(new FileInputStream(path))) {
            try {
                while (true) {
                    System.out.println(inStream.readUTF());
                }
            } catch (EOFException e) {
                System.out.println("oops " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("oops: " + e.getMessage());
        }

    }
}
