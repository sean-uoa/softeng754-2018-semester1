package nz.ac.auckland.se754sem2018.mycash;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.mongodb.client.MongoClient;

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

}
