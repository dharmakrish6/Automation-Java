package moolya.embibe.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresDbUtils {

	static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String dbIp;
	private static String dbPort;
	private static String dbName;
	private static String dbUserName;
	private static String dbPassword;
	private static String dbUrl;

	public static Connection getDbConnection() throws IOException
	{
		dbIp = JavaUtils.getPropValue("mDbIp");
		dbPort = JavaUtils.getPropValue("mDbPort");
		dbName = JavaUtils.getPropValue("mDbName");
		dbUserName = JavaUtils.getPropValue("mDbUserName");
		dbPassword =JavaUtils.getPropValue("mDbPassword");
		dbPassword = dbPassword.replaceAll("@", "%40");
		// JDBC driver name and database URL
		dbUrl = "jdbc:mysql://"+dbIp+":"+dbPort+"/"+dbName; //master schema db
		Connection conn = null;
		Statement stmt = null;
		int flag=1; //0=indicates no failure, 1=indicates success of all query execution
		try{
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			System.out.println("Connected database successfully...");
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}

	public static void select(String name) throws ClassNotFoundException, IOException
	{
		Connection conn = getDbConnection();
		Statement stmt = null;
		try{
			// Execute a query
			conn.setAutoCommit(false);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			
			System.out.println("Deleting the Office");

			String sql = "SET @name = '"+name+"';";
			stmt.executeUpdate(sql);

			String sql1 = "SELECT FROM `` WHERE ``;";
			stmt.executeUpdate(sql1);
			stmt.close();
			conn.commit();
		} //end try
		catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
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

		}//end finally
		System.out.println("Goodbye!");

	}

}
