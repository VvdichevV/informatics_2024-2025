import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a category: ");
        System.out.println("1. Science");
        System.out.println("2. History");
        System.out.println("3. Sports");
        byte pick = sc.nextByte();
        String answer;
        switch (pick) {
            case 1:
                System.out.println("What is the most abundant element in the universe?");
                answer = sc.next();
                System.out.println((answer.equals("Hydrogen")) ? "Correct! You earned 1 point." : "Incorrect.The correct answer is Hydrogen");
                break;
            case 2:
                System.out.println("Who was the first Emperor of Rome?");
                answer = sc.next();
                System.out.println((answer.equals("Augustus") ? "Correct! You earned 1 point." : "Incorrect. The correct answer is Augustus."));
                break;
            case 3:
                System.out.println("Who won the Champions League in 2015?");
                answer = sc.next();
                System.out.println((answer.equals("Barcelona") ? "Correct! You earned 1 point. " : "Incorrect. The correct answer is Barcelona."));
                break;
            default:
                System.out.println("Invalid Category Choice");
        }
        sc.close();
    }
}