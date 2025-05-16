import java.io.*;

public class ObjectSerialization {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Victor", 1000000);
        Employee emp2 = new Employee(2, "Ivan", 11, 13435);
        Student student3 = new Employee(3, "Ivo", 11, 325704);
        student.writeToFile("sample.txt");
        student2.writeToFile("sample.txt");
        student3.writeToFile("sample.txt");

        student.readFromFile("sample.txt");

    }
}

class Employee implements Serializable {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void writeToFile(String path) {
        try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outStream.writeObject(this);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readFromFile(String path) {
        try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream(path))) {
            try {
                while (true) {
                    Student student = (Student) inStream.readObject();
                    System.out.println("ID: " + student.getId());
                    System.out.println("Name: " + student.getName());
                    System.out.println("Grade: " + student.getGrade());
                    System.out.println("GPA: " + student.getGpa());
                }
            } catch (EOFException e) {
                System.out.println("End of file reached.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
