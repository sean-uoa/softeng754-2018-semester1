package nz.ac.auckland.se754sem2018.mycash;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.mongodb.client.MongoClient;
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

}
