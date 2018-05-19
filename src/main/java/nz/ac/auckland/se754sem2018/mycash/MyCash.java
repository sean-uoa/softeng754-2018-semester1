package nz.ac.auckland.se754sem2018.mycash;

import com.mongodb.client.MongoClient;

public class MyCash {
	
	MongoClient mongoClient;

	public MyCash(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}
	
	public boolean isMongoDBClientNull() {
		return this.mongoClient == null;
	}
}
