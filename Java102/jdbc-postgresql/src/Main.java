import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        PostgreConnect connection = new PostgreConnect();
        try {
            /*
            * We have a database with columns
            * student_id which is primary key
            * student name with varchar(50)
            * class that a student takes which is varchar(5)
            * */
            ResultSet resultSet = connection.connect("SELECT * FROM university");
            while(resultSet.next()){
                System.out.println(resultSet.getInt("student_id"));
                System.out.println(resultSet.getString("student_name"));
                System.out.println(resultSet.getString("class"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}