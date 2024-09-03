package practice.advancedselenium;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;

public class CloseTheConnection 
{

	public static void main(String[] args) throws SQLException 
	{
		Connection conn = null;
		
		try 
		{
			String expectedProjectName="TY_PROJ_13563";
			boolean flag = false;
			//step1:load and register the driver
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			//step2:connect to database
			 conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
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
		catch (Exception e) 
		{
			System.out.println("Handle the exception");
		}
		finally 
		{
			conn.close();
			System.out.println("Connection is closed");
			
		}
	}

}
