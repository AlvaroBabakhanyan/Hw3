import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class CourseRegistrationTest {

    private CourseRegistration courseRegSummer2022;

    @BeforeMethod
    public void setUp() {
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

        courseRegSummer2022 = new CourseRegistration(students, courses);  //creating summer course registration with student and course list
    }

    //addCourse()**************************
    @Test
    public void testAddCourse1() { //adding valid student to valid course
        Student student0 = courseRegSummer2022.getStudents().get(0);
        Course course2 =  courseRegSummer2022.getCourses().get(2);
        assertEquals(courseRegSummer2022.addCourse(student0, course2), true);
    }

    @Test
    public void testAddCourse2() { //adding valid course to invalid student
        Student student0 = courseRegSummer2022.getStudents().get(0);
        courseRegSummer2022.addCourse(student0,  courseRegSummer2022.getCourses().get(0));
        courseRegSummer2022.addCourse(student0,  courseRegSummer2022.getCourses().get(2));
        courseRegSummer2022.addCourse(student0,  courseRegSummer2022.getCourses().get(3));
        courseRegSummer2022.addCourse(student0,  courseRegSummer2022.getCourses().get(5));
        courseRegSummer2022.addCourse(student0,  courseRegSummer2022.getCourses().get(7));
        assertEquals(courseRegSummer2022.addCourse(student0, courseRegSummer2022.getCourses().get(1)), false);
    }

    @Test
    public void testAddCourse3() { //adding non-existing course to student
        Student student0 = courseRegSummer2022.getStudents().get(0);
        assertEquals(courseRegSummer2022.addCourse(student0, new Course()), false);
    }

    //removeCourse*************************************
    @Test
    public void testRemoveCourse1() { //removing course when user is not enrolled in that course

        assertEquals(courseRegSummer2022.removeCourse(courseRegSummer2022.getStudents().get(0), courseRegSummer2022.getCourses().get(0)) ,false);
    }

    @Test
    public void testRemoveCourse2() { //removing valid user from valid course
        Student student0 = courseRegSummer2022.getStudents().get(0);
        courseRegSummer2022.addCourse(student0,  courseRegSummer2022.getCourses().get(0));
        assertEquals(courseRegSummer2022.removeCourse(student0, courseRegSummer2022.getCourses().get(0)) ,true);
    }

    //swapCourse*************************************
    @Test
    public void testSwapCourse1() { //swapping valid courses between valid students
        Student student0 = courseRegSummer2022.getStudents().get(0);
        Course course0 =  courseRegSummer2022.getCourses().get(0);
        courseRegSummer2022.addCourse(student0, course0);
        Student student1 = courseRegSummer2022.getStudents().get(1);
        Course course1 =  courseRegSummer2022.getCourses().get(1);
        courseRegSummer2022.addCourse(student1,course1);
        assertEquals(courseRegSummer2022.swapCourse(student0, student1, course0, course1), true);
    }

    @Test
    public void testSwapCourse2() { //swapping courses when student 1 is not enrolled in course 1
        Student student0 = courseRegSummer2022.getStudents().get(0);
        Course course0 =  courseRegSummer2022.getCourses().get(0);
        Student student1 = courseRegSummer2022.getStudents().get(1);
        Course course1 =  courseRegSummer2022.getCourses().get(1);
        courseRegSummer2022.addCourse(student1,course1);
        assertEquals(courseRegSummer2022.swapCourse(student0, student1, course0, course1), false);
    }

    //addCourseToWishlist*************************************
    @Test
    public void testAddToWishlist1() { //adding valid course to valid student's wishlist
        Student student0 = courseRegSummer2022.getStudents().get(0);
        Course course2 =  courseRegSummer2022.getCourses().get(2);
        assertEquals(courseRegSummer2022.addCourseToWishlist(student0, course2), true);
    }

    @Test
    public void testAddToWishlist2() { //adding a course to which a student is already enrolled to the wishlist
        Student student0 = courseRegSummer2022.getStudents().get(0);
        Course course2 =  courseRegSummer2022.getCourses().get(2);
        courseRegSummer2022.addCourse(student0, course2);
        assertEquals(courseRegSummer2022.addCourseToWishlist(student0, course2), false);
    }
}
