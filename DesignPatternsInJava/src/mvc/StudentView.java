package mvc;

public class StudentView {
    public void printStudentDetails(StudentEntity studentEntity) {
        System.out.println("Student: ");
        System.out.println("   Name: " + studentEntity.getName());
        System.out.println("   Roll No: " + studentEntity.getRollNo());
    }
}
