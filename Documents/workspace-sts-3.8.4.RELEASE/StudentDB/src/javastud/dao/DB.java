package javastud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DB {

	public Connection getDBConnection() throws ClassNotFoundException, SQLException {
		// 1. Load Driver
		Class.forName("com.mysql.jdbc.Driver");//register the mysql driver 
		
		//2.Create Connection
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","mattdamon98");

		//3. 
		return conn;
	}
}
