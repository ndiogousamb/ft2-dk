<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html ng-app="ImportExport" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>FACTURATION EXPORTATION-FT2-DAKAR</title>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/assets/css/Acue.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/assets/js/sweetalert.css">
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
<body ng-controller="ImportExportController"
	ng-init="EspeceTransportePourReglerFactureExportation()">

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
			</form>
			<br>
			<div class="panel panel-primary">
				<div class="panel-heading">

					<font size="3px"> <label
						ng-repeat="e in listEspecesTransportees" ng-if="$index <1">
							{{e.exportation.codeExportation}}
							<br> PRENOM DU DESTINATAIRE: 
							{{e.exportation.destinataire.prenomDestinataire}}
							<br> NOM DU DESTINATAIRE:
							{{e.exportation.destinataire.nomDestinataire}} 
							<br> PAYS DE DESTINATION:
							{{e.exportation.pays.pays}}
							<br> Liste des ESPECES De
							l'EXPORTATION: {{e.exportation.codeExportation}}
					</label></font>
				</div>
				<div class="panel-body">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="row">ESPECE</th>
								<th scope="row">CALIBRE</th>
								<th scope="row">TYPE CARTON</th>
								<th scope="row">NOMBRE DE CARTON</th>
								<th scope="row">POIDS</th>
								<th scope="row">PRIX UNITAIRE</th>
								<th scope="row">MONTANT</th>
							</tr>
						</thead>

						<tr ng-repeat="e in listEspecesTransportees | filter:search">

							<td>{{e.especeDemoulee.espece.libelleEspece}}</td>
							<td
								ng-if="e.especeDemoulee.grosPoisson.libelleCalibreGP!='GROS POISSON'">{{e.especeDemoulee.calibre.libelleCalibre}}</td>
							<td
								ng-if="e.especeDemoulee.grosPoisson.libelleCalibreGP=='GROS POISSON'">GROS
								POISSON</td>
							<td>{{e.especeDemoulee.typeCarton.libelleTypecarton}}</td>
							<td
								ng-if="e.especeDemoulee.grosPoisson.libelleCalibreGP!='GROS POISSON'">{{e.nombreTransporte}}</td>
							<td
								ng-if="e.especeDemoulee.grosPoisson.libelleCalibreGP=='GROS POISSON'"></td>
							<td>{{e.poids}}</td>
							<td><input class="form-control" type="text"
								ng-model="e.prixunitaire" width="1px" /></td>
							<td
								ng-if="e.especeDemoulee.grosPoisson.libelleCalibreGP=='GROS POISSON'"><input
								class="form-control" type="text"
								ng-model="e.montant=e.poids*e.prixunitaire" width="1px" readonly />
							</td>
							<td
								ng-if="e.especeDemoulee.grosPoisson.libelleCalibreGP!='GROS POISSON'"><input
								class="form-control" type="text"
								ng-model="e.montant=e.poids*e.prixunitaire"
								width="1px" readonly /></td>
						</tr>
					</table>
					<table>
						<tr>
							<b> MONTANT TOTAL: {{ (getTotalEspeceExportees()) }}</b>
						</tr>
					</table>

					<center>
						<button class="btn btn-primary btn-lg"
							ng-click="saveFactureExportation()" type="submit">Valider</button>
						<button class="btn btn-primary btn-lg"
							onclick="location.href='<%=request.getContextPath()%>/facturation/production'"
							type="submit">Annuler</button>
					</center>

				</div>
			</div>
		</div>

	</div>



	<script
		src="<%=request.getContextPath()%>/static/assets/js/angular-1.3.12.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/assets/js/angular-cookies.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/assets/js/app2.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/assets/js/bootstrap.min.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="<%=request.getContextPath()%>/static/assets/js/custom.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/assets/js/sweetalert.min.js"></script>


</body>
</html>