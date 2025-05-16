import java.io.*;

public class ObjectSerialization {
    public static void main(String[] args) {
        Student stu
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
            System.out.println("oops: " + e.getMessage());
        }
    }
}
