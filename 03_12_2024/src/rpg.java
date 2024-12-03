public class rpg {

    public static void main(String[] args){
        Wizard wizard = new Wizard("Merlin",100, 11,5);
        Warrior warrior = new Warrior("Ragnar",100,7,10);
        DemonKing demonKing = new DemonKing("Victor", 500, 99, 10);
        // Task 5: Create an object/instance of your new character's class.

        System.out.println(wizard.getName() + "'s health: " + wizard.getHealth());
        System.out.println(warrior.getName()+"'s health: " + warrior.getHealth());
        System.out.println(demonKing.getName()+"'s health: " + demonKing.getHealth());
        System.out.println("Game is starting...");
        wizard.setHealth(warrior.getSword());
        System.out.println(warrior.getName()+" attacks " + wizard.getName() + ". Health updated: " + wizard.getHealth());
        demonKing.setHealth(wizard.getDarkMagic());
        System.out.println(wizard.getName()+" attacks " + demonKing.getName() + ". Health updated: " + demonKing.getHealth());
        // Task 6: make the wizard attack your new character.
        // Task 7: display the new stats


        // CHALLENGE: Update your program for all the characters to be able to attack each other.
    }
}


class Wizard {
    private String name;
    private int health;
    private int darkMagic;
    private int wizardArmor;

    public Wizard(String name, int health, int darkMagic, int wizardArmor){
        this.name = name;
        this.health = health;
        this.darkMagic = darkMagic;
        this.wizardArmor = wizardArmor;
    }

    public String getName() {
        return name;
    }

    public int getDarkMagic(){
        return darkMagic;
    }

    public void setHealth(int attack) {
        health = health - (attack - wizardArmor);
    }

    public int getHealth() {
        return health;
    }

}

class Warrior {
    private String name;
    private int health;
    private int sword;
    private int metalArmor;

    public Warrior(String name, int health, int sword, int metalArmor){
        this.name = name;
        this.health = health;
        this.sword = sword;
        this.metalArmor = metalArmor;
    }

    public String getName() {
        return name;
    }

    public int getSword() {
        return sword;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int attack) {
        health = health - (attack - metalArmor);
    }

}

class DemonKing {
    private String name;
    private int health;
    private int voidMagic;
    private int voidArmor;

    public DemonKing(String name, int health, int voidMagic, int voidArmor){
        this.name = name;
        this.health = health;
        this.voidMagic = voidMagic;
        this.voidArmor = voidArmor;
    }
    public String getName() {
        return name;
    }

    public int getVoidMagic() {
        return voidMagic;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int attack) {
        health = health - (attack - voidArmor);
    }
}

// Task 1: Write another class here for a different type of character (e.g. archer)

// Task 2: Write instance variables

// Task 3: Write the constructor

// Task 4: Write the necessary getter(accessor) and setter(modifier) methods.