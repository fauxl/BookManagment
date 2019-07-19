package BookPackage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StatisticheLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// OrdersModelDS usa il DataSource
	// OrdersModelDM usa il DriverManager	
	static boolean isDataSource = true;


	public StatisticheLibri() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.removeAttribute("parameters");
		request.removeAttribute("parameters2");
		request.removeAttribute("parameters3");
		request.removeAttribute("parametersw");
		request.removeAttribute("maxmin");



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
		
		request.setAttribute("parameters", FAggregate.doRetrieveDocs(autore,lingua,annoi,annof,votoi,votof));
		request.setAttribute("parameters2", FAggregate.doRetrieveDocs2(autore,lingua,annoi,annof,votoi,votof));
		request.setAttribute("parameters3", FAggregate.doRetrieveDocs3(autore,lingua,annoi,annof,votoi,votof));
		request.setAttribute("parametersw", FAggregate.doRetrieveWishlist(autore,lingua,annoi,annof,votoi,votof));
		request.setAttribute("maxmin", FAggregate.doRetrieveMaxMin(autore,lingua,annoi,annof,votoi,votof));
		request.setAttribute("nvoti", FAggregate.doRetrieveRates(autore,lingua,annoi,annof,votoi,votof));





		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/statistica.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}