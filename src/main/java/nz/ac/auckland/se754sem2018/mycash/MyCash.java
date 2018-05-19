package nz.ac.auckland.se754sem2018.mycash;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MyCash {
	
	MongoClient mongoClient;
	MongoDatabase mongoDatabase;
	
	public MyCash(MongoClient mongoClient, String myCashDatabaseName) {
		this.mongoClient = mongoClient;
		this.mongoDatabase = this.mongoClient.getDatabase(myCashDatabaseName);
	}
	
	public boolean isMongoDBClientNull() {
		return this.mongoClient == null;
	}
	
	public String getDBName() {
		return this.mongoDatabase.getName();
	}
	
	public void save(Dollar dollar) {
		Document document = new Document();
		document.put("NZD", dollar);
		this.mongoDatabase.getCollection("my-cash-collection").insertOne(document);
	}
}
