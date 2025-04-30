public class CarGallery {
    public static void main(String[] args) {
        Car[] carArray = {
            new Car("Toyota", "Camry", 2020, 25000),
            new Car("Ford", "Fusion", 2019, 20000),
            new Car("Honda", "Civic", 2016, 15000),
            new Car("Porsche", "Cayman", 2021, 100000),
    };

        System.out.println("Morning on the farm!");
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
        System.out.println("VO");
    }
}