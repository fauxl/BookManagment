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
	<div class="back" id="back">
		<div class="books" id="books">

			<div id="topBar">
				<div id="containerLogo">
					<h1 title="Ritorna alla home" id="search">
						<a href="http://localhost:8080/BookManagment/home.jsp" >Book
							Management</a>
					</h1>
				</div>
			</div>
		
			<div id="ricerca">
			<div id="parameters">

				<form action="ricerca" method="post">
					<div id="research">
						<h2>Seleziona i parametri con cui effettuare la ricerca</h2>
						<input name="searchbart" id="searchBoxTitle"
							placeholder="Ricerca per Titolo..."> <i
							class="fas fa-search" id="iconCerca"></i> <input 
							name="searchbara" class="searchBoxAuthor"
							placeholder="Ricerca per Autore..."> <i
							class="fas fa-search" id="iconCerca2"></i>
					</div>
					<div id="sliders">
						<div id="sliderMax">
							Seleziona una votazione massima<br> 0<input name="votomax"id="slide"
								type="range" min="0" max="5" step="0.10" value=5
								onchange="updateSliderMax(this.value)">5<br> <span
								id="sliderAmountMax">Valore selezionato: 5</span>
						</div>
						<div id="sliderMin">
							Seleziona una votazione minima<br> 0<input name="votomin" id="slide"
								type="range" min="0" max="5" step="0.10" value=3
								onchange="updateSliderMin(this.value)">5<br> <span
								id="sliderAmountMin">Valore selezionato: 3</span>
						</div>
					</div>

					<div id="yeardrop">
						Seleziona l'anno di inizio ricerca<br> <select name="annoi" class="selectElementId"
							id="selectElementId"  placeholder="Seleziona Anno">
							<option selected disabled>Anni</option>


						</select><br> Seleziona l'anno di fine ricerca<br> <select name="annof"
						class="selectElementId"
							id="selectElementId2"  placeholder="Seleziona Anno">

							<option selected disabled>Anni</option>
						</select>

					</div>
					<div id="langdrop">
						Seleziona la lingua<br> <select name="lingua" id="selectElementId" class="selectElementId"
							value="2017" placeholder="Seleziona Anno">
							<option selected disabled>Lingue</option>
							<option>ara</option>
							<option>dan</option>
							<option>eng</option>
							<option>fil</option>
							<option>fre</option>
							<option>ger</option>
							<option>ind</option>
							<option>ita</option>
							<option>nor</option>
							<option>pol</option>
							<option>por</option>
							<option>spa</option>
							
						</select><br>
						<div id="isbn">
							Seleziona l'ISBN<br> <input name="searchbari" 
								id="searchBoxIsbn" placeholder="Ricerca per Isbn..."> <i
								class="fas fa-search" id="iconCerca3"></i>
						</div>
					</div>
<div id="order">
<div id="orderby">Visualizza in ordine: <input type="radio" name="orderby" value="1" > Crescente 
					<input type="radio" name="orderby" value="-1" checked="checked"> Decrescente<br> </div>

Ordina per: <input type="radio" name="order" value="count"> Numero di libri disponibili
		<input type="radio" name="order" value="year"> Anno di uscita
			<input type="radio" name="order" value="vote" checked="checked"> Voto Medio

</div>
					<div id="inviodati">
						<button id="invio">Clicca per effettuare la ricerca</button>

					</div>
				</form>
			</div>

			<div id="risultati">
				<h3>Risultati della ricerca</h3>
				<%
				int i =0;
					if (libri != null && libri.size() != 0) {
						Iterator<?> it = libri.iterator();
						while (it.hasNext()) {
							Book bean = (Book) it.next();
				%>

				<div id="row">
					<img src="<%=bean.getImgurl()%>">
					<div id="dettagliLibri">
						<span id="inGrassetto">Titolo: </span>
						<%=bean.getTitle()%>
						<br> <span id="inGrassetto">Autore: </span>
						<%=bean.getAuthors()%>
						<br> <span id="inGrassetto">Anno: </span>
						<%=bean.getYear()%>
						<br> <span id="inGrassetto">Lingua: </span>
						<%=bean.getLanguage()%>
						<br> <span id="inGrassetto">Voto: </span>
						<%=bean.getRate()%>
						<br> <span id="inGrassetto">Isbn: </span>
						<%=bean.getIsbn()%>
						<br> <span id="inGrassetto">Copie Disponibili: </span>
						<%=bean.getNbooks()%>
						
<div id="myModal" class="modal">
						<div id="dettagli">
							<div id="barraSuperiore">
								<span id="closeinsert" class="close" onclick="chiudi()"><i
									class="fas fa-times" style="margin: auto;"></i></span>
								<h3>Modifica le informazioni del libro</h3>	
			

				<div id="row">				
		
					<div id="dettagliinserimento">
						<form action="ricerca?action=modify&id=<%=bean.getId()%>" method="post">
								<label id="inGrassetto">Link immagine: </label>
							<input name="img"  value="<%=bean.getImgurl()%>" type="text" maxlength="200" required>
						<br> <label id="inGrassetto">Titolo: </label>
							<input name="title" value="<%=bean.getTitle()%>" type="text" maxlength="100" required>
						<br> <label id="inGrassetto"> Autore: </label>
							<input name="author" value="<%=bean.getAuthors()%>"type="text" maxlength="50" required>
						<br> <label id="inGrassetto">Anno: </label>
							<input name="year" value="<%=bean.getYear()%>" type="text" maxlength="20" required>
						<br> <label id="inGrassetto">Lingua: </label>
							<input name="lang" value="<%=bean.getLanguage()%>" type="text" maxlength="3" required>
						<br> <label id="inGrassetto">Voto: </label>
							<input name="vote" value="<%=bean.getRate()%>" type="text" maxlength="5" required>
						<br> <label id="inGrassetto">Isbn: </label>
							<input name="isbn" value="<%=bean.getIsbn()%>"type="text" maxlength="12" required>
						<br> <label id="inGrassetto">Copie Disponibili: </label>
							<input name="nbooks" value="<%=bean.getNbooks()%>" type="text" maxlength="5" required>
							
							<p id="send2">
						<input type="submit" name="submit" value="Conferma modifiche">
					</p>
						</form>
							</div>
							<br>

				</div>
					</div>
						
						</div>
					</div>
							
<a href="ricerca?action=delete&id=<%=bean.getId()%>">
<span id="close" class="close" onclick="chiudi()" title="Elimina questo libro">
<i class="fas fa-trash-alt" style="margin-auto"></i></span></a>
									
				<span id="modify" class="modify" title="Modifica questo libro" onclick="mine(<%=i%>)"><i class="fas fa-pencil-alt"></i></span>

					</div>


					<br>
					<%
						i++;}
						}
					%>
					
							
				</div>
							<div id="add" class="add" onclick="insert()" title="Aggiungi un nuovo libro"><i class="fas fa-plus-circle"></i></div>
			
				<div id="myModal2" class="modal">
						<div id="dettagli">
							<div id="barraSuperiore">
								<span id="closeinsert" class="close" onclick="chiudi()"><i
									class="fas fa-times" style="margin: auto;"></i></span>
								<h3>Inserisci un nuovo libro</h3>	
			

				<div id="row">				
		
					<div id="dettagliinserimento">
						<form action="ricerca?action=insert" method="post">
											<label id="inGrassetto">Link immagine: </label>
							<input name="img"  type="text" maxlength="200" required>
						<br> <label id="inGrassetto">Titolo: </label>
							<input name="title"  type="text" maxlength="100" required>
						<br> <label id="inGrassetto"> Autore: </label>
							<input name="author" type="text" maxlength="50" required>
						<br> <label id="inGrassetto">Anno: </label>
							<input name="year"  type="text" maxlength="20" required>
						<br> <label id="inGrassetto">Lingua: </label>
							<input name="lang"  type="text" maxlength="3" required>
						<br> <label id="inGrassetto">Voto: </label>
							<input name="vote" type="text" maxlength="5" required>
						<br> <label id="inGrassetto">Isbn: </label>
							<input name="isbn" type="text" maxlength="12" required>
						<br> <label id="inGrassetto">Copie Disponibili: </label>
							<input name="nbooks"  type="text" maxlength="5" required>
							
							<p id="send2">
						<input type="submit" name="submit" value="Conferma modifiche">
					</p>

						</form>
							</div>
							<br>

				</div>
					</div>
						
						</div>
					</div>
					</div>
					<h3 id="copyright">Copyright © 2019 by Gerardo De Rosa &amp;
			Gianluca Annunziata</h3>
			</div>
	
		</div>
	</div>

	<script>

		var min = 1273, max = 2017, select = document
				.getElementById('selectElementId'), select2 = document
				.getElementById('selectElementId2');
		

		for (var i = min; i <= max; i++) {
			var opt = document.createElement('option');
			opt.value = i;
			opt.innerHTML = i;
			select.appendChild(opt)

		}
		
		for (var i = min; i <= max; i++) {
			var opt = document.createElement('option');
			opt.value = i;
			opt.innerHTML = i;
			select2.appendChild(opt)

		}
	
		select.value = new Date().getFullYear();
		select2.value = new Date().getFullYear();

	</script>
	
	
	<script>
		
// Get the modal
var modal = document.querySelectorAll("[id='myModal']");

var modal2 = document.getElementById("myModal2");

function mine(x) {
	  modal[x].style.display = "block";
	}
function insert(){
	  modal2.style.display = "block";
	}
		
	
window.onclick = function(event) {
	for (i = 0; i < modal.length; i++) {
		if (event.target == modal[i]) {
		    modal[i].style.display = "none";
		  }		}
	if (event.target == modal2){
	    modal2.style.display = "none";
	  }	}
	  

function chiudi(){    
	for (i = 0; i < modal.length; i++) {
		    modal[i].style.display = "none";
		  	}

		    modal2.style.display = "none";
		 		}

	</script>
	
</body>
</html>