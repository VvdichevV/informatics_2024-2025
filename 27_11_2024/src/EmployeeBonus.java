class Employee {
    private String firstName;
    private String lastName;
    private String employeeId;
    private double salary;
    private double performanceRating;

    public Employee(String firstName, String lastName, String employeeId, double salary, double performanceRating){
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.performanceRating = performanceRating;
        this.salary = salary;
    }
    boolean isHighPerformer(){
        if(performanceRating > 4.5) {
            sendPerformanceEmail(calculateBonus(true));
            return true;
        }
        sendPerformanceEmail(calculateBonus(false));
        return false;
    }
    double calculateBonus(boolean performer){
        if(performer) {
            return salary * 20 / 100;
        }
        return salary * 5 / 100;
    }
    void sendPerformanceEmail(double bonus){
        System.out.println("Dear " + firstName + " " + lastName + ", \n" +
                "Based on your performance rating of " + performanceRating + ", you are a valued member of our team. \n" +
                "Your bonus for this period is " + bonus + " . Keep up the great work!\n");

    }

}

public class EmployeeBonus {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Viktor", "Dichev", "HEU32E", 2343480, 10000000);
        Employee emp2 = new Employee("Loser", "Dumby", "OEU54K", 950, 2.2);
        emp1.isHighPerformer();
        emp2.isHighPerformer();
    }

}