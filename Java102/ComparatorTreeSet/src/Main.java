import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Set<Student> set = new TreeSet<>();
        set.add(new Student("Meluhcan", (short) 50));
        set.add(new Student("Ahmet", (short) 20));
        set.add(new Student("CC", (short) 10));

        for(Student s: set){
            System.out.println(s.getName());
        }

    }
}