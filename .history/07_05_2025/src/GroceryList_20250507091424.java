import java.io.*;
import java.util.Scanner;

public class GroceryList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fileName;
        System.out.println("Enter the name of the file: ");
        String message = "";

        System.out.println("Enter grocery items (type 'exit' to finish):");
        while (true) {
            String item = input.nextLine();
            if (item.equalsIgnoreCase("exit")) {
                break;
            }
            message += item + "\n";
        }

        fileWriterTest(message, fileName);
    }
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
