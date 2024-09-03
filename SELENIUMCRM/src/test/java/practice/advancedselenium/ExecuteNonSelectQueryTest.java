package practice.advancedselenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNonSelectQueryTest {

	public static void main(String[] args) throws SQLException 
	{
		//step1:load and register the database driver
		Driver refDriver = new Driver();
		DriverManager.registerDriver(refDriver);
		//step2:connect to the database
		Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		System.out.println("Database connected");
		//step3:create sql statement
		Statement stat = conn.createStatement();
		//step4:execute non select query and get result
		int result = stat.executeUpdate("insert into project values('TY_PROJ_81853','deepak','26/07/2024','PO_81853','Completed','11')");
		System.out.println(result);
		//step5:close the connection
		conn.close();
		
	}

}
