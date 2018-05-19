package nz.ac.auckland.se754sem2018.mycash;

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
}
