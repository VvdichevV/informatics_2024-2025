import java.io.*;
import java.util.Scanner;

public class GroceryList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName;
        System.out.println("Enter the name of the file: ");
        fileName = sc.nextLine();
        String message = "";

        System.out.println("Enter grocery items (type 'done' to stop):");
        while (true) {
            String item = sc.nextLine();
            if (item.equalsIgnoreCase("done")) {
                break;
            }
            message += item + "\n";
        }

        fileWriterTest(message, fileName);
        sc.close();
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
