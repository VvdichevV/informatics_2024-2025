import java.io.*;
import java.util.Random;

public class BinaryFiles {
    public static void main(String[] args) {
        writeEmp("sample.txt");
        readEmp("sample.txt");

    }

    public static void writeEmp(String path) {
        try (DataOutputStream outStream = new DataOutputStream(new FileOutputStream(path))) {
            Strin[] namesString = "Ali, Ahmed, Aisha, Fatima, Zainab"};
            for (int i = 1; i <= 5; i++) {
                outStream.writeUTF("Name :" + i);
                outStream.writeDouble((int) (20 + Math.random() * 45));

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
