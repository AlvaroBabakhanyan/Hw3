import java.util.ArrayList;

public class CourseRegistration {

    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    public CourseRegistration(ArrayList<Student> students, ArrayList<Course> courses) {
        this.students = students;
        this.courses = courses;
    }

    public boolean addCourse(Student student, Course course) {
        if (course.isFull() || student.getCourses().size() >= 5) {
            return false;
        }
        if (students.contains(student) && courses.contains(course) && !student.getCourses().contains(course)) {
            student.getCourses().add(course);
            student.getWishlist().remove(course);
            course.incrementNumberOfEnrolled();
            return true;
        }
        return false;
    }

    public boolean removeCourse(Student student, Course course) {
        if (students.contains(student) && courses.contains(course) && student.getCourses().contains(course)) {
            student.getCourses().remove(course);
            course.decrementNumberOfEnrolled();
            return true;
        }
        return false;
    }

    public boolean swapCourse(Student student1, Student student2, Course course1, Course course2) {
        if (students.contains(student1) && courses.contains(course1)  && student1.getCourses().contains(course1)
                && students.contains(student2) && courses.contains(course2) && student2.getCourses().contains(course2)) {
            student1.getCourses().remove(course1);
            student1.getCourses().add(course2);
            student2.getCourses().remove(course2);
            student2.getCourses().add(course1);
            return true;
        }
        return false;
    }

    public boolean addCourseToWishlist(Student student, Course course) {
        if (students.contains(student) && courses.contains(course)
                && !student.getCourses().contains(course) && !student.getWishlist().contains(course)) {
            student.getWishlist().add(course);
            return true;
        }
        return false;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }


    public static void main(String[] args) {
       ArrayList<Student> students = new ArrayList<>();
       students.add(new Student());
       students.add(new Student());
       students.add(new Student());
       students.add(new Student());
       students.add(new Student());

       ArrayList<Course> courses = new ArrayList<>();
       courses.add(new Course());
       courses.add(new Course());
       courses.add(new Course());
       courses.add(new Course());
       courses.add(new Course());
       courses.add(new Course());
       courses.add(new Course());
       courses.add(new Course());
       courses.add(new Course());
       courses.add(new Course());

       CourseRegistration summer2022 = new CourseRegistration(students, courses);

       summer2022.addCourseToWishlist(students.get(0), courses.get(0));
       summer2022.addCourse(students.get(0), courses.get(0));

       System.out.println();

    }
}
