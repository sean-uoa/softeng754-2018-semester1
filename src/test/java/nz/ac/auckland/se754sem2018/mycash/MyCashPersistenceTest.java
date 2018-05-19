package nz.ac.auckland.se754sem2018.mycash;

import static org.junit.Assert.*;

import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MyCashPersistenceTest {
	
	MongoClient mongoClient;
	String myCashDBName;
	String myCashCollectionName;
	MongoDatabase mongoDatabase;
	
	@Before
	public void setUp() {
		// Given
		mongoClient = Mockito.mock(MongoClient.class);
		myCashDBName = "my-cash-db";
		myCashCollectionName = "my-cash-collection";
		mongoDatabase =  Mockito.mock(MongoDatabase.class);
	}

	@Test
	public void shouldInitializeMongoDBClientWhenCreatingMyCash() {
		
		// Given
		Mockito.doReturn(mongoDatabase).when(mongoClient).getDatabase(myCashDBName);
		
		// When
		MyCashPersistence myCash = new MyCashPersistence(mongoClient, myCashDBName, myCashCollectionName);
		
		// Then
		assertFalse(myCash.isMongoDBClientNull());
	}
	
	@Test
	public void shouldHaveDatabaseWithANameAfterCreatingMyCash() {
		
		// Given
		Mockito.doReturn(myCashDBName).when(mongoDatabase).getName();
		Mockito.doReturn(mongoDatabase).when(mongoClient).getDatabase(myCashDBName);
		
		// When
		MyCashPersistence myCash = new MyCashPersistence(mongoClient, myCashDBName, myCashCollectionName);
		String dbName = myCash.getDBName();
		
		// Then
		assertEquals(myCashDBName, dbName);
	}
	
	@Test
	public void shouldInvodeTheDatabaseSaveMethodWhenSavingDollar() {
		// Given
		Mockito.doReturn(mongoDatabase).when(mongoClient).getDatabase(myCashDBName);
		
		MongoCollection<Document> collection = Mockito.mock(MongoCollection.class);
		Mockito.doReturn(collection).when(mongoDatabase).getCollection(myCashCollectionName);
		
		Dollar five = new Dollar(5);
		Document document = new Document();
		document.put("NZD", five);
		
		// When
		MyCashPersistence myCash = new MyCashPersistence(mongoClient, myCashDBName, myCashCollectionName);
		myCash.saveNZD(five);
		
		// Then
		Mockito.verify(collection, Mockito.times(1)).insertOne(document);
	}

}
