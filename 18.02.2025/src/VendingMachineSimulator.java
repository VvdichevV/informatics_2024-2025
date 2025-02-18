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
            int code = sc.nextInt();
            if (code == 0) {break;}
            if (quantity[code - 1] == 0) {
                System.out.println("There is no more of: " + name[code]);
            }else {
                System.out.println("Selected item: " + name[code - 1]);
                System.out.print("Insert money: ");
                double money = sc.nextDouble();
                if (money < price[code - 1]) {
                    System.out.println("You don't have enough money!");
                } else {
                    System.out.println("Dispensing " + name[code - 1]);
                    System.out.println("Change: " + (money - price[code - 1]));
                    quantity[code - 1]--;
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