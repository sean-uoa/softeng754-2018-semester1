package nz.ac.auckland.se754sem2018.mycash;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MyCashPersistence {
	
	MongoClient mongoClient;
	MongoDatabase mongoDatabase;
	MongoCollection<Document> mongoCollection;
	
	public MyCashPersistence(MongoClient mongoClient, 
			String myCashDatabaseName, String myCashCollectionName) {
		this.mongoClient = mongoClient;
		this.mongoDatabase = this.mongoClient.getDatabase(myCashDatabaseName);
		this.mongoCollection = this.mongoDatabase.getCollection(myCashCollectionName);
	}
	
	public boolean isMongoDBClientNull() {
		return this.mongoClient == null;
	}
	
	public String getDBName() {
		return this.mongoDatabase.getName();
	}
	
	public void saveNZD(Dollar dollar) {
		Document document = new Document();
		document.put("NZD", dollar);
		this.mongoCollection.insertOne(document);
	}
}
