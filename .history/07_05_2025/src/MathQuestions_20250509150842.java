import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class MathQuestions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        String filename = name + "-answers.txt";

        try (FileWriter fw = new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(fw)) {


            for (int i = 0; i < 5; i++) {
                int num1 = random.nextInt(100);
                int num2 = random.nextInt(100);

                int correctAnswer = num1 + num2;

                System.out.println("Question " + (i + 1) + ": " + num1 + " + " + num2 + " = ?");

                // Get user's answer
                int userAnswer = scanner.nextInt();




        scanner.close();
    }
}