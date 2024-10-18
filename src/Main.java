
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();
        int num = rn.nextInt(10) + 1;
        for (int i = 2; i >= 0; i--) {
            System.out.println("\nWhat is your guess?");
            byte guess = sc.nextByte();
            if (guess > num) {
                System.out.println("Your guess is too high.");
            } else if (guess == num) {
                System.out.println("Congrats, you guessed correctly!");
                break;
            } else {
                System.out.println("Your guess is too low.");
            }
            System.out.println("You have " + i + " guesses left.");
        }
        sc.close();
    }
}
