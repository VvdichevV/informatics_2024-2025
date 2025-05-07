import java.io.*;
import java.util.Scanner;

public class GroceryList {
    private static void fileWriterTest(String message, String fileName){
        try(FileWriter outStream = new FileWriter(fileName, true)){ 
            outStream.write(message); 
            System.out.println("fileWriterTest method is successful!");
            }
        catch (IOException e){
            System.out.println("oppa: " + e);
        }
    }
}
