import java.util.Scanner;

public class gradebook {
    public static void main(String[] args) {
        String[] students = {"Nikoleta", "Vasil", "Martin","Svetoslav","Irina", "Aleksandar"};
        int[] grades = {99, 49, 89, 45, 35, 78 };

        System.out.println(calculateAverage(grades));
        System.out.println(findHighestGradeStudent(students, grades));
        System.out.println(findLowestGradeStudent(students, grades));
        System.out.println(countFailedStudents(grades));
        System.out.println(lookupStudentGrade(students, grades, "Martin"));


        /* Implement a switch case for the menu:
         * 1. Calculate Average
         * 2. Display the student with the highest grade
         * 3. Display the student with the lowest grade
         * 4. Display the count of students who are failing (>50 is failing)
         * 5. Look up student grade with user input.
         * 6. Exit. */
    }

    private static double calculateAverage(int[] grades) {
        double sum = 0;
        for(int i : grades){
            sum+=i;
        }
        return sum/grades.length;
    }

    private static String findHighestGradeStudent(String[] studentNames, int[] grades) {
        int max = 0;
        for(int i = 0;i < grades.length;i++){
            if(grades[i] > grades[max]){
                max = i;
            }
        }
        return studentNames[max];
    }

    private static String findLowestGradeStudent(String[] studentNames, int[] grades) {
        int min = 0;
        for(int i = 0;i < grades.length;i++){
            if(grades[i] < grades[min]){
                min = i;
            }
        }
        return studentNames[min];
    }

    private static int countFailedStudents(int[] grades) {
        int count = 0;
        for(int i = 0;i < grades.length;i++){
            if(grades[i] < 50){
                count++;
            }
        }
        return count;
    }

    private static int lookupStudentGrade(String[] studentNames, int[] grades, String studentToLookup) {
        for(int i = 0;i < studentNames.length;i++){
            if(studentNames[i].equals(studentToLookup)){
                return grades[i];
            }
        }
        return 0;
    }
}