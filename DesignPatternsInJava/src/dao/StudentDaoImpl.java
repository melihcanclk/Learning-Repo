package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    // list is mimic as database or repository
    List<Student> students;

    public StudentDaoImpl() {
        students = new ArrayList<>();
        Student student1 = new Student("Robert", 0);
        Student student2 = new Student("John", 1);
        students.add(student1);
        students.add(student2);
    }

    @Override
    public List<Student> getAllStudents() {
        return students;
    }

    @Override
    public Student getStudent(int rollNo) {
        return students.get(rollNo);
    }

    @Override
    public void updateStudent(int rollNo, Student student) {
        Student student1 = students.get(rollNo);
        student1.setName(student.getName());
        student1.setRollNo(student1.getRollNo());
        System.out.println(Arrays.toString(students.stream().map(Student::getName).toArray()));
    }

    @Override
    public void deleteStudentWithRollNo(int rollNo) {
        Student student;
        try {
            student = students.get(rollNo);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Student with rollNo " + rollNo + " does not exist.");
            return;
        }

        System.out.println("Student: Roll No " + student.getRollNo() + " and Name " + student.getName() + " deleted from database.");
        students.remove(rollNo);
    }
}
