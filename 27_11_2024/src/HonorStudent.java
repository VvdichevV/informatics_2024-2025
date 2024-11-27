class Students {
    private String name;
    private String lastName;
    private int gradeLevel;
    private double gpa;
    private String schoolName;
    public Students(String name, String lastName, int gradeLevel, double gpa, String schoolName){
        this.name = name;
        this.lastName = lastName;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
        this.schoolName = schoolName;
    }
    boolean isHonorStudent(){
        if(gpa > 3.8) {
            HonorStudentEmail();
            return true;
        }
        System.out.println("Dear " + name + ", you're not one of the honor students. Try harder next time!");
        return false;
    }
    void HonorStudentEmail(){
        System.out.println("Dear " + name + " ,you are selected as one of the honor students of " +  schoolName + " in class 2023 with the GPA of " + gpa + ". Congratulations and we look forward to celebrating your achievement in the graduation ceremony. Good job my friend ;)");

    }

}

public class HonorStudent {
    public static void main(String[] args) {
        Students stu1 = new Students("Viktor", "Dichev", 11, 4.0, "ACS");
        Students stu2 = new Students("Loser", "Dumby", 11, 2.9, "ACS");
        stu1.isHonorStudent();
        stu2.isHonorStudent();
    }

}