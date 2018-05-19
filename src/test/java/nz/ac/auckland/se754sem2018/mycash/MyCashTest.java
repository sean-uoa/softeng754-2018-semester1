package nz.ac.auckland.se754sem2018.mycash;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MyCashTest {

	@Test
	public void shouldInitializeMongoDBClientWhenCreatingMyCash() {
		// Given
		MongoClient mongoClient = Mockito.mock(MongoClient.class);
		
		// When
		MyCash myCash = new MyCash(mongoClient);
		
		// Then
		assertFalse(myCash.isMongoDBClientNull());
	}
	
	@Test
	public void shouldHaveDatabaseWithANameAfterCreatingMyCash() {
		
		// Given
		MongoClient mongoClient = Mockito.mock(MongoClient.class);
		MongoDatabase mongoDatabase =  Mockito.mock(MongoDatabase.class);
		Mockito.doReturn("my-cash-db").when(mongoDatabase).getName();
		Mockito.doReturn(mongoDatabase).when(mongoClient).getDatabase("my-cash-db");
		
		// When
		MyCash myCash = new MyCash(mongoClient);
		String dbName = myCash.getDBName();
		
		// Then
		assertEquals("my-cash-db", dbName);
	}

}
