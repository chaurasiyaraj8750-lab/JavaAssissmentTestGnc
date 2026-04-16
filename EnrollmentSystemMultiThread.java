import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

class EnrollmentTask implements Runnable {
    private List<String> enrollmentList;
    private String course;

    EnrollmentTask(List<String> enrollmentList, String course) {
        this.enrollmentList = enrollmentList;
        this.course = course;
    }

    @Override
    public void run() {
        // synchronized block ensures only one thread modifies at a time
        synchronized (enrollmentList) {
            enrollmentList.add(course);
            System.out.println(Thread.currentThread().getName() + " enrolled in: " + course);
        }
    }
}

public class EnrollmentSystemMultiThread {
    public static void main(String[] args) throws InterruptedException {
        // Option 1: Use synchronized block with ArrayList
        List<String> enrollmentList = new ArrayList<>();

        // Option 2: Use thread-safe collection directly
        // List<String> enrollmentList = new CopyOnWriteArrayList<>();

        Thread t1 = new Thread(new EnrollmentTask(enrollmentList, "Java Programming"), "Thread-1");
        Thread t2 = new Thread(new EnrollmentTask(enrollmentList, "Data Structures"), "Thread-2");
        Thread t3 = new Thread(new EnrollmentTask(enrollmentList, "Database Systems"), "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        // Wait for threads to finish
        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final Enrollment List: " + enrollmentList);
    }
}
