package mvc;

public class MVCPattern {
    public static void main(String[] args) {
        StudentEntity model = retrieveStudentFromDatabase();

        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();
        controller.setStudentName("Melihcan");
        controller.updateView();

    }

    private static StudentEntity retrieveStudentFromDatabase(){
        StudentEntity student = new StudentEntity();
        student.setName("Robert");
        student.setRollNo("10");
        return student;
    }
}
