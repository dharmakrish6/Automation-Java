package moolya.filpkartdemo.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;


public class DbUtils {

	// JDBC driver name and database URL
		static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static String DbUrl = "jdbc:mysql://localhost:3306/mobile";

		//  Database credentials
		static String USER = "root";
		static String PASS = "password";
		
	
	
	public void storeMobileDetailsToDb(String[] details) throws ClassNotFoundException, IOException
	{
		Connection conn = null;
		Statement stmt = null;
		int flag=1; //0=indicates no failure, 1=indicates success of all query execution

		try{
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DbUrl, USER, PASS);
			System.out.println("Connected database successfully...");

			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			System.out.println("Storing Mobile Details");

			String sql1 = "INSERT INTO `mobiles` (`name`,`amount`) VALUES (\""+details[0]+"\","+details[1]+")";
			stmt.executeUpdate(sql1);

			String sql2 = "SELECT `id` from `mobiles` WHERE `name` = \""+details[0]+"\"";
			
			ResultSet rs = stmt.executeQuery(sql2);
			rs.next();
			int id = Integer.parseInt(rs.getString("id"));
			
			for(int i=2;i<details.length;i++){
				String sql3 = "INSERT INTO `details` (`mobile_id`,`details`) VALUES ("+id+",\""+details[i]+"\")";
				stmt.executeUpdate(sql3);
			}
			
			System.out.println("Stored Mobile Details Successfully");

		} //end try
		catch(SQLException se){
			//Handle errors for JDBC
			flag=0;
			se.printStackTrace();
		}

		catch(Exception e){
			//Handle errors for Class.forName
			flag=0;
			e.printStackTrace();
		}

		finally
		{
			//finally block used to close resources
			try
			{
				if(stmt!=null)
					conn.close();
			}
			catch(SQLException se){
			}// do nothing
			try
			{
				if(conn!=null)
					conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}

			Assert.assertTrue(flag==1, "Error!! Storing Mobile Details Query execution failed...");
		}//end finally
		System.out.println("Goodbye!");
	}
	
}
