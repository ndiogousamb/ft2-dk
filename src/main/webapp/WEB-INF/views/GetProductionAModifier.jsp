<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html ng-app="ImportExport" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>MODIFICATION PRODUCTION-FT2-DAKAR</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/assets/css/bootstrap-select.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/assets/css/Acue.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/assets/js/sweetalert.css">
<script
	src="<%=request.getContextPath()%>/static/assets/js/bootstrap-select.js"></script>
<!-- BOOTSTRAP STYLES-->
<link
	href="<%=request.getContextPath()%>/static/assets/css/bootstrap.css"
	rel="stylesheet" />

<link
	href="<%=request.getContextPath()%>/static/assets/css/datepicker.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/static/assets/css/bootstrap-select.css"
	rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link
	href="<%=request.getContextPath()%>/static/assets/css/font-awesome.css"
	rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="<%=request.getContextPath()%>/static/assets/css/custom.css"
	rel="stylesheet" />
<script
	src="<%=request.getContextPath()%>/static/assets/js/jquery-1.10.2.js"></script>
<script
	src="<%=request.getContextPath()%>/static/assets/js/datepicker.js"></script>
<script
	src="<%=request.getContextPath()%>/static/assets/js/bootstrap-select.js"></script>

<script>
	$(function() {
		$('.datepicker').datepicker();
	});
</script>
</head>
<body ng-controller="ImportExportController"
	ng-init="getEspeceProduiteByCodePourModification();listEspeces();listCalibres();verifierCIN()">

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
			<form class="form-horizontal ">
				<div class="row">

					<div class="col-lg-5 ">
						<br>
						<div style="background: transparent; border: 0px;">
							<font size="3px" color="white">Date Début Production :</font> <input
								style="width: 202px;" id="SamaDateDeb" class="datepicker"
								type="text" value="Datedeb" ng-model="Datedeb">
						</div>
						<br>
						<div style="background: transparent; border: 0px;">
							<font size="3px" color="white"> Date Fin Production
								&nbsp;&nbsp;&nbsp; : </font> <input style="width: 202px;"
								id="SamaDateFin" class="datepicker" type="text" value="Datefin"
								ng-model="Datefin">
						</div>
						<br>
						<div class="input-group"> 
							
							<font size="3px" color="white"> Code Production : </font> 
							
							<input
								class="form-control" style="width: 372px;"
								placeholder="Code Production" type="text"
								ng-model="CodeProduction"  />
							
						</div>
					</div>
					<div class="col-lg-5 ">
						<br>
						<div class="input-group">
							<div class="input-group-addon"></div>
							<input class="form-control" ng-model="CIN"
								placeholder="Numero Carte d'identitité Nationale du Mareyeur"
								type="text" ng-change="verifierCIN()"
								ng-model-options="{debounce: 500}" />
						</div>
						<br>
						<div class="input-group">
							<div class="input-group-addon"></div>
							<input class="form-control" placeholder="Prenom du Mareyeur"
								type="text" ng-model="PrenomMarayeur" ng-readonly="verrou" />
						</div>
						<br>
						<div class="input-group">
							<div class="input-group-addon"></div>
							<input class="form-control" placeholder="Nom du Mareyeur"
								type="text" ng-model="NomMarayeur" ng-readonly="verrou" />
						</div>
						<br>
						<div class="input-group">
							<div class="input-group-addon"></div>
							<input class="form-control" placeholder="Matricule du Vehicule"
								type="text" ng-model="Immatricule" />
						</div>
					</div>
				</div>

				<br>
				<div class="col-xs-6 col-sm-12">
					<div class="panel panel-primary">
						<div class="panel-heading">Listes des especes selectionnées</div>
						<div class="panel-body">
							<table class="table table-striped">
								<thead>
									<tr>
										<th scope="row">ESPECE</th>
										<th scope="row">CALIBRE</th>
										<th scope="row">POIDS(KGS)</th>
									</tr>
									<tr ng-repeat="e in listEspecesProduites | filter:search">

										<td>{{e.espece.libelleEspece}}</td>
										<td>{{e.calibre.libelleCalibre}}</td>
										<td>{{e.plaignat}} KGS</td>
										<td><a data-toggle="modal" data-target="#ModalUpdate"
											data-whatever="@mdo" ng-click="LoadDataPourModif()">Modifier</a>
										</td>
										<td><a data-toggle="modal" data-target="#ModalDelete"
											data-whatever="@mdo">Supprimer</a></td>
									</tr>
								</thead>
							</table>
						</div>
					</div>

					<button class="btn btn-lg btn-primary btn-block"
						style="width: 500px; margin-left: 250px;"
						ng-click="UpdateProduction()" type="submit">Modifier la
						Production</button>
				</div>
			</form>
		</div>
	</div>
	<form>
		<div class="modal fade" id="ModalUpdate" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="exampleModalLabel">Modification
							de l'Espece</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="recipient-name" style="color: white;class="control-label">Espece:</label>
							<select class="form-control" ng-model="espece">
								<option ng-repeat="lp in listEspeces"
									ng-selected="lp.libelleEspece==espece" value="{{lp.libelleEspece}}">{{lp.libelleEspece}}</option>
							</select>
						</div>
						<div class="form-group">
							<label for="recipient-name" style="color: white;class="control-label">Calibre:</label>
							<select class="form-control" ng-model="calibre">
								<option ng-repeat="lC in listCalibres"
									ng-selected="lC.libelleCalibre==calibre" value="{{lC.libelleCalibre}}">{{lC.libelleCalibre}}</option>
							</select>
						</div>
						<div class="form-group">
							<label for="recipient-name" style="color: white;class="control-label">Poids:</label>
							<input type="text" class="form-control" ng-model="poids" required>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
						<button type="button" class="btn btn-primary"
							ng-click="modifierEspeceProduite()" data-dismiss="modal">Modifier</button>
					</div>
				</div>
			</div>
		</div>
	</form>




	<script
		src="<%=request.getContextPath()%>/static/assets/js/angular-1.3.12.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/assets/js/angular-cookies.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/assets/js/app.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/assets/js/bootstrap.min.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="<%=request.getContextPath()%>/static/assets/js/custom.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/assets/js/sweetalert.min.js"></script>
</body>
</html>