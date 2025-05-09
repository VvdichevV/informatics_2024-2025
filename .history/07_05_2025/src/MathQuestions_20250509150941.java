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
        

            for (int i = 0; i < 5; i++) {
                int num1 = random.nextInt(100);
                int num2 = random.nextInt(100);

                int correctAnswer = num1 + num2;

                System.out.println("Question " + (i + 1) + ": " + num1 + " + " + num2 + " = ?");

                // Get user's answer
                int userAnswer = scanner.nextInt();

                sc.close();
            }
        }
        private static void fileWriterTest(String message, String fileName) {
            try (FileWriter outStream = new FileWriter(fileName, true)) {
                outStream.write(message);
                System.out.println("fileWriterTest method is successful!");
            } catch (IOException e) {
                System.out.println("oops: " + e);
            }
        }
    }
