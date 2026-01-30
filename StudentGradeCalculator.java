import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of grades: ");
        int numGrades = scanner.nextInt();
        double total = 0;

        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            double grade = scanner.nextDouble();
            total += grade;
        }

        double average = total / numGrades;
        System.out.printf("The average grade is: %.2f%n", average);
        
        // Optional: Display letter grade
        if (average >= 90) System.out.println("Grade: A");
        else if (average >= 80) System.out.println("Grade: B");
        else if (average >= 70) System.out.println("Grade: C");
        else if (average >= 60) System.out.println("Grade: D");
        else System.out.println("Grade: F");

        scanner.close();
    }
}
