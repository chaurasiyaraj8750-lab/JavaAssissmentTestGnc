// Custom Exception
class InvalidFeeException extends Exception {
    public InvalidFeeException(String message) {
        super(message);
    }
}

// Course class with fee validation
class Course {
    String courseName;
    double fee;

    Course(String courseName, double fee) throws InvalidFeeException {
        if (fee < 0) {
            throw new InvalidFeeException("Course fee cannot be negative: " + fee);
        }
        this.courseName = courseName;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return courseName + " (Fee: " + fee + ")";
    }
}

public class EnrollmentTest {
    public static void main(String[] args) {
        try {
            // Valid course
            Course c1 = new Course("Java Programming", 5000);
            System.out.println("Enrolled: " + c1);

            // Invalid course with negative fee
            Course c2 = new Course("Data Structures", -2000);
            System.out.println("Enrolled: " + c2);

        } catch (InvalidFeeException e) {
            System.out.println("Error during enrollment: " + e.getMessage());
        }
    }
}
