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
                // Generate random numbers between 0 and 100
                int num1 = random.nextInt(100);
                int num2 = random.nextInt(100);

                // Calculate correct answer
                int correctAnswer = num1 + num2;

                // Ask question
                System.out.println("Question " + (i + 1) + ": " + num1 + " + " + num2 + " = ?");

                // Get user's answer
                int userAnswer = scanner.nextInt();

                // Check if answer is correct
                boolean isCorrect = (userAnswer == correctAnswer);
                if (isCorrect)
                    correctAnswers++;

                // Write to file
                bw.write("Question " + (i + 1) + ": " + num1 + " + " + num2 + " = " + correctAnswer);
                bw.newLine();
                bw.write("User's answer: " + userAnswer);
                bw.newLine();
                bw.write("Status: " + (isCorrect ? "Correct" : "Incorrect"));
                bw.newLine();
                bw.newLine();
            }

            // Write final score
            bw.write("Final Score: " + correctAnswers + "/5");

            System.out.println("Your answers have been saved to " + filename);

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }

        scanner.close();
    }
}