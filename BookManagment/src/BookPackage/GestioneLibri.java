package BookPackage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GestioneLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// OrdersModelDS usa il DataSource
	// OrdersModelDM usa il DriverManager	
	static boolean isDataSource = true;


	public GestioneLibri() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.removeAttribute("libri");
		String titolo = request.getParameter("searchbart");
		String autore = request.getParameter("searchbara");
		String isbn = request.getParameter("searchbari");
		String lingua = request.getParameter("lingua");
		String annoi = request.getParameter("annoi");
		String annof = request.getParameter("annof");
		String votoi = request.getParameter("votomin");
		String ordine = request.getParameter("order");
		String cordine = request.getParameter("orderby");
		String votof = request.getParameter("votomax");

//System.out.println(titolo + autore + isbn + lingua + annoi + annof + votoi+ votof);
//System.out.println(ordine+cordine);

		request.setAttribute("libri", GetBooks.doRetrieveBook(titolo,autore,isbn,lingua,annoi,annof,votoi,votof,ordine,cordine));
		
		String action = request.getParameter("action");
		if (action != null) {

		if(action.equalsIgnoreCase("delete")) {
			String id = request.getParameter("id");
			
			DeleteBook.delete(id);

		} else if (action.equalsIgnoreCase("modify")) {
			String id = request.getParameter("id");
			titolo = request.getParameter("title");
			autore = request.getParameter("author");
			isbn = request.getParameter("isbn");
			lingua = request.getParameter("lang");
			String anno = request.getParameter("year");
			String count = request.getParameter("nbooks");
			String img = request.getParameter("img");
			String voto = request.getParameter("vote");
			
			UpdateBook.modify(id, titolo, autore, isbn, lingua, anno, count, img, voto);

		}else if(action.equalsIgnoreCase("insert")) {

			titolo = request.getParameter("title");
			autore = request.getParameter("author");
			isbn = request.getParameter("isbn");
			lingua = request.getParameter("lang");
			String anno = request.getParameter("year");
			String count = request.getParameter("nbooks");
			String img = request.getParameter("img");
			String voto = request.getParameter("vote");
			
			InsertBook.insert(titolo, autore, isbn, lingua, anno, count, img, voto);

		} 
		
		
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ricerca.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}