package BookPackage;
import java.net.UnknownHostException;

import org.bson.Document;

import com.mongodb.*;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class BookHeart {

	public static void main(String args[]) throws UnknownHostException {
		
		MongoClient mongo = new MongoClient("localhost",27017);
		
		MongoCredential credential;
		credential = MongoCredential.createCredential("fauxl", "book", "4131771ab".toCharArray());
		System.out.println("Connected to the database successfully");
		

		MongoDatabase database =  mongo.getDatabase("books");
		
		MongoCollection<Document> collection = database.getCollection("book");
		System.out.println("Collection book selected successfully");
		
		collection.createIndex(Filters.eq("title", "text"));
	//	collection.createIndex(Filters.eq("authors", "text"));

		
		
	}

}
