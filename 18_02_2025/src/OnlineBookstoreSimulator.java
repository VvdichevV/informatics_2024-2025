import java.util.Scanner;

public class OnlineBookstoreSimulator {
    static String[] name = {"Harry Potter", "Atomic Habits", "The Alchemist", "The Da Vinci Code", "Percy Jackson"};
    static double[] price = {11.69, 15.99, 17.99, 12.39, 11.99};
    static int[] quantity = {5, 3, 4, 2, 6};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Online Bookstore Simulator!");
        System.out.print("Press 's' to search for a book, 'b' to browse, 'p' to purchase, and 'q' to quit: ");
        do {
            char input = sc.next().charAt(0);
            if (input == 's') {
                System.out.print("Enter the name of the book: ");
                sc.nextLine();
                String book = sc.nextLine();
                printBookInfo(book);
            }else if(input == 'p') {
                System.out.print("Enter the code of the book you wish to purchase: ");
                int code = sc.nextInt() - 1;
                if (!(code >= 0 && code <= name.length)){
                    System.out.println("Invalid code! Return with a correct code next time!");
                    break;
                }
                System.out.print("Enter your credit card balance: ");
                double balance = sc.nextDouble() - price[code];
                if(balance >= 0){
                    System.out.println("Purchase confirmed!");
                    System.out.println("Remaining money: " + balance);
                    quantity[code]--;
                }else{
                    System.out.println("Insufficient funds! Return with more money!");
                }
            }else if(input == 'q') {
                System.out.println("Thank you for visiting our store!");
                break;
            }else if(input == 'b') {
                printItems();
            }
        }while(true);


    }
    static void printBookInfo(String book) {
        boolean check = true;
        for(int i = 0; i < name.length; i++){
            if(name[i].equalsIgnoreCase(book)){
                System.out.println("Book Information: ");
                System.out.println("Code: " + name[i] + ", Price: " + price[i] + ", Quantity: " + quantity[i]);
                check = false;
                break;
            }
        }
        if(check){
            System.out.println("Sorry! We didn't find this book in our library.");
        }
    }
    static void printItems(){
        System.out.println("Available Books:");
        System.out.println("Code     |     Title  |     Price  |     Quantity");
        for(int i = 0; i < name.length; i++){
            System.out.println((i+1) + "        " + name[i] + "             " + price[i] + "       " + quantity[i]);
        }
        System.out.print("");
    }
}