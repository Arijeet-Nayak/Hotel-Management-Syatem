import java.sql.*;


public class Conn {

	
	Connection c;
	Statement s;
	
	Conn() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");  // 1) register driver
		c = DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem", "root", "Arijeet1!"); // 2) creating connection string
		s = c.createStatement(); // 3) creating statement
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
