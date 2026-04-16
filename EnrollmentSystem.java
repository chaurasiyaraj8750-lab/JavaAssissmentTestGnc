import java.util.*;

// Simple Student class
class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Override equals and hashCode for HashMap to work properly
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return id == s.id && Objects.equals(name, s.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

// Simple Course class
class Course {
    String courseName;

    Course(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return courseName;
    }
}

public class EnrollmentSystem {
    public static void main(String[] args) {
        // HashMap to store Student -> List of Courses
        HashMap<Student, ArrayList<Course>> enrollments = new HashMap<>();

        // Create students
        Student s1 = new Student(1, "Raj");
        Student s2 = new Student(2, "Neha`");

        // Create courses
        Course c1 = new Course("Java Programming");
        Course c2 = new Course("Data Structures");
        Course c3 = new Course("Database Systems");

        // Enroll Raj in Java and DS
        enrollments.put(s1, new ArrayList<>(Arrays.asList(c1, c2)));

        // Enroll Priya in DB
        enrollments.put(s2, new ArrayList<>(Arrays.asList(c3)));

        // 🔍 Lookup Raj’s courses
        System.out.println("Courses enrolled by Raj: " + enrollments.get(s1));

        // 🔍 Lookup Neha’s courses
        System.out.println("Courses enrolled by Neha: " + enrollments.get(s2));

        // Add another course for Raj
        enrollments.get(s1).add(new Course("Operating Systems"));
        System.out.println("Updated courses for Raj: " + enrollments.get(s1));
    }
}
