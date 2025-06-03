import java.sql.*;

public class DataBaseConnection {
    private final static String  URL = "jdbc:mysql://localhost:3306/user_auth";
    private final static String name = "root";
    private final static String password = "chandu";

    public static Connection getConnection() throws SQLException {
      return DriverManager.getConnection(URL, name, password);
    }

    public static boolean checkLoginCredentials(String email, String password) throws SQLException {
        try(Connection conn = getConnection()){
            String query = "select * from users where email = ? AND password = ?";
            PreparedStatement stmt =conn.prepareStatement(query);
            stmt.setString(1,email);
            stmt.setString(2,password);
            ResultSet rs = stmt.executeQuery();
           return rs.next();
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public static void RegisterUser(String email, String password) throws SQLException {
        try(Connection conn = getConnection())   {
            String query = "insert into users (email,password) values  (? ,?) ";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,email);
            stmt.setString(2,password);
             stmt.executeUpdate();
           // System.out.println("Registerd sucessfully");

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
