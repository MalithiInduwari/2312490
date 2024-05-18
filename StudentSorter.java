import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    int id;
    String firstName;
    double cgpa;

    public Student(int id, String firstName, double cgpa) {
        this.id = id;
        this.firstName = firstName;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (Double.compare(s2.getCgpa(), s1.getCgpa()) != 0) {
            return Double.compare(s2.getCgpa(), s1.getCgpa());
        } else if (!s1.getFirstName().equals(s2.getFirstName())) {
            return s1.getFirstName().compareTo(s2.getFirstName());
        } else {
            return Integer.compare(s1.getId(), s2.getId());
        }
    }
}

public class StudentSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = scanner.nextInt();
            String firstName = scanner.next();
            double cgpa = scanner.nextDouble();
            students.add(new Student(id, firstName, cgpa));
        }

        Collections.sort(students, new StudentComparator());
          System.out.println("----------------------------------");
          System.out.println("OUTPUT");
        for (Student student : students) {
            System.out.println(" " + student.getFirstName());
        }

        scanner.close();
    }
}


