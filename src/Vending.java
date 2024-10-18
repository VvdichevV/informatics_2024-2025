import java.util.Scanner;

public class Vending {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a code for the vending machine: ");
        String code = sc.next();
        switch (code) {
            case "A1":
                System.out.println("Product: Soda; Price - $1.50");
                break;
            case "B2":
                System.out.println("Product: Chips; Price - $1.25");
                break;
            case "C3":
                System.out.println("Product: Candy; Price - $0.75");
                break;
            case "D4":
                System.out.println("Product: Water; Price $1.00");
                break;
            default:
                System.out.println("Error...");
        }
        sc.close();
    }
}
