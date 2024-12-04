public class Main {
    public void main(String[] args) {

        Habitat habitat1 = new Habitat("Savannah", 5, 16);
        Habitat habitat2 = new Habitat("Ocean", 5, 26);
        Habitat habitat3 = new Habitat("Forest", 1000, 28);

        Zoo zoo = new Zoo();
        zoo.addAnimal1();
        zoo.addAnimal2();
        zoo.addAnimal3();
        zoo.addAnimal4();

        Staff s1 = new Staff("Kamen", "Caretaker");
        s1.assignStaff(habitat1);

        Staff s2 = new Staff("Ivaylo", "Scuba diver");
        s2.assignStaff(habitat2);

        Staff s3 = new Staff("Bogdan", "Kamen's boss");
        s3.assignStaff(habitat3);

        Staff s4 = new Staff("Victor", "Owner of the zoo");
        s4.assignStaff(new Habitat("Boss's office", 1, 25));

        zoo.a1.eatFood("rhino meat", s1);
        zoo.a2.eatFood("fish food", s2);
        zoo.a3.eatFood("shrimp", s3);
    }

    class Zoo {
        //composition
        private Animal a1;
        private Animal a2;
        private Animal a3;
        private Animal a4;


        void addAnimal1() {
            a1 = new Animal("Rory", "lion", 10, new Habitat("Savannah", 5, 16));
        }

        void addAnimal2() {
            a2 = new Animal("Nemo", "clownfish", 2, new Habitat("Ocean", 5, 26));
        }

        void addAnimal3() {
            a3 = new Animal("Viktor", "octopus", 17, new Habitat("Ocean", 100, 26));
        }

        void addAnimal4() {
            a4 = new Animal("Bugs Bunny", "bunny", 83, new Habitat("Forest", 1000, 28));
        }

    }

    class Animal {
        private String name;
        private String species;
        private int age;
        //composition
        private Habitat habitat;

        public Animal(String name, String species, int age, Habitat habitat) {
            this.name = name;
            this.species = species;
            this.age = age;
            this.habitat = habitat;

        }

        void eatFood(String food, Staff staff) {
            //association
            System.out.println("Staff member " + staff.getName() + " feeds " + species + " " + name + " " + food);
        }
    }

    class Staff {
        private String name;
        private String role;
        //composition
        private Habitat assignedHabitat;

        public Staff(String name, String role) {
            this.name = name;
            this.role = role;
        }

        // association
        void assignStaff(Habitat habitat) {
            System.out.println(name + " is assigned to " + habitat.type);
            this.assignedHabitat = habitat;
        }

        String getName() {
            return name;
        }
    }

    class Habitat {
        private String type;
        private double size;
        private double temperature;

        public Habitat(String type, double size, double temperature) {
            this.type = type;
            this.size = size;
            this.temperature = temperature;
        }
    }
}