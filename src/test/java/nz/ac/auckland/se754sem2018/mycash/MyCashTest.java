package nz.ac.auckland.se754sem2018.mycash;

import static org.junit.Assert.*;

import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MyCashTest {
	
	MongoClient mongoClient;
	String myCashDBString;
	
	@Before
	public void setUp() {
		// Given
		mongoClient = Mockito.mock(MongoClient.class);
		myCashDBString = "my-cash-db";
	}

	@Test
	public void shouldInitializeMongoDBClientWhenCreatingMyCash() {
		
		// When
		MyCash myCash = new MyCash(mongoClient, myCashDBString);
		
		// Then
		assertFalse(myCash.isMongoDBClientNull());
	}
	
	@Test
	public void shouldHaveDatabaseWithANameAfterCreatingMyCash() {
		
		// Given
		MongoDatabase mongoDatabase =  Mockito.mock(MongoDatabase.class);
		Mockito.doReturn(myCashDBString).when(mongoDatabase).getName();
		Mockito.doReturn(mongoDatabase).when(mongoClient).getDatabase(myCashDBString);
		
		// When
		MyCash myCash = new MyCash(mongoClient, myCashDBString);
		String dbName = myCash.getDBName();
		
		// Then
		assertEquals(myCashDBString, dbName);
	}
	
	@Test
	public void shouldInvodeTheDatabaseSaveMethodWhenSavingDollar() {
		// Given
		MongoDatabase mongoDatabase =  Mockito.mock(MongoDatabase.class);
		Mockito.doReturn(mongoDatabase).when(mongoClient).getDatabase(myCashDBString);
		
		MongoCollection<Document> collection = Mockito.mock(MongoCollection.class);
		Mockito.doReturn(collection).when(mongoDatabase).getCollection("my-cash-collection");
		
		Dollar five = new Dollar(5);
		Document document = new Document();
		document.put("NZD", five);
		
		// When
		MyCash myCash = new MyCash(mongoClient, myCashDBString);
		myCash.save(five);
		
		// Then
		Mockito.verify(collection, Mockito.times(1)).insertOne(document);
	}

}
