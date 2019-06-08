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

public class GetBooks {
	public static Collection<Book> doRetrieveBook(String titolo,String autore,String isbn, String lingua, String annoi, String annof, String votoi
			,String votof, String ordine, String cordine) {
		
MongoClient mongo = new MongoClient("localhost",27017);
		
		MongoCredential credential;
		credential = MongoCredential.createCredential("fauxl", "books", "4131771ab".toCharArray());
		System.out.println("Connected to the database successfully");
		
		MongoDatabase database =  mongo.getDatabase("books");
		
		MongoCollection<Document> collection = database.getCollection("book");
		System.out.println("Collection book selected successfully");
		
		FindIterable<Document> iterDoc = collection.find();
	
		if(annoi==null) {
			annoi="2016";
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
		
		if(cordine==null) {
			cordine="1";
		}
		
		if(ordine==null) {
			ordine="vote";
		}
		
		Bson bsonFilter2 = Filters.gte("original_publication_year",annoi);
		System.out.print(annof+annoi);
		Bson bsonFilter3 = Filters.lte("original_publication_year",annof);
		Bson bsonFilter4 = Filters.gte("average_rating",votoi);
		Bson bsonFilter5 = Filters.lte("average_rating",votof);
		Bson bsonFilter6 = Filters.eq("authors",autore);
		Bson bsonFilter7 = Filters.eq("isbn13",isbn);
		Bson bsonFilter8 = Filters.eq("language_code",lingua);
		Bson bsonFilter9 = Filters.text(" ");
		Bson bsonFilterorder1 = Filters.eq("average_rating",Integer.parseInt(cordine));
		Bson bsonFilterorder2 = Filters.eq("books_count",Integer.parseInt(cordine));
		Bson bsonFilterorder3 = Filters.eq("original_publication_year",Integer.parseInt(cordine));

		Bson bsonFilterorder = bsonFilterorder1;

		if(ordine.equalsIgnoreCase("count")) {
			bsonFilterorder = bsonFilterorder2;

		}else if(ordine.equalsIgnoreCase("year")) {
			bsonFilterorder = bsonFilterorder3;

		}else if(ordine.equalsIgnoreCase("vote")) {
			bsonFilterorder = bsonFilterorder1;

		}
		
		Bson bsonFilter = 	Filters.and(bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5);

		if(titolo!=""&&autore!=""&&isbn!=""&&lingua!=null) {
			bsonFilter = Filters.and(bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5,bsonFilter6,bsonFilter7,bsonFilter8,bsonFilter9);	
		}else if(titolo!=""&&autore!=""&&isbn!=""){
			bsonFilter = Filters.and(bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5,bsonFilter6,bsonFilter7,bsonFilter9);			
		}else if(titolo!=""&&autore!=""&&lingua!=null){
			bsonFilter = Filters.and(bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5,bsonFilter6,bsonFilter8,bsonFilter9);		
		}else if(titolo!=""&&isbn!=""&&lingua!=null){
			bsonFilter = Filters.and(bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5,bsonFilter7,bsonFilter8,bsonFilter9);		
		}else if(autore!=""&&isbn!=""&&lingua!=null){
			bsonFilter = Filters.and(bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5,bsonFilter6,bsonFilter7,bsonFilter8);
		}else if(titolo!=""&&lingua!=null){
			bsonFilter = Filters.and(bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5,bsonFilter8,bsonFilter9);	
		}else if(autore!=""&&lingua!=null){
			bsonFilter = Filters.and(bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5,bsonFilter6,bsonFilter8);	
		}else if(isbn!=""&&lingua!=null){
			bsonFilter = Filters.and(bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5,bsonFilter7,bsonFilter8);	
		}else if(titolo!=""&&autore!=""){
			bsonFilter = Filters.and(bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5,bsonFilter6,bsonFilter9);		
		}else if(titolo!=""&&isbn!=""){
			bsonFilter = Filters.and(bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5,bsonFilter7,bsonFilter9);		
		}else if(autore!=""&&isbn!=""){
			bsonFilter = Filters.and(bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5,bsonFilter6,bsonFilter7);		
		}else if(titolo!=""){
			bsonFilter = Filters.and(bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5,bsonFilter9);	
		}else if(autore!=""){
			 bsonFilter = Filters.and(bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5,bsonFilter6);	
		}else if(isbn!=""){
			bsonFilter = Filters.and(bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5,bsonFilter7);
		}else if(lingua!=null){
			bsonFilter = Filters.and(bsonFilter2,bsonFilter3,bsonFilter4,bsonFilter5,bsonFilter8);	
		}
		
		System.out.println(bsonFilter.toString());
		
		FindIterable<Document> findIt = collection.find(bsonFilter).sort(bsonFilterorder);
    
		Iterator it = findIt.iterator();
		Collection<Book> books =  new LinkedList<Book>();
		
		while(it.hasNext()) {
			Book libro = new Book();

		    Document str = (Document) it.next();
		    
		    
		   // System.out.println(str.get("books_count").toString());

		    libro.setId(str.get("work_id").toString());
		    libro.setAuthors((String)str.get("authors"));
		    libro.setImgurl((String)str.get("image_url"));
		    libro.setIsbn((String)str.get("isbn13"));
		    libro.setLanguage((String) str.get("language_code"));
		    if(str.get("books_count")!=null) {
		    libro.setNbooks(Integer.parseInt(str.get("books_count").toString()));
		    }
		    if(str.get("average_rating")!=null) {
			libro.setRate(Float.parseFloat(str.get("average_rating").toString()));
		    }
		    libro.setTitle((String) str.get("title"));
		    if(str.get("original_publication_year")!=null) {
		    	libro.setYear(Integer.parseInt( str.get("original_publication_year").toString()));
		    }
		    
		    books.add(libro);
		}
		 System.out.println(books);

return books;

	}
	
	
}
