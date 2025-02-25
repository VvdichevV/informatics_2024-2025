import java.util.Scanner;
public class CarGallery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car[] carArray = {
                new Car("Toyota", "Camry", 2020, 25000, false),
                new Car("Honda", "Civic", 2016, 15000, true),
                new Car("Ford", "Fusion", 2019, 20000, false),
                new Car("Porsche", "Cayman", 2021, 100000, false),
        };
        char choice;
        do{
            System.out.println("Enter 's' to select a car, 'b' to browse, 'e' for most expensive car, 'a' for average price, 'l' to lease one, and 'q' to quit: ");
            choice = sc.next().charAt(0);
            switch(choice){
                case 's':
                    System.out.print("Enter the number of the car you wish to select: ");
                    int num = sc.nextInt() - 1;
                    if(num <= 0 || num > carArray.length){
                        System.out.println("Invalid number, try again!");
                        break;
                    }
                    System.out.println("Displaying details...");
                    carArray[num].display();
                    break;
                case 'b':
                    displayAllCars(carArray);
                    break;
                case 'e':
                    mostExpensiveCar(carArray);
                    break;
                case 'a':
                    System.out.println("The average price: " + averagePrice(carArray));
                    break;
                case 'l':
                    System.out.println("Enter the number of the car you wish to lease: ");
                    int num1 = sc.nextInt() - 1;
                    if(num1 <= 0 || num1 > carArray.length){
                        System.out.println("Invalid number, try again!");
                        break;
                    }
                    leaseCar(carArray[num1]);
                    System.out.println("You have leased the car successfully!");
                    break;
                case 'q':
                    System.out.println("Thank you for visiting the car gallery!");
                    break;
                default:
                    System.out.println("Invalid option. Try again!");
                    break;
            }
        }while(choice != 'q');
    }
    public static void displayAllCars(Car[] carArray){
        for(Car car : carArray){
            car.display();
        }
    }
    public static void mostExpensiveCar(Car[] carArray){
        int max = 0;
        for(int i = 0; i < carArray.length; i++){
            if(carArray[i].getPrice() > max){max = i;}
        }
        carArray[max].display();
    }
    public static double averagePrice(Car[] carArray){
        double sum = 0.0;
        for(Car car : carArray){
            sum += car.getPrice();
        }
        return sum/carArray.length;
    }
    public static void leaseCar(Car car){
        car.leaseCar();
    }
}
class Car{
    String make;
    String model;
    int year;
    int price;
    boolean isLeased;
    public Car(String make, String model, int year, int price, boolean isLeased) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.isLeased = isLeased;
    }
    public int getPrice(){return price;}
    public void leaseCar(){isLeased = !isLeased;}
    public void display(){
        System.out.println("Make: " + make + ", model: " + model + ", year: " + year + ", price: " + price + ", leased: " + isLeased);
    }
}
