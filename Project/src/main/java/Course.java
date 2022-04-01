public class Course {
    private int capacity = 30;
    private int enrolled = 0;

    public boolean isFull() {
        return enrolled >= capacity;
    }

    public void incrementNumberOfEnrolled() {
        enrolled++;
    }

    public void decrementNumberOfEnrolled() {
        enrolled--;
    }
}
