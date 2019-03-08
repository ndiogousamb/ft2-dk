<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html ng-app="ImportExport" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>MODIFICATION VENTE LOCALE-FT2-DAKAR</title>
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
	ng-init="EspeceDemoulee_VenteLocalePourModification();listEspeces();listCalibres();GetlistCartons()">

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
			<div class="row">
				<div class="col-lg-5 ">
					<div class="well" style="background: transparent; border: 0px;">
						<font size="3px" color="white">Date Achat : </font> <input
							style="width: 360px;" id="DateAchat" class="datepicker"
							type="text" value="DateAchat" ng-model="DateAchat">
					</div>

					<div class="input-group">
						<div class="input-group-addon"></div>
						<input class="form-control" ng-model="PrenomClient"
							placeholder="Prenom du Client" type="text" />
					</div>

					<br>
					<div class="input-group">
						<div class="input-group-addon"></div>
						<input class="form-control" placeholder="Nom du Client"
							type="text" ng-model="NomClient" ng-readonly="verrou" />
					</div>
				</div>
			</div>
			<br> <br>
			<div class="col-xs-6 col-sm-12">
				<div class="panel panel-primary">
					<div class="panel-heading">Listes des especes selectionnées</div>
					<div class="panel-body">
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="row">ESPECE</th>
									<th scope="row">CALIBRE</th>
									<th scope="row">TYPE CARTON</th>
									<th scope="row">NOMBRE DE CARTON</th>
									<th scope="row">POIDS</th>
								</tr>
							</thead>
							<tr ng-repeat="e in listEspecesDemouleesAchetees | filter:search">

								<td>{{e.especeDemoulee.espece.libelleEspece}}</td>
								<td
									ng-if="e.especeDemoulee.grosPoisson.libelleCalibreGP!='GROS POISSON'">{{e.especeDemoulee.calibre.libelleCalibre}}</td>
								<td
									ng-if="e.especeDemoulee.grosPoisson.libelleCalibreGP=='GROS POISSON'">GROS
									POISSON</td>
								<td>{{e.especeDemoulee.typeCarton.libelleTypecarton}}</td>

								<td
									ng-if="e.especeDemoulee.grosPoisson.libelleCalibreGP!='GROS POISSON'">{{e.nombreCartonAchete}}
									CARTON</td>
								<td
									ng-if="e.especeDemoulee.grosPoisson.libelleCalibreGP=='GROS POISSON'"></td>
								<td>{{e.poids}} KGS</td>
								<td ng-if="e.especeDemoulee.grosPoisson.libelleCalibreGP!='GROS POISSON'"><a data-toggle="modal" data-target="#ModalUpdate"
									data-whatever="@mdo" ng-click="LoadDataPourModifVenteLocale()">Modifier</a>
								</td>
								<td ng-if="e.especeDemoulee.grosPoisson.libelleCalibreGP=='GROS POISSON'"><a data-toggle="modal" data-target="#ModalUpdateGrosPoisson"
									data-whatever="@mdo" ng-click="LoadDataPourModifVenteLocaleGrosPoisson()">Modifier</a>
								</td>
								
								<td><a data-toggle="modal" data-target="#ModalDelete"
									data-whatever="@mdo">Supprimer</a></td>
							</tr>


						</table>




					</div>
				</div>

			</div>
			<button class="btn btn-lg btn-primary btn-block"
				style="width: 500px; margin-left: 250px;"
				
				ng-click="UpdateProduction()" type="submit">Modifier la
				Vente Locale</button>
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
									ng-selected="lp.libelleEspece==espece"
									value="{{lp.libelleEspece}}">{{lp.libelleEspece}}</option>
							</select>
						</div>
						<div class="form-group">
							<label for="recipient-name" style="color: white;class="control-label">Calibre:</label>
							<select class="form-control" ng-model="calibre">
								<option ng-repeat="lC in listCalibres"
									ng-selected="lC.libelleCalibre==calibre"
									value="{{lC.libelleCalibre}}">{{lC.libelleCalibre}}</option>
							</select>
						</div>
						<div class="form-group">
							<label for="recipient-name" style="color: white;class="control-label">Type
								Carton:</label> 
								<select class="form-control" ng-model="typecarton">
								<option ng-repeat="lCarton in listCartons"
									ng-selected="lCarton.libelleTypecarton==typecarton"
									value="{{lCarton.libelleTypecarton}}">{{lCarton.libelleTypecarton}}</option>
							</select>
						</div>
						<div class="form-group">
							<label for="recipient-name" style="color: white;class="control-label">Nombre de Cartons:</label>
							<input type="text" class="form-control" ng-model="nbCarton" required>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
						<button type="button" class="btn btn-primary"
							ng-click="modifierEspeceAchetes()" data-dismiss="modal">Modifier</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	
	
	
	<form>
		<div class="modal fade" id="ModalUpdateGrosPoisson" tabindex="-1" role="dialog"
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
									ng-selected="lp.libelleEspece==espece"
									value="{{lp.libelleEspece}}">{{lp.libelleEspece}}</option>
							</select>
						</div>
						<div class="form-group">
							<label for="recipient-name" style="color: white;class="control-label">Calibre:</label>
								<div class="form-group">
							<input type="text" class="form-control" value="GROS POISSON" readonly="readonly">
						</div>
						</div>
						
						<div class="form-group">
							<label for="recipient-name" style="color: white;class="control-label">Poids:</label>
							<input type="text" class="form-control" ng-model="poids" required>
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
						<button type="button" class="btn btn-primary"
							ng-click="modifierEspeceGrosPoisson()" data-dismiss="modal">Modifier</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	



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