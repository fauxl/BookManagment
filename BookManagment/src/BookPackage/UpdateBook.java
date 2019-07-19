package BookPackage;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.*;
import com.mongodb.operation.UpdateOperation;
import com.mongodb.client.MongoDatabase;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.bson.Document;
import org.bson.conversions.Bson;

public class UpdateBook {
	public static void modify(String id, String titolo,String autore,String isbn, String lingua, String anno, String count, String img
			,String voto) {
		
MongoClient mongo = new MongoClient("localhost",27017);
		
		MongoCredential credential;
		credential = MongoCredential.createCredential("fauxl", "books", "4131771ab".toCharArray());
		System.out.println("Connected to the database successfully");
		
		MongoDatabase database =  mongo.getDatabase("books");
		
		MongoCollection<Document> collection = database.getCollection("book");
		System.out.println("Collection book selected successfully");
	
    
		collection.updateOne(Filters.eq("work_id", id),  Updates.combine(Updates.set("isbn13", isbn),Updates.set("authors", autore),
				Updates.set("image_url", img),Updates.set("language_code", lingua),
				Updates.set("books_count", count), Updates.set("average_rating", voto), Updates.set("title", titolo), 
				Updates.set("original_publication_year", anno )));
		System.out.println("Document modified succesfully");

		}
	}
	
	
