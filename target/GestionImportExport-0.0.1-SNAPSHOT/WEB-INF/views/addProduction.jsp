<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="ImportExport" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>AJOUTER PRODUCTION</title>
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
	ng-init="listCalibres();listEspeces()">

	<div id="general">
		<div id="head">
			<div class="bienvenu">
				<p>
					Utilisateur:
					<c:out value="${nomComplet}" /> !
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

						<h2 class="form-signin-heading"></h2>
						<div>
							<div style="background: transparent; border: 0px;">
								<font size="3px" color="white">Date Début Production :</font> 
								<input style=" width: 202px;"
									id="SamaDateDeb" class="datepicker" type="text" value="Datedeb"
									ng-model="Datedeb">
							</div>
							<br>
							<div style="background: transparent; border: 0px;">
								<font size="3px" color="white"> Date Fin Production  &nbsp;&nbsp;&nbsp; : </font> 
								<input style=" width: 202px;"
									id="SamaDateFin" class="datepicker" type="text" value="Datefin"
									ng-model="Datefin">
							</div>
							<br>
							<div class="input-group">
								<div class="input-group-addon"></div>
								<input class="form-control" ng-model="CIN"
									placeholder="Numero Carte d'identitité Nationale du Mareyeur" type="text"
									ng-change="verifierCIN()" ng-model-options="{debounce: 500}" />
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
					<div class="col-lg-6 ">
						<div>
							<select ng-model="item.espece" class="form-control">
								<option value="" disabled selected>Choisir L'Espèce</option>
								<option value="{{lE.libelleEspece}}"
									ng-repeat="lE in listEspeces">{{lE.libelleEspece}}</option>
							</select>
						</div>
						<br>

						<div>
							<div>
								<select class="form-control" ng-model="item.calibre">
									<option value="" disabled selected>Choisir Le Calibre</option>
									<option ng-repeat="lc in listCalibres"
										value="{{lc.libelleCalibre}}">{{lc.libelleCalibre}}</option>
								</select>
							</div>
						</div>
						<br>

						<div class="input-group">
							<div class="input-group-addon"></div>
							<input class="form-control" ng-model="item.poids"
								placeholder="Poids" type="text" />
						</div>
						<br>
						<button class="btn btn-lg btn-primary btn-block" type="submit"
							ng-click="addItem(item)">Ajouter Espece</button>
						<br>
						<div class="panel panel-primary">
							<div class="panel-heading">Listes des especes selectionnées</div>
							<div class="panel-body">
								<table class="table table-striped">
									<thead>
										<tr>
											<th scope="row">ESPECE</th>
											<th scope="row">CALIBRE</th>
											<th scope="row">POIDS(KGS)</th>
											<th scope="row">MODIFIER</th>
											<th scope="row">SUPPRIMER</th>
										</tr>
										<tr ng:repeat="item in items">
											<td>{{item.espece}}</td>
											<td>{{item.calibre}}</td>
											<td>{{item.poids}}</td>
											<td><a data-toggle="modal"
												ng-click="LoadDataForPanierProduction()"
												data-target="#ModalUpdate" data-whatever="@mdo">Modifier</a></td>
											<td><a ng-click="remove(item)" class="delete-item">Suprimmer</a></td>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
					<button class="btn btn-lg btn-primary btn-block"
						style="width: 500px; margin-left: 250px;"
						ng-click="saveProduction()" type="submit">Enregistrer la
						Production</button>
				</div>
			</form>
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
								<h4 class="modal-title" id="exampleModalLabel">Modification</h4>
							</div>
							<div class="modal-body">


								<div class="form-group">
									<label for="recipient-name" style="color: white;class="control-label">Espece:</label>

									<select class="form-control" ng-model="item.espece">
										<option ng-repeat="lE in listEspeces"
											ng-selected="lE.libelleEspece==item.espece"
											value="{{lE.libelleEspece}}">{{lE.libelleEspece}}</option>
										<select />
								</div>
								<div class="form-group">
									<label for="recipient-name" style="color: white;class="control-label">Calibre:</label>
									<select class="form-control" ng-model="item.calibre">
										<option ng-repeat="lC in listCalibres"
											ng-selected="lC.libelleCalibre==item.calibre"
											value="{{lC.libelleCalibre}}">{{lC.libelleCalibre}}</option>
									</select>
								</div>
								<div class="form-group">
									<label for="recipient-name" style="color: white;"
										class="control-label">Poids: </label> <input type="text"
										class="form-control" ng-model="item.poids" required>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Fermer</button>
								<button type="button" class="btn btn-primary"
									ng-click="UpdateItem(item)" data-dismiss="modal">Modifier</button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>


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
