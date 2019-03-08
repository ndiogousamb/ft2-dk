<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>MENU FACTURATION-FT2-DAKAR</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/assets/css/Acue.css">

<!-- BOOTSTRAP STYLES-->
<link
	href="<%=request.getContextPath()%>/static/assets/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link
	href="<%=request.getContextPath()%>/static/assets/css/font-awesome.css"
	rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="<%=request.getContextPath()%>/static/assets/css/custom.css"
	rel="stylesheet" />
</head>
<body>



	<div id="general">
			<div id="head">
				<div class="bienvenu">
				<p>
					Utilisateur:
					<c:out value="${nomComplet}" /> !
				</p>
			</div>
				<a href="#">
					<img src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_03.png" class="config">
				</a>
				<a href="<%=request.getContextPath()%>/user/login?logout">
					<img src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_05.png" class="conec">
				</a>
			</div>
		<div id="gauche">
				<a href="<%=request.getContextPath()%>/accueil">
					<img src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_09.png" class="menu">
				</a>
				<a href="<%=request.getContextPath()%>/production/menu">
					<img src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_21.png" class="produc">
				</a>
				<a href="<%=request.getContextPath()%>/demoulage/AddDemoulage/">
					<img src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_22.png" class="demoul">
				</a>
				<a href="<%=request.getContextPath()%>/stock/">
					<img src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_23.png" class="stock">
				</a>
				<a href="<%=request.getContextPath()%>/VenteLocale/menu">
					<img src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_24.png" class="vente">
				</a>
				<a href="#">
					<img src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_29.png" class="location">
				</a>
				<a href="<%=request.getContextPath()%>/facturation/menu">
					<img src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_30.png" class="factu">
				</a>
				<a href="<%=request.getContextPath()%>/debarquement/menu">
					<img src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_31.png" class="debar">
				</a>
				<a href="<%=request.getContextPath()%>/debarquement/menu">
					<img src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_100.png" class="rechercher">
				</a>
			</div>
			
			<div id="droite">
				<a href="<%=request.getContextPath()%>/facturation/MenuFacturationProduction">
					<img src="<%=request.getContextPath()%>/static/assets/img/facturation_production.png" class="facpro">
				</a>
				<a href="<%=request.getContextPath()%>/facturation/MenuFacturationDebarquement"> 
					<img src="<%=request.getContextPath()%>/static/assets/img/facturation_debarquement.png" class="facdebr">
				</a>
				<a href="<%=request.getContextPath()%>/facturation/MenuFacturationVenteLocale">
					<img src="<%=request.getContextPath()%>/static/assets/img/facturation_ventelocale.png" class="facvenlo">
				</a>
				<a href="<%=request.getContextPath()%>/facturation/MenuFacturationExportation">
					<img src="<%=request.getContextPath()%>/static/assets/img/facturation_exportation.png" class="facexpo">
				</a>
			</div>
			
			
		</div>
		<!-- /. PAGE WRAPPER  -->
	



	<!-- /. WRAPPER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>static/assets/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>static/assets/js/bootstrap.min.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="<%=request.getContextPath()%>static/assets/js/custom.js"></script>


</body>
</html>
