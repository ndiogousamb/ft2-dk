<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html ng-app="ImportExport" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>STOCK-FT2-DAKAR</title>
<link
	href="<%=request.getContextPath()%>/static/assets/css/dataTables.bootstrap.css"
	rel="stylesheet" type="text/css">
<link
	href="<%=request.getContextPath()%>/static/assets/css/AdminLTE.min.css"
	rel="stylesheet" type="text/css">
<link
	href="<%=request.getContextPath()%>/static/assets/css/AdminLTE.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/assets/js/sweetalert.css">
<!-- BOOTSTRAP STYLES-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/assets/css/Acue.css">
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
<body ng-controller="ImportExportController" ng-init="getListStock()">


	<div id="general">
		<div id="head">
			<div class="bienvenu">
				<p>
					Utilisateur:
					<c:out value="${nomComplet}" />
					!
				</p>
			</div>
			<a href="#"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_03.png"
				class="config">
			</a> <a href="<%=request.getContextPath()%>/user/login?logout"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_05.png"
				class="conec">
			</a>
		</div>
		<div id="gauche">
			<a href="<%=request.getContextPath()%>/accueil"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_09.png"
				class="menu">
			</a> <a href="<%=request.getContextPath()%>/production/menu"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_21.png"
				class="produc">
			</a> <a href="<%=request.getContextPath()%>/demoulage/AddDemoulage/">
				<img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_22.png"
				class="demoul">
			</a> <a href="<%=request.getContextPath()%>/stock/"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_23.png"
				class="stock">
			</a> <a href="<%=request.getContextPath()%>/VenteLocale/menu"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_24.png"
				class="vente">
			</a> <a href="<%=request.getContextPath()%>/exportation/menu"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_29.png"
				class="location">
			</a> <a href="<%=request.getContextPath()%>/facturation/menu"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_30.png"
				class="factu">
			</a> <a href="<%=request.getContextPath()%>/debarquement/menu"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_31.png"
				class="debar">
			</a> <a href="<%=request.getContextPath()%>/debarquement/menu"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_100.png"
				class="rechercher">
			</a>
		</div>

		<div id="droite">
			<form class="form-signin-heading">
				<h2 class="form-signin-heading"></h2>
				<div class="input-group">
					<div class="input-group-addon">
						<i class="fa fa-user fa-fw"></i>
					</div>
					<input class="form-control" ng-model="search"
						placeholder="Rechercher" type="text" required />
				</div>
				<br>
			</form>
			<div class="panel panel-primary">
				<div class="panel-heading">Liste des Espces</div>
				<div class="panel-body">
					<table class="table table-striped" at-table at-paginated at-list="list" at-config="config">
						<thead>
							<tr>
								<th scope="row">ESPECE</th>
								<th scope="row">CALIBRE</th>
								<th scope="row">TYPE CARTON</th>
								<th scope="row">QUALITE</th>
								<th scope="row">STOCK AVANT</th>
								<th scope="row">STOCK ACTUEL</th>
								<th scope="row">ENTREE/SORTIE</th>
								<th scope="row">DATE DERNIERE INSERTION</th>
								<th scope="row">UTILISATEUR ENREGISTRE</th>


							</tr>
						</thead>
						<tr ng-repeat="l in listStock | filter:search ">
							<td>{{l.especeDemoulee.espece.libelleEspece}}</td>
							<td
								ng-if="l.especeDemoulee.grosPoisson.libelleCalibreGP=='GROS POISSON'">GROS
								POISSON</td>
							<td
								ng-if="l.especeDemoulee.grosPoisson.libelleCalibreGP!='GROS POISSON'">{{l.especeDemoulee.calibre.libelleCalibre}}</td>
							<td>{{l.especeDemoulee.typeCarton.libelleTypecarton}}</td>
							<td>{{l.especeDemoulee.qualite.libelleQualite}}</td>
							<td>{{l.soldeAvant}}</td>
							<td>{{l.soldeStock}}</td>
							<td>{{l.nombre}}</td>
							<td>{{l.date}}</td>
							<td>{{l.especeDemoulee.utilisateur.nomComplet}}</td>
						</tr>

					</table>
				<at-pagination at-list="list" at-config="config"></at-pagination>
				</div>
			</div>
		</div>

	</div>





	<script
		src="<%=request.getContextPath()%>/static/assets/js/angular-1.3.12.js"></script>
	<script src="<%=request.getContextPath()%>/static/assets/js/app.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/assets/js/jquery-1.10.2.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/assets/js/jquery.dataTables.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/assets/js/jquery.dataTables.min.js"></script>


	<script
		src="<%=request.getContextPath()%>/static/assets/js/bootstrap.min.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="<%=request.getContextPath()%>/static/assets/js/custom.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/assets/js/sweetalert.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/assets/js/jquery.dataTables.js"
		type="text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/static/assets/js/dataTables.bootstrap.js"
		type="text/javascript"></script>
	<!-- SlimScroll -->
	<script
		src="<%=request.getContextPath()%>/static/assets/js/slimScroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<!-- FastClick -->
	<script
		src='<%=request.getContextPath()%>/static/assets/js/fastclick/fastclick.min.js'></script>
	<!-- AdminLTE App -->
	<script src="<%=request.getContextPath()%>/static/assets/js/app.min.js"
		type="text/javascript"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="<%=request.getContextPath()%>/static/assets/js/demo.js"
		type="text/javascript"></script>
	


</body>
</html>