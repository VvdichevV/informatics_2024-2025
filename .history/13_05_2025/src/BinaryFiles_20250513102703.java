import java.io.*;
import java.util.Random;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.DataInputStream;

public class BinaryFiles {
    public static void main(String[] args) {
        writeEmp("sample.txt");

    }

    public static void writeEmp(String path) {
        try (DataOutputStream outStream = new DataOutputStream(new FileOutputStream(path))) {
            for (int i = 0; i < 5; i++) {
                outStream.writeUTF("Name" + i);
                outStream.writeDouble((int) (20 + Math.random() * 45));

            }

        } catch (IOException e) {
            System.out.println("oops: " + e.getMessage());
        }
    }
    public static void readEmp(String path) {
        try (DataInputStream inStream = new DataInputStream(new FileInputStream(path))) {
            try{
                while(true)
            }
            for (int i = 0; i < 5; i++) {
                String name = inStream.readUTF();
                double salary = inStream.readDouble();
                System.out.println("Name: " + name + ", Salary: " + salary);
            }
        } catch (IOException e) {
            System.out.println("oops: " + e.getMessage());
        }

    }
}
