package BookPackage;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.*;
import com.mongodb.client.MongoDatabase;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.bson.Document;
import org.bson.conversions.Bson;

public class DeleteBook {
	public static void delete(String id) {
		
MongoClient mongo = new MongoClient("localhost",27017);
		
		MongoCredential credential;
		credential = MongoCredential.createCredential("fauxl", "books", "4131771ab".toCharArray());
		System.out.println("Connected to the database successfully");
		
		MongoDatabase database =  mongo.getDatabase("books");
		
		MongoCollection<Document> collection = database.getCollection("book");
		System.out.println("Collection book selected successfully");
				
    
		collection.deleteOne(Filters.eq("work_id", id));
		System.out.println("Document deleted succesfully");

		}
	}
	
	
