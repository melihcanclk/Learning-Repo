package dao;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents();
    Student getStudent(int rollNo);
    void updateStudent(int rollNo, Student student);
    void deleteStudentWithRollNo(int rollNo);
}
