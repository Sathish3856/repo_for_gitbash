package practice.advancedselenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteSelectQueryTest {

	public static void main(String[] args) throws SQLException 
	{
		//step1:load and register the database driver
		Driver refDriver = new Driver();
		DriverManager.registerDriver(refDriver);
		//step2:connect to the database
		Connection conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		System.out.println("Database connected successfully");
		//step3:create sql statement
		Statement statement = conn.createStatement();
		//step4:execute select query & get result
		ResultSet resultset=statement.executeQuery("Select * from project");
		while(resultset.next())
		{
			System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\n"+resultset.getString(4)+"\n"+resultset.getString(5)+"\n"+resultset.getString(6));
		}
		//step5:close the connection
		conn.close();
		
		
		
	
		
		
		

	}

}
