<%@page import="java.util.Iterator"%>
<%@page import="BookPackage.*"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
	Collection<?> libri = (Collection<?>) request.getAttribute("libri");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookManagment</title>
<meta charset="UTF-8">
<link rel='stylesheet' type='text/css' href='style.css' />
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
<script>
	function updateSliderMax(slideAmount) {
		var sliderDiv = document.getElementById("sliderAmountMax");
		sliderDiv.innerHTML = "Valore selezionato: " + slideAmount;
	}

	function updateSliderMin(slideAmount) {
		var sliderDiv = document.getElementById("sliderAmountMin");
		sliderDiv.innerHTML = "Valore selezionato: " + slideAmount;
	}
	
</script>

</head>
<body>
	<div class="back3" id="back">
		<div class="books" id="books3">

			<div id="topBar">
				<div id="containerLogo">
					<h1 title="Ritorna alla home">
						<a href="http://localhost:8080/BookManagment/home.jsp">Book
							Management</a>
					</h1>
				</div>
			</div>
			<div id="scelta">
			<a href="http://localhost:8080/BookManagment/ricerca"><button id="choose">Gestisci libri</button></a>
			<a href="http://localhost:8080/BookManagment/statistica"><button id="choose">Visulizza statistiche</button></a>
			</div>
<h3 id="copyright">Copyright © 2019 by Gerardo De Rosa &amp;
			Gianluca Annunziata</h3>		</div>
		</div>
</body>
</html>