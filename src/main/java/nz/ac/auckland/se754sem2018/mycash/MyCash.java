package nz.ac.auckland.se754sem2018.mycash;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MyCash {
	
	MongoClient mongoClient;

	public MyCash(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}
	
	public boolean isMongoDBClientNull() {
		return this.mongoClient == null;
	}
	
	public String getDBName() {
		MongoDatabase mongoDB = this.mongoClient.getDatabase("my-cash-db");
		return mongoDB.getName();
	}
}
