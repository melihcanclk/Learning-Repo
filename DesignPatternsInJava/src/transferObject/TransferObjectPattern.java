package transferObject;

public class TransferObjectPattern {
    public static void main(String[] args) {
        StudentBO studentBO = new StudentBO();

        for (StudentVO student : studentBO.getAllStudents()) {
            System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
        }

        StudentVO student = studentBO.getAllStudents().get(0);
        student.setName("Michael");
        studentBO.updateStudent(student);

        student = studentBO.getStudent(0);
        System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
    }
}
