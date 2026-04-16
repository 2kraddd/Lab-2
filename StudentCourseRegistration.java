import java.util.ArrayList;
import java.util.Scanner;

public class StudentCourseRegistration {

    public static void main(String[] args) {

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // List of courses
        ArrayList<Course> courses = new ArrayList<>();

        // Add some courses
        courses.add(new Course("Math", 2));
        courses.add(new Course("Science", 3));
        courses.add(new Course("History", 2));

        int choice = 0;

        // Menu loop
        while (choice != 4) {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Register for a course");
            System.out.println("2. Drop a course");
            System.out.println("3. View courses");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // important!

            if (choice == 1) {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();

                displayCourses(courses);

                System.out.print("Enter course number: ");
                int index = scanner.nextInt();

                if (index >= 0 && index < courses.size()) {
                    courses.get(index).registerStudent(name);
                } else {
                    System.out.println("Invalid course.");
                }

            } else if (choice == 2) {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();

                displayCourses(courses);

                System.out.print("Enter course number: ");
                int index = scanner.nextInt();

                if (index >= 0 && index < courses.size()) {
                    courses.get(index).dropStudent(name);
                } else {
                    System.out.println("Invalid course.");
                }

            } else if (choice == 3) {
                for (Course c : courses) {
                    c.displayCourseDetails();
                }

            } else if (choice == 4) {
                System.out.println("Goodbye!");

            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    // Helper method to display course names
    public static void displayCourses(ArrayList<Course> courses) {
        System.out.println("\nCourses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(i + ": " + courses.get(i).getCourseName());
        }
    }
}