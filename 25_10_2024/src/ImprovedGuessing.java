
import java.util.Random;
import java.util.Scanner;

public class ImprovedGuessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        int num = rn.nextInt(100) + 1;
        int attempts = 0;
        System.out.println("Welcome to the guessing game. You'll need to guess the correct number between 1 and 100. You can always quit by typing \"quit\". Good luck!");
        int answer;
        do {
            if (sc.hasNextInt()) {
                answer = sc.nextInt();
                attempts++;
                if (answer > num) {
                    System.out.println("The number is lower than the number you guessed.");
                } else if (answer < num) {
                    System.out.println("The number is greater than the number you guessed.");
                } else {
                    System.out.println("You guessed correctly!");
                    break;
                }
            } else {
                String text = sc.next();
                if (text.equals("quit")) {
                    System.out.println("Thank you for playing. The correct number was " + num + ". Goodbye!");
                    break;
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            }
        } while (true);
        System.out.println("You made " + attempts + " attempts.");
        sc.close();
    }
}
