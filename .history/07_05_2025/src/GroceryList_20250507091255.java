import java.io.*;

public class GroceryList {
    private static void fileWriterTest(String message, String fileName){
        try(FileWriter outStream = new FileWriter(fileName, true)){ // Create stream & open file
            outStream.write(message); // pass the message into the write method.
            System.out.println("fileWriterTest method is successful!");
            }
        catch (IOException e){
            System.out.println("oppa: " + e);
        }
    }
}
