package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GraphTalk {

	public static void main(String[] args) {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://graphtalk.db4free.net:3306/graphtalk", "snabbat", "Sunshine@@2019");

			if (myConn != null) {
				System.out.println("Ok");
			} else {
				System.out.println("kO");
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
