package BookPackage;
import java.io.Serializable;

public class Book {
	private static final long serialVersionUID = 1L;

	String id;
	int nbooks;
	String isbn;
	String authors;
	int year;
	String title;
	String language;
	float rate;
	String imgurl;
	
	public Book() {
		id="";
		nbooks=0;
		isbn="";
		authors="";
		year=0;
		title="";
		language="";
		rate =0;
		imgurl="";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNbooks() {
		return nbooks;
	}

	public void setNbooks(int nbooks) {
		this.nbooks = nbooks;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imgurl == null) ? 0 : imgurl.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + nbooks;
		result = prime * result + Float.floatToIntBits(rate);
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", nbooks=" + nbooks + ", isbn=" + isbn + ", authors=" + authors + ", year=" + year
				+ ", title=" + title + ", language=" + language + ", rate=" + rate + ", imgurl=" + imgurl + "]";
	}

	


}


