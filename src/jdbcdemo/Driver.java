package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {

	public static void main(String[] args) {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "user", "pwd");

			// 2. Create a statement
			myStmt = myConn.createStatement();

			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from employees");

			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (myRs != null) {
				try {
					myRs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (myStmt != null) {
				try {
					myStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
