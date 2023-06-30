public class Student implements Comparable<Student>{
    private String name;
    private short note;

    public Student(String name, short note) {
        this.name = name;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getNote() {
        return note;
    }

    public void setNote(short note) {
        this.note = note;
    }

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}
