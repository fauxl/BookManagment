package BookPackage;
import com.mongodb.*;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.ClientSession;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.*;
import com.mongodb.operation.AggregateOperation;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.bson.Document;
import org.bson.conversions.Bson;

public class FAggregate {
	
	
	
	public static Bson filters(String autore, String lingua, String annoi, String annof, String votoi
			,String votof){
		
		System.out.println(autore+lingua+annoi+annof+votoi+votof);
		if(annoi==null) {
			annoi="2016";
		}
		
		if(autore==null) {
			autore = "";
		}
		
		if(annof==null) {
			annof="2019";
		}
		
		if(votoi==null) {
			votoi="3";
		}
		
		if(votof==null) {
			votof="5";
		}
		

		Bson bsonFilter2 = Filters.gte("original_publication_year",annoi);
		Bson bsonFilter3 = Filters.lte("original_publication_year",annof);
		Bson bsonFilter4 = Filters.gte("average_rating",votoi);
		Bson bsonFilter5 = Filters.lte("average_rating",votof);
		Bson bsonFilter6 = Filters.eq("authors",autore);
		if (autore!=null) {
		bsonFilter6 = Filters.text(autore);}
		Bson bsonFilter8 = Filters.eq("language_code",lingua);

		Bson bsonFilter = 	Filters.and(bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5);

		if(autore!=""&&lingua!=null) {
			bsonFilter = Filters.and(bsonFilter6,bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5,bsonFilter8);	
		}else if(lingua!=null){
			bsonFilter = Filters.and(bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5,bsonFilter8);	
		}else if(autore!=""){
			bsonFilter = Filters.and(bsonFilter6,bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5);		
		}
		
		return bsonFilter;
		
		
		
	}
	
	public static Collection<Aggregate> doRetrieveDocs(String autore, String lingua, String annoi, String annof, String votoi
			,String votof) {
	
	MongoClient mongo = new MongoClient("localhost",27017);
	
	MongoCredential credential = MongoCredential.createCredential("fauxl", "books", "4131771ab".toCharArray());
	
	System.out.println("Connected to the database successfully");
	
	MongoDatabase database =  mongo.getDatabase("books");
	
	MongoCollection<Document> collection = database.getCollection("book");
	System.out.println("Collection book selected successfully");
	
	FindIterable<Document> iterDoc = collection.find();
	Bson filter = filters(autore, lingua, annoi, annof,votoi,votof);
	System.out.println(filter);
	AggregateIterable<Document> voti  = collection.aggregate(
		      Arrays.asList(
		    		 
			           Aggregates.match(filter),
		              Aggregates.group("$average_rating", Accumulators.sum("count", 1))
		             
		    		  )
		);	
	
	
	Iterator it = voti.iterator();
	Collection<Aggregate> docs=  new LinkedList<Aggregate>();
	
	
	while(it.hasNext()) {
		Aggregate doc = new Aggregate();

	    Document str = (Document) it.next();
		
		    if(str.get("_id")!=null && !str.get("_id").equals("") && !str.get("_id").equals("en-US") && !str.get("_id").equals("eng")) {
		    doc.setId((Float.parseFloat(str.get("_id").toString())));
		    }
		    
	    if(str.get("count")!=null) {
	    doc.setCount((Float.parseFloat(str.get("count").toString())));
	    }
	    docs.add(doc);

	    	}
	System.out.println(docs.toString());

	return docs;
	}	
	
	public static Collection<Aggregate> doRetrieveDocs2(String autore, String lingua, String annoi, String annof, String votoi
			,String votof) {
		
		MongoClient mongo = new MongoClient("localhost",27017);
		
		MongoCredential credential = MongoCredential.createCredential("fauxl", "books", "4131771ab".toCharArray());
		
		System.out.println("Connected to the database successfully");
		
		MongoDatabase database =  mongo.getDatabase("books");
		
		MongoCollection<Document> collection = database.getCollection("book");
		System.out.println("Collection book selected successfully");
		
		FindIterable<Document> iterDoc = collection.find();
		
		Bson filter = filters(autore, lingua, annoi, annof, votoi, votof);

		AggregateIterable<Document> tongue  = collection.aggregate(
			      Arrays.asList(
				            Aggregates.match(filter),
			              Aggregates.group("$language_code", Accumulators.sum("count", 1 ))
			    		  )
			);	
		

		Iterator it = tongue.iterator();
		Collection<Aggregate> docs=  new LinkedList<Aggregate>();

		
		while(it.hasNext()) {
			Aggregate doc = new Aggregate();

		    Document str = (Document) it.next();
			
		    if(str.get("max")!=null) {
		    doc.setMatched((Float.parseFloat(str.get("max").toString())));
		    }
		    
		    if(str.get("_id")!=null && !str.get("_id").equals("")) {
			    doc.setIds("\""+(str.get("_id").toString()+"\""));
			    }
			    
		    if(str.get("count")!=null) {
		    doc.setCount((Float.parseFloat(str.get("count").toString())));
		    }
		    docs.add(doc);

		    	}
		System.out.println(docs.toString());

		return docs;
		}
	
	public static Collection<Aggregate> doRetrieveDocs3(String autore, String lingua, String annoi, String annof, String votoi
			,String votof) {
		
		MongoClient mongo = new MongoClient("localhost",27017);
		
		MongoCredential credential = MongoCredential.createCredential("fauxl", "books", "4131771ab".toCharArray());
		
		System.out.println("Connected to the database successfully");
		
		MongoDatabase database =  mongo.getDatabase("books");
		
		MongoCollection<Document> collection = database.getCollection("book");
		System.out.println("Collection book selected successfully");
		
		FindIterable<Document> iterDoc = collection.find();
		
		Bson filter = filters(autore, lingua, annoi, annof, votoi, votof);

		
		AggregateIterable<Document> anni  = collection.aggregate(
			      Arrays.asList(
				            Aggregates.match(filter),
			              Aggregates.group("$original_publication_year", Accumulators.sum("count", 1))
			      )
			);	
		
		
		Iterator it = anni.iterator();
		Collection<Aggregate> docs=  new LinkedList<Aggregate>();
		
		
		while(it.hasNext()) {
			Aggregate doc = new Aggregate();

		    Document str = (Document) it.next();
			
			    if(str.get("_id")!=null && !str.get("_id").equals("")) {
			    doc.setId((Float.parseFloat(str.get("_id").toString())));
			    }
			    
		    if(str.get("count")!=null) {
		    doc.setCount((Float.parseFloat(str.get("count").toString())));
		    }
		    docs.add(doc);

		    	}
		System.out.println(docs.toString());

		return docs;
		}	

public static Collection<Aggregate> doRetrieveWishlist(String autore, String lingua, String annoi, String annof, String votoi
		,String votof) {
		
		MongoClient mongo = new MongoClient("localhost",27017);
		
		MongoCredential credential = MongoCredential.createCredential("fauxl", "books", "4131771ab".toCharArray());
		
		System.out.println("Connected to the database successfully");
		
		MongoDatabase database =  mongo.getDatabase("books");
		
		MongoCollection<Document> collection = database.getCollection("Wishlist");
		System.out.println("Collection book selected successfully");
		
		FindIterable<Document> iterDoc = collection.find();
		
		
		AggregateIterable<Document> anni  = collection.aggregate(
			      Arrays.asList(
			           Aggregates.group("$book_id", Accumulators.sum("count", 1))

			      )
			);	
		
		
		Iterator it = anni.iterator();
		Collection<Aggregate> docs=  new LinkedList<Aggregate>();
		
		
		while(it.hasNext()) {
			Aggregate doc = new Aggregate();

		    Document str = (Document) it.next();
			
			    if(str.get("_id")!=null && !str.get("_id").equals("")) {
			    doc.setId((Float.parseFloat(str.get("_id").toString())));
			    }
			    
		    if(str.get("count")!=null) {
		    doc.setCount((Float.parseFloat(str.get("count").toString())));
		    }
		    docs.add(doc);

		    	}
		System.out.println(docs.toString());

		return docs;
		}	

public static Collection<Aggregate> doRetrieveMaxMin(String autore, String lingua, String annoi, String annof, String votoi
		,String votof) {
	
	MongoClient mongo = new MongoClient("localhost",27017);
	
	MongoCredential credential = MongoCredential.createCredential("fauxl", "books", "4131771ab".toCharArray());
	
	System.out.println("Connected to the database successfully");
	
	MongoDatabase database =  mongo.getDatabase("books");
	
	MongoCollection<Document> collection = database.getCollection("book");
	System.out.println("Collection book selected successfully");
	
	FindIterable<Document> iterDoc = collection.find();
	
	Bson bsonFilter = Filters.eq("average_rating",1);

	Bson filter = filters(autore, lingua, annoi, annof, votoi, votof);

	
	AggregateIterable<Document> votes  = collection.aggregate(
		      Arrays.asList(
		             Aggregates.match(filter),
		    		  Aggregates.group(null,  Accumulators.max("max","$average_rating"), Accumulators.min("min","$average_rating"))
		      )
		);	
	

	AggregateIterable<Document> availabilities  = collection.aggregate(
		      Arrays.asList(
		             Aggregates.match(filter),
		    		  Aggregates.group(null,  Accumulators.max("max","$books_count"), Accumulators.min("min","$books_count"))
		      )
		);	
	

	AggregateIterable<Document> reviews  = collection.aggregate(
		      Arrays.asList(
		            Aggregates.match(filter),
		    		  Aggregates.group(null,  Accumulators.max("max","$text_reviews_count"), Accumulators.min("min","$text_reviews_count"))
		      )
		);	
	
	AggregateIterable<Document> ratings  = collection.aggregate(
		      Arrays.asList(
		            Aggregates.match(filter),
		    		  Aggregates.group(null,  Accumulators.max("max","$ratings_count"), Accumulators.min("min","$ratings_count"))
		      )
		);
	

	Collection<Document> docs =  new LinkedList<Document>();


    Document vote = (Document) votes.first();
    Document availability = (Document) availabilities .first();
    Document review = (Document) ratings.first();
    Document rating = (Document) reviews.first();
    docs.add(vote);
    docs.add(availability);
    docs.add(review);
    docs.add(rating);

	Iterator it = docs.iterator();
	Collection<Aggregate> documenti=  new LinkedList<Aggregate>();

	
	while(it.hasNext()) {
		Aggregate doc = new Aggregate();
		
	    Document str =  (Document) it.next();
		if(str!=null) {
		    if(str.get("_id")!=null && !str.get("_id").equals("")) {
		    doc.setId((Float.parseFloat(str.get("_id").toString())));
		    }
		    
	    if(str.get("max")!=null ) {
	    doc.setMax((Float.parseFloat(str.get("max").toString())));
	    }
	    
	    
	    if(str.get("min")!=null) {
	    doc.setMin((Float.parseFloat(str.get("min").toString())));
	    }
	    documenti.add(doc);

	    	}}
	//System.out.println(docs.toString());

	return documenti;
			
	}	

public static Collection<Aggregate> doRetrieveRates(String autore, String lingua, String annoi, String annof, String votoi
		,String votof) {
		
		MongoClient mongo = new MongoClient("localhost",27017);
		
		MongoCredential credential = MongoCredential.createCredential("fauxl", "books", "4131771ab".toCharArray());
		
		System.out.println("Connected to the database successfully");
		
		MongoDatabase database =  mongo.getDatabase("books");
		
		MongoCollection<Document> collection = database.getCollection("book");
		System.out.println("Collection book selected successfully");
		
		FindIterable<Document> iterDoc = collection.find();
		
		Bson filter = filters(autore, lingua, annoi, annof, votoi, votof);

		AggregateIterable<Document> nvoti = collection.aggregate(
			     Arrays.asList(
				            Aggregates.match(filter),

			           Aggregates.group("$book_id",
			        		   Accumulators.addToSet("text_reviews_count","$text_reviews_count"),
			        		   Accumulators.addToSet("ratings_count", "$ratings_count"))));	
		
		
		Iterator it = nvoti.iterator();
		Collection<Aggregate> docs=  new LinkedList<Aggregate>();

		
		while(it.hasNext()) {
			Aggregate doc = new Aggregate();

		    Document str = (Document) it.next();
			System.out.println(str);
			if(str!=null) {

			    if(str.get("_id")!=null && !str.get("_id").equals("")) {
			    doc.setIds(str.get("_id").toString());
			    }
			    
		    if(str.get("text_reviews_count")!=null && !str.get("text_reviews_count").toString().replace("[", "").replace("]", "").equals("null")) {
		    doc.setMax((Float.parseFloat(str.get("text_reviews_count").toString().replace("[", "").replace("]", ""))));
		    }
		    
		    if(str.get("ratings_count")!=null && !str.get("ratings_count").toString().replace("[", "").replace("]", "").equals("null")) {
		    	doc.setMin((Float.parseFloat(str.get("ratings_count").toString().replace("[", "").replace("]", ""))));
			    }
		    docs.add(doc);
			}
		    	}
		System.out.println(docs.toString());

		return docs;
		}	

}

