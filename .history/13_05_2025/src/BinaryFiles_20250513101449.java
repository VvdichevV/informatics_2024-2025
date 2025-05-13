import java.io.*;
import java.util.Random;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
public class BinaryFiles {
    public static void main(String[] args) {
        
    }
    public static void writeEmp(String path){
        try(DataOutputStream outStream = new DataOutputStream(new FileOutputStream(path))){

        }catch(IOException e){
            System.out.println("oops: " + e);
        }
    }
}
