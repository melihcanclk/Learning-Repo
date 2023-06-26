import java.util.LinkedList;
import java.util.List;

public class Course {
    private String name;
    private String code;

    private int note;

    public Course(String name, String code, int note){
        this.name = name;
        this.code = code;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public static double avg(List<Course> courses){
        double total=0.0;

        for(Course c: courses){
            total += c.getNote();
        }
        return (total / courses.size());
    }
}
