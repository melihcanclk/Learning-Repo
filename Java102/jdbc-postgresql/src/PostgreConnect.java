import java.sql.*;

public class PostgreConnect{
    private Statement st = null;
    private Connection connection = null;

    PostgreConnect(){
        try {
            GetDotEnvForDB env = new GetDotEnvForDB();
            String db_url = env.getUrl();
            String db_username = env.getUsername();
            String db_password = env.getPassword();
            connection = DriverManager.getConnection(db_url, db_username, db_password);
            st = connection.createStatement();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public ResultSet execute(String query) throws SQLException{
        return st.executeQuery(query);
    }

    public int update(String query) throws SQLException {
        return st.executeUpdate(query);
    }

    public void preparedStatementExample(){
        String preparedSt = "INSERT INTO university(student_name, class) VALUES(?,?);";
        try {
            PreparedStatement prst = connection.prepareStatement(preparedSt);
            prst.setString(1, "Damla");
            prst.setString(2, "DIN1");
            prst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
