class Students {
    private String name;
    private int age;
    private String studentID;
    private String course;
    private double tuitionFee;
    public Students(String name, int age, String course, double tuitionFee, String studentID){
        this.name = name;
        this.age = age;
        this.course = course;
        this.studentID = studentID;
        this.tuitionFee = tuitionFee;
    }
    boolean isEligibleForDiscount(){
        return (age < 25 && course.equals("Full-Time"));
    }
    double calculateDiscount(){
        return tuitionFee*15/100;
    }
    void generateDiscountEmail(){
        System.out.println("Dear " + name + ",\nWe are pleased to inform you that you are eligible for a\n15% discount on your tuition fee for the course\n" + course +".\nYour discounted tuition fee is " + (tuitionFee - calculateDiscount()) +". We hope this helps in supporting your academic journey! Best regards, ACS Administration ");

    }

}

public class StudentDiscount {
    public static void main(String[] args) {
        Students stu1 = new Students("Viktor Dichev", 17, "Full-Time", 10000, "EUHOT84");
        Students stu2 = new Students("Loser Dumby", 28, "Part-Time", 10000, "KEUTH32");
        if(stu1.isEligibleForDiscount()){
            stu1.generateDiscountEmail();
        }
        if(stu2.isEligibleForDiscount()){
            stu2.generateDiscountEmail();
        }
    }

}