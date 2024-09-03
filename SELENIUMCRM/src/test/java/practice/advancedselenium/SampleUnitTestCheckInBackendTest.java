package practice.advancedselenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleUnitTestCheckInBackendTest {

	@Test
	public void CheckBackendProjectName() throws SQLException
	{
		String expectedProjectName="TY_PROJ_13563";
		boolean flag = false;
		//step1:load and register the driver
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		//step2:connect to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		System.out.println("Database connected successfully");
		//step3:create sql statement
		Statement stat = conn.createStatement();
		//step4:execute select query and get result
		 ResultSet resultSet = stat.executeQuery("Select* from project");
		 while(resultSet.next())
		 {
			 String currentProjectName = resultSet.getString(1);
			 if(expectedProjectName.equals(currentProjectName))
			 {
				 flag=true;
				 System.out.println(expectedProjectName+" is available in database");
			 }
		 }
		 
		 if(flag==false)
		 {
			 Assert.fail();
			 System.out.println(expectedProjectName+"is not available");
		 }
		
		
	}
}
