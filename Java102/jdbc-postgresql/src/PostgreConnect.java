import java.sql.*;

public class PostgreConnect{
    private Statement st = null;

    PostgreConnect(){
        try {
            GetDotEnvForDB env = new GetDotEnvForDB();
            String db_url = env.getUrl();
            String db_username = env.getUsername();
            String db_password = env.getPassword();
            Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
            st = connection.createStatement();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public ResultSet connect(String query) throws SQLException{
        return st.executeQuery(query);
    }
}
