public class CarGallery {
    public static void main(String[] args) {
        Car[] carArray = {
            new Car("Toyota", "Camry", 2020, 25000),
            new Car("Ford", "Fusion", 2019, 20000),
            new Car("Honda", "Civic", 2016, 15000),
            new SportsCar("Porsche", "911 Carrera", 1973, 278000),
            new SUV("Jeep", "Wrangler", 2021, 35000),
    };

        System.out.println("Check out this car gallery!");
        for (Animal animal : farmAnimals) {
            animal.makeSound();
            System.out.println(animal.getName() + " produces: " + animal.getProduct());
            System.out.println();
        }

    }
}

class Car {
    String make;
    String model;
    int year;
    int price;
    public Car(String make, String model, int year, int price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }
    public void makeNoise() {
        System.out.println("Vroom vroom!");
    }
    public void repair() {
        System.out.println("Repairing " + make + " " + model);
    }
    public void statePurpose() {
        System.out.println(make + " " + model + " is for general driving.");
    }
    public void display() {
        System.out.println("Car: " + make + " " + model + ", Year: " + year + ", Price: $" + price);
    }
}

class SUV extends Car {
    public SUV(String make, String model, int year, int price) {
        super(make, model, year, price);
    }
    @Override
    public void makeNoise() {
        System.out.println("Honk honk!");
    }
}

class SportsCar extends Car {
    public SportsCar(String make, String model, int year, int price) {
        super(make, model, year, price);
    }
    @Override
    public void makeNoise() {
        System.out.println("VROOOOM!");
    }
}