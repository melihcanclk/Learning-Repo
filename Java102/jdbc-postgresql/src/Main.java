import java.sql.Connection;
import java.sql.PreparedStatement;
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
//            printDB(connection);
//            String addVal = "INSERT INTO university (student_name, class) VALUES ('Mertcan Cilek', 'FIZ1');";
//            System.out.println(connection.update(addVal));
//            printDB(connection);
//            connection.preparedStatementExample();
            printDB(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printDB( PostgreConnect connection) throws SQLException {
        ResultSet resultSet = connection.execute("SELECT * FROM university");
        while(resultSet.next()){
            System.out.println(resultSet.getInt("student_id"));
            System.out.println(resultSet.getString("student_name"));
            System.out.println(resultSet.getString("class"));
        }
    }
}