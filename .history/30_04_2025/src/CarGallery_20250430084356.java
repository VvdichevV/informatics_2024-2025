public class CarGallery {
    public static void main(String[] args) {
        Car[] carArray = {
            new Car("Toyota", "Camry", 2020, 25000),
            new Car("Ford", "Fusion", 2019, 20000),
            new Car("Honda", "Civic", 2016, 15000)
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
    int make;
    String model;
    int year;
    String price;
    public Car
}