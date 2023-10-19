package dao;

public class DaoPattern {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();
        printAllStudents(studentDao);

        Student student = studentDao.getAllStudents().get(0);
        System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");

        studentDao.updateStudent(0, new Student("Michael", 534));
        printAllStudents(studentDao);

        studentDao.deleteStudentWithRollNo(1);
        printAllStudents(studentDao);

        studentDao.deleteStudentWithRollNo(53);
    }

    private static void printAllStudents(StudentDao studentDao){
        for (Student student : studentDao.getAllStudents()) {
            System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
        }
    }
}
