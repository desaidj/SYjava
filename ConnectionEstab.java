import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class ConnectionEstab {

	public static final String URL = "jdbc:mysql://127.0.0.1:3306/employee";
    public static final String USER = "Admin";
    public static final String PASS = "1234";

    public static Connection getConnection()
    {
      try {
    	  System.out.println("trying to connect");
          DriverManager.registerDriver(new Driver());
          System.out.println("connected..");

          return DriverManager.getConnection(URL, USER, PASS);
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      }
      
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionEstab.getConnection();
	}

}