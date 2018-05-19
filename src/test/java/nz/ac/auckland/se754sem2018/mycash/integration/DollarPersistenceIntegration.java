package nz.ac.auckland.se754sem2018.mycash.integration;

import static org.junit.Assert.*;

import org.bson.Document;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import nz.ac.auckland.se754sem2018.mycash.Dollar;

public class DollarPersistenceIntegration {

	@Test
	public void shouldConnectToMongoDBServer() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase database = mongoClient.getDatabase("my-cash-db");
		System.out.println(database.getName());
		
//		database.createCollection("customers");
		MongoCollection<Document> collection = database.getCollection("my-cash-collection");
		Document document = new Document();
		document.put("name", (new Dollar(5)).toString());
		document.put("company", "UoA");
		collection.insertOne(document);
		
		MongoCursor<Document> cursor = collection.find().iterator();
		while(cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}

}
