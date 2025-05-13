import java.io.*;
import java.util.Random;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
public class BinaryFiles {
    public static void main(String[] args) {
        writeEmp("employees.dat");
        
    }
    public static void writeEmp(String path){
        try(DataOutputStream outStream = new DataOutputStream(new FileOutputStream(path))){
            for(int i = 0; i < 5; i++){
                outStream.writeUTF("Name" + i);
                outStream.writeDouble((int)(20+ Math.random() * 45));

            }

        }catch(IOException e){
            System.out.println("oops: " + e);
        }
    }
}
