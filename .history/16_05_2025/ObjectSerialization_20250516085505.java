import java.io.*;

public class ObjectSerialization {
    public static void main(String[] args) {
        Student student = new Student(1, "Victor", 11, 4.0);
        student.writeToFile("sample.txt");
    }
}

class Student implements Serializable {
    private int id;
    private String name;
    private int grade;
    private double gpa;

    public Student(int id, String name, int grade, double gpa) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public double getGpa() {
        return gpa;
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
            try{
                while(true){
                Student student = (Student) inStream.readObject();
                System.out.println("ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Grade: " + student.getGrade());
                System.out.println("GPA: " + student.getGpa());
            }
        }catch (EOFException e) { 
            System.out.println("End of file reached.");
            
        }catch(IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    
    
}}
