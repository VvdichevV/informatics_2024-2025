import java.io.*;
import java.util.Random;

public class BinaryFiles {
    public static void main(String[] args) {
        writeEmp("sample.txt");
        readEmp("sample.txt");

    }

    public static void writeEmp(String path) {
        try (DataOutputStream outStream = new DataOutputStream(new FileOutputStream(path))) {
            String[] namesString = {"Victor, Ahmed, John, Fatima, Dan"};
            for (int i = 1; i <= 5; i++) {
                outStream.writeUTF("Student ID: " + i + ", Name: " + namesString[i-1] + ", Grade: " + ("" + Math.random() * (12 - 8 + 8) + 8));
                outStream.writeUTF("" + Math.random() * (4.0 - 1 + 1) + 1);

            }

        } catch (IOException e) {
            System.out.println("oops: " + e.getMessage());
        }
    }

    public static void readEmp(String path) {
        try (DataInputStream inStream = new DataInputStream(new FileInputStream(path))) {
            try {
                while (true) {
                    System.out.println(inStream.readUTF() + " " + inStream.readDouble());
                }
            } catch (EOFException e) {
                System.out.println(e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("oops: " + e.getMessage());
        }

    }
}
