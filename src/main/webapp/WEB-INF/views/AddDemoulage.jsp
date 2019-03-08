<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="ImportExport" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>AJOUTER DEMOULAGE FT2-DAKAR</title>
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
<script>
	$(function() {
		$('.datepicker').datepicker();
	});
</script>

</head>
<body ng-controller="ImportExportController"
	ng-init="getProductionByCodeProduction();listEspeces();listCalibres();GetlistCartons();GetlistQualites();GetlistTunnel()">


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
				<div class="panel-heading">
					<font size="5px"> <label> Liste des ESPECES A
							DEMOULER </label></font>
				</div>
				<div class="panel-body">
					<table class="table table-striped">
						<thead>
							<tr>

								<th scope="row">ESPECE</th>
								<th scope="row">CALIBRE</th>
								<th scope="row">POIDS</th>

							</tr>
						</thead>
						<tr ng-repeat="e in listEspecesProduites | filter:search">

							<td>{{e.espece.libelleEspece}}</td>
							<td>{{e.calibre.libelleCalibre}}</td>
							<td>{{e.poids}} KGS</td>
							<td><a data-toggle="modal"
								ng-click="LoadDataEspecePourDemoulage()"
								ng-if="e.calibre.libelleCalibre!='GROS POISSON'"
								data-target="#ModalDemouler" data-whatever="@mdo">Demouler</a> <a
								data-toggle="modal"
								ng-if="e.calibre.libelleCalibre=='GROS POISSON'"
								ng-click="LoadDataEspecePourDemoulage()"
								data-target="#ModalDemoulerGrosPoisson" data-whatever="@mdo">Demouler</a>
							</td>
							<td><a data-toggle="modal" data-target="#ModalModifier"
								data-whatever="@mdo">Modifier</a></td>
							<td><a data-toggle="modal" data-target="#ModalDelete"
								data-whatever="@mdo">Supprimer</a></td>

						</tr>
					</table>
					<form>
						<div class="modal fade" id="ModalDemouler" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="exampleModalLabel">Mise en
											Carton de l'Espece</h4>
									</div>
									<div class="modal-body">
										<div class="form-group">
											<label for="recipient-name" style="color: white;class="control-label">Espece:</label>
											<select class="form-control" ng-model="espece"
												ng-disabled="verrou">
												<option ng-repeat="lE in listEspeces"
													ng-selected="lE.libelleEspece==espece"
													value="{{lE.libelleEspece}}">{{lE.libelleEspece}}</option>
												<select />
										</div>
										<div class="form-group">
											<label for="recipient-name" style="color: white;class="control-label">Calibre:</label>
											<select class="form-control" ng-model="calibre"
												ng-disabled="verrou">
												<option disabled selected ng-repeat="lC in listCalibres"
													ng-selected="lC.libelleCalibre==calibre"
													value="{{lC.libelleCalibre}}">{{lC.libelleCalibre}}</option>
											</select>
										</div>
										<div class="form-group">
											<label for="recipient-name" style="color: white;"
												class="control-label">Poids: </label> <input type="text"
												class="form-control" ng-model="poids" ng-readonly="verrou"
												required>
										</div>
										<input type="hidden" ng-model="id">
										<div class="form-group">
											<label for="recipient-name" style="color: white;class="control-label">Type
												de Carton:</label> <select class="form-control"
												ng-model="typecarton" ng-change="CalculNbCarton()"
												ng-model-options="{debounce: 250}">
												<option value="" disabled selected>Choisir Le Type
													de Carton</option>
												<option ng-repeat="lCarton in listCartons"
													value="{{lCarton.id}}">{{lCarton.libelleTypecarton}}</option>
											</select>
										</div>
										<div class="form-group">
											<label for="recipient-name" style="color: white;"
												class="control-label">Nombre de Carton: </label> <input
												type="text" class="form-control" ng-model="nbCarton"
												required>
										</div>
										<div class="form-group">
											<label for="recipient-name" style="color: white;class="control-label">Qualité:</label>
											<select class="form-control" ng-model="qualite">
												<option value="" disabled selected>Choisir La
													Qualité</option>
												<option ng-repeat="lQ in listQualites" value="{{lQ.id}}">{{lQ.libelleQualite}}</option>
											</select>
										</div>
										<div class="form-group">
											<label for="recipient-name" style="color: white;class="control-label">Tunnel:</label>
											<select class="form-control" ng-model="tunnel">
												<option value="" disabled selected>Choisir Le
													Tunnel</option>
												<option ng-repeat="t in listTunnels" value="{{t.id}}">{{t.libelleTunnel}}</option>
											</select>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Fermer</button>
										<button type="button" class="btn btn-primary"
											ng-click="SaveDemoulageEspecesCalibrees()"
											data-dismiss="modal">Valider</button>
									</div>
								</div>
							</div>
						</div>
					</form>
					<form>
						<div class="modal fade" id="ModalModifier" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="exampleModalLabel">Modification
											de l'espece en Production</h4>
									</div>
									<div class="modal-body">

										<div class="form-group">
											<label for="recipient-name" style="color: white;class="control-label">Espece:</label>

											<select class="form-control" ng-model="espece">
												<option ng-repeat="lp in listEspeces"
													ng-selected="lp.libelleEspece==espece" value="{{lp.id}}">{{lp.libelleEspece}}</option>
											</select>
										</div>
										<div class="form-group">
											<label for="recipient-name" style="color: white;class="control-label">Calibre:</label>

											<select class="form-control" ng-model="calibre">
												<option ng-repeat="lC in listCalibres"
													ng-selected="lC.libelleCalibre==calibre" value="{{lC.id}}">{{lC.libelleCalibre}}</option>
											</select>
										</div>
										<div class="form-group">
											<label for="recipient-name" style="color: white;class="control-label">Poids:</label>
											<input type="text" class="form-control" ng-model="poids"
												required>
										</div>

									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Fermer</button>
										<button type="button" class="btn btn-primary"
											ng-click="ModifierEspece()">Modifier</button>
									</div>
								</div>
							</div>
						</div>
					</form>
					<form>
						<div class="modal fade" id="ModalDelete" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="exampleModalLabel">Suppression</h4>
									</div>
									<div class="modal-body">

										<div class="form-group">
											<label for="recipient-name" style="color: white;class="control-label">Espece:</label>

											<select class="form-control" ng-model="espece">
												<option ng-repeat="lE in listEspeces"
													ng-selected="lE.libelleEspece==espece"
													value="{{lE.libelleEspece}}">{{lE.libelleEspece}}</option>
												<select />
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
											<label for="recipient-name" style="color: white;"
												class="control-label">Poids: </label> <input type="text"
												class="form-control" ng-model="poids" required>
										</div>

									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Fermer</button>
										<button type="button" class="btn btn-primary"
											ng-click="SupprimerEspece()">Supprimer</button>
									</div>
								</div>
							</div>
						</div>
					</form>
					<form>
						<div class="modal fade" id="ModalDemoulerGrosPoisson"
							tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
										<h4 class="modal-title" id="exampleModalLabel">Demoulage</h4>
									</div>
									<div class="modal-body">
										<div class="form-group">
											<label for="recipient-name" style="color: white;class="control-label">Espece:</label>

											<select class="form-control" ng-model="espece">
												<option ng-repeat="lE in listEspeces"
													ng-selected="lE.libelleEspece==espece"
													value="{{lE.libelleEspece}}">{{lE.libelleEspece}}</option>
												<select />
										</div>
										<div class="form-group">
											<label for="recipient-name" style="color: white;"
												class="control-label">Poids: </label> <input type="text"
												class="form-control" ng-model="poids" required>
										</div>
										<div class="form-group">
											<label for="recipient-name" style="color: white;class="control-label">Qualité:</label>
											<select class="form-control" ng-model="qualite">
												<option value="" disabled selected>Choisir La
													Qualité</option>
												<option ng-repeat="lQ in listQualites" value="{{lQ.id}}">{{lQ.libelleQualite}}</option>
											</select>
										</div>
										<div class="form-group">
											<label for="recipient-name" style="color: white;class="control-label">Tunnel:</label>
											<select class="form-control" ng-model="tunnel">
												<option value="" disabled selected>Choisir Le
													Tunnel</option>
												<option ng-repeat="t in listTunnels" value="{{t.id}}">{{t.libelleTunnel}}</option>
											</select>
										</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Fermer</button>
										<button type="button" class="btn btn-primary"
											ng-click="DemoulerEspece()">Demouler</button>
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>



	<script
		src="<%=request.getContextPath()%>/static/assets/js/angular-1.3.12.js"></script>
	<script src="<%=request.getContextPath()%>/static/assets/js/app.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/assets/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/static/assets/js/bootstrap.min.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="<%=request.getContextPath()%>/static/assets/js/custom.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/assets/js/sweetalert.min.js"></script>
</body>
</html>