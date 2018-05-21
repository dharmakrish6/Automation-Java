package moolya.embibe.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class SqliteUtils {
	
	static String JDBC_DRIVER = "org.sqlite.JDBC";
	private static String dbIp;
	private static String dbPort;
	private static String dbName;
	private static String dbUserName;
	private static String dbPassword;
	private static String dbUrl;

	public static Connection getDbConnection() throws IOException
	{
		String dir = System.getProperty("user.dir");
		String dbPath = dir+"/db/test-data.db";
		// JDBC driver name and database URL
		dbUrl = "jdbc:sqlite:"+dbPath; //master schema db
		Connection conn = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(dbUrl);
			System.out.println("Connected database successfully...");
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Connection getDbConnection(String dbName) throws IOException
	{
		String dir = System.getProperty("user.dir");
		String dbPath = dir+"/db/"+dbName;
		// JDBC driver name and database URL
		dbUrl = "jdbc:sqlite:"+dbPath; //master schema db
		Connection conn = null;
		try{
			//STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			//STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(dbUrl);
			System.out.println("Connected database successfully...");
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}

	public static void getEmails() throws ClassNotFoundException, IOException
	{
		Connection conn = getDbConnection();
		Statement stmt = null;
		try{
			// Execute a query
			conn.setAutoCommit(false);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			
			System.out.println("Displaying Emails stored in db");

			String sql = "SELECT `email` FROM `signUpEmails`;";
			ResultSet rs = stmt.executeQuery(sql);
			while ( rs.next() ) {
				System.out.println(rs.getString("email"));
			}
			rs.close();
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
	
	public static String updateAndGetCounter() throws ClassNotFoundException, IOException
	{
		Connection conn = getDbConnection();
		Statement stmt = null;
		String count = null;
		try{
			// Execute a query
			conn.setAutoCommit(false);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			
			System.out.println("Updating Counter stored in db");

			String sql = "Update `counter` set count=count+1 where `id`=1;";
			stmt.executeUpdate(sql);
			
			System.out.println("Getting Counter stored in db");
			
			String sql1 = "Select `count` from `counter` where `id`=1;";
			ResultSet rs = stmt.executeQuery(sql1);
			if(rs.next())
				count = rs.getString("count");
			rs.close();
			stmt.close();
			conn.commit();
			return count;
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
			System.out.println("Goodbye!");
		}//end finally
		
		return count;

	}
	
	public static Object[][] getLearnParams() throws IOException{
		Object[][] obj = null;
		Connection conn = getDbConnection("ConceptsVideoData.db");
		Statement stmt = null;
		ArrayList<String> learnPaths = new ArrayList<String>();
		ArrayList<String> entityCodes = new ArrayList<String>();
		try{
			// Execute a query
			conn.setAutoCommit(false);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			
			String sql = "select `learn_path`,`entity_code` from `LearnConcept`;";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				learnPaths.add(rs.getString("learn_path"));
				entityCodes.add(rs.getString("entity_code"));
			}
			obj = new Object[learnPaths.size()][2];
			for(int i=0;i<learnPaths.size();i++){
				obj[i][0] = learnPaths.get(i);
				obj[i][1] = entityCodes.get(i);
			}
			stmt.close();
			conn.commit();
			return obj;
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
			System.out.println("Goodbye!");
		}//end finally
		
		return obj;
	}
	
	public static Object[][] getLearnParamsForReRun() throws IOException{
		Object[][] obj = null;
		Connection conn = getDbConnection("ConceptsVideoData.db");
		Statement stmt = null;
		ArrayList<String> learnPaths = new ArrayList<String>();
		ArrayList<String> entityCodes = new ArrayList<String>();
		try{
			// Execute a query
			conn.setAutoCommit(false);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			
			String sql = "select `learn_path`,`entity_code`,`video_count` from `LearnConcept` where `video_count`=\"\";";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
					learnPaths.add(rs.getString("learn_path"));
					entityCodes.add(rs.getString("entity_code"));
			}
			obj = new Object[learnPaths.size()][2];
			for(int i=0;i<learnPaths.size();i++){
				obj[i][0] = learnPaths.get(i);
				obj[i][1] = entityCodes.get(i);
			}
			System.out.println(learnPaths.size());
			stmt.close();
			conn.commit();
			return obj;
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
			System.out.println("Goodbye!");
		}//end finally
		
		return obj;
	}
	
	public static Object[][] getLearnParamsForZeroVideoCount() throws IOException{
		Object[][] obj = null;
		Connection conn = getDbConnection("ConceptsVideoData.db");
		Statement stmt = null;
		ArrayList<String> learnPaths = new ArrayList<String>();
		ArrayList<String> entityCodes = new ArrayList<String>();
		try{
			// Execute a query
			conn.setAutoCommit(false);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			
			String sql = "select `learn_path`,`entity_code`,`video_count` from `LearnConcept` where `video_count`=\"0\";";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
					learnPaths.add(rs.getString("learn_path"));
					entityCodes.add(rs.getString("entity_code"));
			}
			obj = new Object[learnPaths.size()][2];
			for(int i=0;i<learnPaths.size();i++){
				obj[i][0] = learnPaths.get(i);
				obj[i][1] = entityCodes.get(i);
			}
			System.out.println(learnPaths.size());
			stmt.close();
			conn.commit();
			return obj;
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
			System.out.println("Goodbye!");
		}//end finally
		
		return obj;
	}
	
	public static void updateLearnVideoCount(String learn_path, String entity_code, String count) throws IOException{
		Connection conn = getDbConnection("ConceptsVideoData.db");
		Statement stmt = null;
		try{
			// Execute a query
			conn.setAutoCommit(false);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			
			String sql = "update `LearnConcept` set `video_count`=\""+count+"\" where `learn_path`=\""+learn_path+"\""
					+ " and `entity_code`=\""+entity_code+"\";";
			stmt.executeUpdate(sql);
			
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
			System.out.println("Goodbye!");
		}//end finally
		
	}
	
	public static ArrayList<String> storeSegmentIoResultsToDb(ArrayList<LinkedHashMap<String, String>> results) throws ClassNotFoundException, IOException
	{
		Connection conn = getDbConnection();
		Statement stmt = null;
		ArrayList<String> msgIds = new ArrayList<String>();
		try{
			// Execute a query
			conn.setAutoCommit(false);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			boolean flag = false;
			System.out.println("Storing Segment.io results to db");
			String columns = "";
			String values = "";
			for(LinkedHashMap<String, String> lhm:results){
				int i=0;
				msgIds.add(lhm.get("messageId"));
				flag = false;
				for(Map.Entry<String, String> m:lhm.entrySet()){
						
					if(i==0 && !m.getValue().equals(null) && !m.getValue().equals("null") && !m.getValue().equals("")){
						flag = true;
						columns = "`"+m.getKey()+"`";
						values = "\""+m.getValue()+"\"";
						i++;
					}
					else if(!m.getValue().equals(null) && !m.getValue().equals("null") && !m.getValue().equals("")){
						flag = true;
						columns = columns+",`"+m.getKey()+"`";
						values = values + ",\""+m.getValue()+"\"";
						i++;
					}
				}
				String query = "INSERT INTO `SegmentIoData`("+columns+") VALUES ("+values+");";
				System.out.println(query);
				if(flag)
					stmt.executeUpdate(query);
			}

			System.out.println("Storing Segment.io results to db, SUCCESS");
			
			stmt.close();
			conn.commit();
			return msgIds;
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
			System.out.println("Goodbye!");
		}//end finally
		
		return msgIds;

	}

}
