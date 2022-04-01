import java.util.ArrayList;

public class Student {

    private ArrayList<Course> courses;
    private ArrayList<Course> wishlist;

    public Student() {
        courses = new ArrayList<>(5);
        wishlist = new ArrayList<>(2);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Course> getWishlist() {
        return wishlist;
    }
}
