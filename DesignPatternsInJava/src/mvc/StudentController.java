package mvc;

public class StudentController {
    private StudentEntity model;
    private StudentView view;

    public StudentController(StudentEntity studentEntity, StudentView studentView) {
        this.model = studentEntity;
        this.view = studentView;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentRollNo(String rollNo) {
        model.setRollNo(rollNo);
    }

    public String getStudentRollNo() {
        return model.getRollNo();
    }

    public void updateView() {
        view.printStudentDetails(model);
    }
}
