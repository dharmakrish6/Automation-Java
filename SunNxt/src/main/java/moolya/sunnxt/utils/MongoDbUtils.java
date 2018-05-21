package moolya.sunnxt.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDbUtils {

	static String dbIp;
	static String dbPort;
	static String dbName;
	static String dbUserName;
	static String dbPassword;
	static MongoClientURI uri;
	static MongoClient client;
	static MongoDatabase db;

	@SuppressWarnings("resource")
	static MongoClient getDbConnection() throws IOException{
		dbIp = JavaUtils.getPropValue("dbIp");
		dbPort = JavaUtils.getPropValue("dbPort");
		dbName = JavaUtils.getPropValue("dbName");
		dbUserName = JavaUtils.getPropValue("dbUserName");
		dbPassword =JavaUtils.getPropValue("dbPassword");
		dbPassword = dbPassword.replaceAll("@", "%40");

		try{
			// To connect to mongodb server
			// Standard URI format: mongodb://[dbuser:dbpassword@]host:port/dbname

			uri  = new MongoClientURI("mongodb://"+dbUserName+":"+dbPassword+"@"+dbIp+":"+dbPort+"/"+dbName);
			client = new MongoClient(uri);

		}catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
		return client;
	}
	
	static void closeConnection(MongoClient conn){
		conn.close();
	}
	
	public static void showCollections() throws IOException{
		MongoClient conn = getDbConnection();
		db = conn.getDatabase(uri.getDatabase());
		MongoCursor<Document> it = db.listCollections().iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		closeConnection(conn);
	}
	
	public static String getOtp(String phone) throws IOException{
		String otp = null;
		MongoClient conn = getDbConnection();

		// Now connect to your databases
		db = conn.getDatabase(uri.getDatabase());
		MongoCollection<Document> otpCollection = db.getCollection("otpMobile");
		Document findQuery = new Document("phone", phone);
		MongoCursor<Document> it = otpCollection.find(findQuery).sort(new BasicDBObject("_id", -1)).limit(1).iterator();
		Document doc = it.next();
		otp = (String) doc.get("otp");
		it.close();
		
		
		closeConnection(conn);
		return otp;
	}
	
}
