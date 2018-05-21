package moolya.embibe.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
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
		dbIp = JavaUtils.getPropValue("mDbIp");
		dbPort = JavaUtils.getPropValue("mDbPort");
		dbName = JavaUtils.getPropValue("mDbName");
		dbUserName = JavaUtils.getPropValue("mDbUserName");
		dbPassword =JavaUtils.getPropValue("mDbPassword");
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

	public static String get(String phone) throws IOException{
		String otp = null;
		MongoClient conn = getDbConnection();

		// Now connect to your databases
		db = conn.getDatabase(uri.getDatabase());
		MongoCollection<Document> otpCollection = db.getCollection("");
		Document findQuery = new Document("", phone);
		MongoCursor<Document> it = otpCollection.find(findQuery).sort(new BasicDBObject("_id", -1)).limit(1).iterator();
		Document doc = it.next();
		otp = (String) doc.get("");
		it.close();


		closeConnection(conn);
		return otp;
	}

	public static void delete(String phone) throws IOException{
		String uuid = null;
		MongoClient conn = getDbConnection();

		// Now connect to your databases
		db = conn.getDatabase(uri.getDatabase());
		MongoCollection<Document> userDetailsCollection = db.getCollection("");
		Document findQuery = new Document("", phone);
		MongoCursor<Document> it = userDetailsCollection.find(findQuery).iterator();
		Document doc = it.next();
		uuid = (String) doc.get("");
		it.close();

		MongoCollection<Document> orderDetailsCollection = db.getCollection("");
		findQuery = new Document("", uuid);
		orderDetailsCollection.deleteMany(findQuery);

		closeConnection(conn);
	}
}
