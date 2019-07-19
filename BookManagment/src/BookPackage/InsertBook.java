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

public class InsertBook {
	public static void insert(String titolo,String autore,String isbn, String lingua, String anno, String count, String img
			,String voto) {
		
MongoClient mongo = new MongoClient("localhost",27017);
		
		MongoCredential credential;
		credential = MongoCredential.createCredential("fauxl", "books", "4131771ab".toCharArray());
		System.out.println("Connected to the database successfully");
		
		MongoDatabase database =  mongo.getDatabase("books");
		
		MongoCollection<Document> collection = database.getCollection("book");
		System.out.println("Collection book selected successfully");
	
		Document document = new Document("title","MongoDB")
		.append("work_id", "60585968")
		.append("isbn13", isbn)
		.append("books_count", count)
		.append("authors", autore)
		.append("image_url", img)
		.append("language_code", lingua)
		.append("average_rating", voto)
		.append("title", titolo)
		.append("original_publication_year", anno );


		collection.insertOne(document);
		System.out.println("Document inserted succesfully");

		}
	}
	
	
