import java.sql.*;
import javax.swing.*;
public class DatabaseConnection {

	
	public static Connection ConnectionDB() {
		
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hotel","abc");
			return conn;
			
		
			
			
			
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, e);
			return null;

		}
		
	}

}