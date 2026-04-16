// Abstract class
abstract class Course {
    String courseName;

    Course(String courseName) {
        this.courseName = courseName;
    }

    // Abstract method - must be implemented by subclasses
    abstract double calculateFee();
}

// Subclass for Online Course
class OnlineCourse extends Course {
    OnlineCourse(String courseName) {
        super(courseName);
    }

    @Override
    double calculateFee() {
        return 5000; // fixed fee for online course
    }
}

// Subclass for Offline Course
class OfflineCourse extends Course {
    OfflineCourse(String courseName) {
        super(courseName);
    }

    @Override
    double calculateFee() {
        return 8000; // higher fee for offline course
    }
}

public class OOPDemo {
    public static void main(String[] args) {
        Course c1 = new OnlineCourse("Java Programming");
        Course c2 = new OfflineCourse("Data Structures");

        System.out.println(c1.courseName + " Fee: " + c1.calculateFee());
        System.out.println(c2.courseName + " Fee: " + c2.calculateFee());
    }
}

