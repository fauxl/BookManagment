<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Array"%>
<%@page import="java.util.Iterator"%>
<%@page import="BookPackage.*"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
	Collection<?> parameters = (Collection<?>) request.getAttribute("parameters");
Collection<?> parameters2 = (Collection<?>) request.getAttribute("parameters2");
Collection<?> parameters3 = (Collection<?>) request.getAttribute("parameters3");
Collection<?> nvoti = (Collection<?>) request.getAttribute("nvoti");
Collection<?> parametersw = (Collection<?>) request.getAttribute("parametersw");
Collection<?> maxmin = (Collection<?>) request.getAttribute("maxmin");


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
			<script src="plotly-latest.min.js"></script>
               <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
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
	<div  id="back2">
		<div class="books" id="books2">

			<div id="topBar">
				<div id="containerLogo">
					<h1 title="Ritorna alla home">
						<a href="http://localhost:8080/BookManagment/home.jsp" >Book
							Management</a>
					</h1>
				</div>
			</div>
			<div id="parameters">

				<form action="statistica" method="post">
					<div id="research">
						<h2>Seleziona i parametri con i quali calcolare le statistiche:</h2>
						<input 
							name="searchbara" class="searchBoxAuthor" id="searchBoxAuthor"
							placeholder="Seleziona l' Autore..."> <i
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
						Seleziona l'anno di inizio ricerca<br> <select name="annoi" class="selectElementId2"
							id="selectElementId"  placeholder="Seleziona Anno">
							<option selected disabled>Anni</option>


						</select><br> Seleziona l'anno di fine ricerca<br> <select name="annof"
						class="selectElementId2"
							id="selectElementId2"  placeholder="Seleziona Anno">

							<option selected disabled>Anni</option>
						</select>

					</div>
					<div id="langdrop">
						Seleziona la lingua<br> <select name="lingua" class="selectElementId2"
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
						
					</div>
		<div id="inviodatistat">
						<button id="invio">Clicca per effettuare la ricerca</button>

					</div>
				</form>
			</div>
		<div id="statistics">
		
			<%
				ArrayList<Float> id = new ArrayList<Float>();
			ArrayList<Float> count = new ArrayList<Float>();

					if (parameters != null && parameters.size() != 0) {
						Iterator<?> it = parameters.iterator();
						while (it.hasNext()) {
							Aggregate bean = (Aggregate) it.next();
				%>
		<%id.add(bean.getId());%>
				<%count.add(bean.getCount());%>
		
		<%}} %>
		
			<%
				ArrayList<String> idis = new ArrayList<String>();
			ArrayList<Integer> countv = new ArrayList<Integer>();
			ArrayList<Integer> countt = new ArrayList<Integer>();

					if (nvoti != null && nvoti.size() != 0) {
						Iterator<?> it = nvoti.iterator();
						while (it.hasNext()) {
							Aggregate bean = (Aggregate) it.next();
				%>
		<%idis.add(bean.getIds());%>
				<%countv.add(Math.round(bean.getMax()));%>
								<%countt.add(Math.round(bean.getMin()));%>
				
		
		<%}} %>
		
			<%
				ArrayList<Float> idw = new ArrayList<Float>();
			ArrayList<Float> countw = new ArrayList<Float>();

					if (parametersw != null && parametersw.size() != 0) {
						Iterator<?> it = parametersw.iterator();
						while (it.hasNext()) {
							Aggregate bean = (Aggregate) it.next();
				%>
		<%idw.add(bean.getId());%>
				<%countw.add(bean.getCount());%>
		
		<%}} %>
		
		<%
				ArrayList<Float> id2 = new ArrayList<Float>();
			ArrayList<Float> count2 = new ArrayList<Float>();

					if (parameters3 != null && parameters3.size() != 0) {
						Iterator<?> it = parameters3.iterator();
						while (it.hasNext()) {
							Aggregate bean = (Aggregate) it.next();
				%>
		<%id2.add(bean.getId());%>
				<%count2.add(bean.getCount());%>
		
		<%}} %>
	
		<%
				ArrayList<String> idp = new ArrayList<String>();
			ArrayList<Float> countp = new ArrayList<Float>();

					if (parameters2 != null && parameters2.size() != 0) {
						Iterator<?> it = parameters2.iterator();
						while (it.hasNext()) {
							Aggregate bean = (Aggregate) it.next();
				%>
		<%idp.add(bean.getIds());%>
				<%countp.add(bean.getCount());%>
		
		<%}} %>


<h2>Ricerca Massimi e Minimi con Parametri</h2>

		<%		if (maxmin != null && maxmin.size() != 0) {
						Iterator<?> it = maxmin.iterator();
							Aggregate mami = (Aggregate) it.next(); %>
<div id="dispon">
Massimo voto medio per i parametri selezionati:
 <span id="result"><%=mami.getMax()%><br></span>
Minimo voto medio per i parametri selezionati:
 <span id="result"><%=mami.getMin()%><br></span><br>
 
 <% mami = (Aggregate) it.next(); %>
Massima disponibilità di libri per i parametri selezionati:
 <span id="result"><%=Math.round(mami.getMax())%><br></span>
Minima disponibilità di libri  per i parametri selezionati:
 <span id="result"><%=Math.round(mami.getMin())%><br></span><br>
  <%mami = (Aggregate) it.next(); %>
 
Massimo numero di recensioni ricevute per i parametri selezionati:
 <span id="result"><%=Math.round(mami.getMax())%><br></span>
Minimo numero di recensioni ricevute per i parametri selezionati:
 <span id="result"><%=Math.round(mami.getMin())%><br></span><br>
  <% mami = (Aggregate) it.next(); %>
 
Massimo numero di voti ricevuti per i parametri selezionati:
 <span id="result"><%=Math.round(mami.getMax())%><br></span>
Minimo numero di voti ricevuti per i parametri selezionati:
 <span id="result"><%=Math.round(mami.getMin())%><br></span>

</div>
			<%}%>
		
	
<h2>Votazione Media per Quantità</h2>
	
<div id="rates" style="width:100%;height:400px;">
</div>

<h2>Libri usciti per Anno</h2>

<div id="years" style="width:100%;height:400px;">

</div>
	<h2>Percentuali ligua per libri</h2>
	
<div id="pie" style="width:100%;height:400px;">
</div>

	<h2>Voti e Recensioni ricevute per Libro</h2>
	
<div id="nvoti" style="width:100%;height:800px;">
</div>
		
			<h2>Libri presenti in Wishlist</h2>
	
<div id="wish" style="width:100%';height:400px;">
</div>

		
		</div>
		
		<h3 id="copyright">Copyright © 2019 by Gerardo De Rosa &amp;
			Gianluca Annunziata</h3>
		
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

	var data = [
		  {
		    x: <%=id%>,
		    y: <%=count%>,
		    labels: ['Media Voti', 'Quantità'],
		    type: 'bar'
		    	
		  }];
	
	var layout = {
			xaxis: {
			    title: {
			      text: 'Voti Medi',
			      font: {
			        family: 'Montserrat, sans-serif',
			        size: 18,
			        color: '#a18b5e'
			      }
			    },
			  },
			  yaxis: {
			    title: {
			      text: 'Quantità',
			      font: {
			        family: 'Montserrat, sans-serif',
			        size: 18,
			        color: '#a18b5e'
			      }
			    }
			  }
			
						};
	
	var dataw = [
		  {
		    x: <%=idw%>,
		    y: <%=countw%>,
		    labels: ['Media Voti', 'Quantità'],
		    type: 'bar'
		  }];
	
	var layoutw = {
			xaxis: {
			    title: {
			      text: 'Libri',
			      font: {
			        family: 'Montserrat, sans-serif',
			        size: 18,
			        color: '#a18b5e'
			      }
			    },
			  },
			  yaxis: {
			    title: {
			      text: 'Quantità',
			      font: {
			        family:'Montserrat, sans-serif',
			        size: 18,
			        color: '#a18b5e'
			      }
			    }
			  }
						};
	var data2 = [
		  {
		    x: <%=id2%>,
		    y: <%=count2%>,
		    labels: ['Media Voti', 'Quantità'],
		    type: 'bar'
		  }];
	
	var layout2 = {
			xaxis: {
			    title: {
			      text: 'Anni',
			      font: {
			        family: 'Montserrat, sans-serif',
			        size: 18,
			        color: '#a18b5e'
			      }
			    },
			  },
			  yaxis: {
			    title: {
			      text: 'Quantità',
			      font: {
			        family: 'Montserrat, sans-serif',
			        size: 18,
			        color: '#a18b5e'
			      }
			    }
			  }	}

						var datap = [
							  {
							    values: <%=countp%>,
							    labels: 	<%=idp%>,
							    type: 'pie'
							  }];
						
						var layoutp = {
							
											};

		Plotly.newPlot('rates', data,layout);
		Plotly.newPlot('years', data2,layout2);
		Plotly.newPlot('pie', datap,layoutp);
		Plotly.newPlot('wish', dataw,layoutw);

</script>
	<script>
	Plotly.d3.csv('https://raw.githubusercontent.com/plotly/datasets/master/3d-line1.csv', function(err, rows){

	          
	var x =  <%=idis%>;
	var y =  <%=countt%>;
	var z =  <%=countv%>;
	var c = "#1f77b4";
	Plotly.plot('nvoti', [{
	  type: 'scatter3d',
	  mode: 'lines',
	

			
	  x: x,
	  y: y,
	  z: z,
	  opacity: 1,
	  line: {
	    width: 6,
	    color: c,
	    reversescale: false
	  }
	}], {
	});
	});
			
	</script>
</body>
</html>