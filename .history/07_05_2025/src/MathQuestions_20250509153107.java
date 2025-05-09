import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class MathQuestions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Please enter your name: ");
        String name = sc.nextLine();

        String filename = name + "-answers.txt";
        String message = "Math Questions for " + name + "\n";
        

            for (int i = 0; i < 5; i++) {
                int num1 = random.nextInt(100);
                int num2 = random.nextInt(100);

                int correctAnswer = num1 + num2;
                message += "Question " + (i + 1) + ": " + num1 + " + " + num2 + " = ?\n";
                System.out.println("Question " + (i + 1) + ": " + num1 + " + " + num2 + " = ?");

                int userAnswer = sc.nextInt();
                
                if (userAnswer == correctAnswer) {
                    message += "Question " + (i + 1) + ": Correct!\n";
                } else {
                    message += "Question " + (i + 1) + ": " +  Incorrect. The correct answer is " + correctAnswer + ".\n";
                }
        }
        fileWriterTest(message, filename);
        
    }
    private static void fileWriterTest(String message, String fileName) {
            try (FileWriter outStream = new FileWriter(fileName, true)) {
                outStream.write(message);
                System.out.println();
            } catch (IOException e) {
                System.out.println("oops: " + e);
            }
        }
}
