import java.util.Scanner;

public class VendingMachineSimulator {
    static String[] name = {"Cola", "Sticks", "Cheese", "Candy", "Fanta"};
    static double[] price = {1.69, 5.99, 7.99, 2.39, 1.99};
    static int[] quantity = {5, 3, 4, 2, 6};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            printItems();
            System.out.print("Enter code (press 0 to exit): ");
            int code = sc.nextInt() - 1;
            if (code == -1) {
                break;
            }else if(code < 0 || code >= name.length) {
                System.out.println("Invalid code");
            }else {
                if (quantity[code] == 0) {
                    System.out.println("There is no more of: " + name[code]);
                } else {
                    System.out.println("Selected item: " + name[code]);
                    System.out.print("Insert money: ");
                    double money = sc.nextDouble();
                    if (money < price[code]) {
                        System.out.println("You don't have enough money!");
                    } else {
                        System.out.println("Dispensing " + name[code]);
                        System.out.println("Change: " + (money - price[code]));
                        quantity[code]--;
                    }
                }
            }
        }while(true);


    }
        static void printItems(){
            System.out.println("Available Items:");
            System.out.println("Code  |  Name  |  Price  |  Quantity");
            for(int i = 0; i < name.length; i++){
                System.out.println((i+1) + "        " + name[i] + "      " + price[i] + "       " + quantity[i]);
            }
            System.out.print("");
        }
}