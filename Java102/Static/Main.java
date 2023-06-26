import java.util.LinkedList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        Course c1 = new Course("Math", "MAT101", 10);
        Course c2 = new Course("Physics", "PHYS101", 100);
        Course c3 = new Course("Turkish", "TUR101", 80);

        List<Course> courseList = new LinkedList<>();
        courseList.add(c1);
        courseList.add(c2);
        courseList.add(c3);

        System.out.println(Course.avg(courseList));
    }
}