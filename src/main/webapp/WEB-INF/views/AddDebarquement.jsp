<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="ImportExport" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>AJOUTER DEBARQUEMENT</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/assets/css/Acue.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/assets/css/bootstrap-select.css">
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
	ng-init="listCalibres();listEspeces();GetlistCartons();GetlistQualites()">



	<div id="general">
		<div id="head">
			<div class="bienvenu">
				<p>
					Utilisateur:
					<c:out value="${nomComplet}" /> !
				</p>
			</div> 
			<a href=#></a><img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_03.png"
				class="config">
			<a href="<%=request.getContextPath()%>/user/login?logout"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_05.png"
				class="conec">
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
				<a href="<%=request.getContextPath()%>/exportation/menu">
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
			<form class="form-horizontal ">
				<div class="row">
					<div class="col-xs-6 col-sm-4">
						<fieldset class="well the-fieldset"
							style="background: transparent; border: 0px;">
							<legend class="the-legend">
								<font size="5px" color="white"> <b>Informations sur
										l'origine des produits</b>
								</font>
							</legend>
							<div>
								<div class="well" style="background: transparent; border: 0px;">
									<font size="3px" color="white">Date D�barquement : </font> 
									<input style="width: 240px"
										id="DateDebarquement" class="datepicker" type="text"
										value="DateDebarquement" ng-model="DateDebarquement">
								</div>

								<div class="input-group">
									<div class="input-group-addon"></div>
									<input class="form-control" ng-model="Navire"
										placeholder="Navire" type="text" />
								</div>

								<br>
								<div class="input-group">
									<div class="input-group-addon"></div>
									<input class="form-control" placeholder="Prenom du Fournisseur"
										type="text" ng-model="PrenomFournisseur" ng-readonly="verrou" />
								</div>
								<br>
								<div class="input-group">
									<div class="input-group-addon"></div>
									<input class="form-control" placeholder="Nom du Fournisseur"
										type="text" ng-model="NomFournisseur" ng-readonly="verrou" />
								</div>
								<br>
								<div class="input-group">
									<div class="input-group-addon"></div>
									<input class="form-control" placeholder="Numero du Manifeste"
										type="text" ng-model="Manifeste" ng-readonly="verrou" />
								</div>
							</div>
						</fieldset>
					</div>


					<div class="col-xs-6 col-sm-4">
						<fieldset class="well the-fieldset"
							style="background: transparent; border: 3px;">
							<legend class="the-legend">
								<font size="5px" color="white"> <b>Informations sur
										les Produits d�barqu�s</b>
								</font>
							</legend>
							<br> <select ng-model="element.espece" class="form-control">
								<option value="" disabled selected>Choisir L'Esp�ce</option>
								<option value="{{lE.libelleEspece}}"
									ng-repeat="lE in listEspeces">{{lE.libelleEspece}}</option>
							</select> <label class="radio-inline"><input type="radio"
								ng-value="'espececalibre'" ng-click="especeCalibreRbtn()"
								name="espececalibre" ng-model="espececalibre">Espece en
								Calibre</label> <label class="radio-inline"> <input type="radio"
								ng-value="'especegrospoisson'" ng-click="especeCalibreRbtn()"
								name="especegrospoisson" ng-model="espececalibre">Gros
								Poisson
							</label>
							<div ng-if="espececalibre=='espececalibre'">

								<select class="form-control" ng-model="element.calibre">
									<option value="" disabled selected>Choisir Le Calibre</option>
									<option ng-repeat="lc in listCalibres"
										value="{{lc.libelleCalibre}}">{{lc.libelleCalibre}}</option>
								</select> <br>
							</div>
							<div ng-if="espececalibre=='espececalibre'">

								<select class="form-control" ng-model="element.typecarton">
									<option value="" disabled selected>Choisir Le Type de
										Carton</option>
									<option ng-repeat="lcarton in listCartons"
										value="{{lcarton.libelleTypecarton}}">{{lcarton.libelleTypecarton}}</option>
								</select>
							</div>
							<div class="input-group"
								ng-if="espececalibre=='especegrospoisson'">
								<div class="input-group-addon"></div>
								<input class="form-control" ng-model="element.poids"
									placeholder="Poids" type="text" />
							</div>
							<br>
							<div class="input-group" ng-if="espececalibre=='espececalibre'">
								<div class="input-group-addon"></div>
								<input class="form-control" ng-model="element.nbCarton"
									placeholder="Nombre de Cartons" type="text" />
							</div>
							<br>
							<div>
								<select class="form-control" ng-model="element.qualite">
									<option value="" disabled selected>Choisir La Qualit�</option>
									<option ng-repeat="lc in listQualites"
										value="{{lc.libelleQualite}}">{{lc.libelleQualite}}</option>
								</select>
							</div>
						</fieldset>
					</div>
					<div class="col-xs-6 col-sm-4">
						<fieldset class="well the-fieldset"
							style="background: transparent; border: 3px;">
							<legend class="the-legend">
								<font size="5px" color="white"> <b>Informations sur
										le moyen de Transport</b>
								</font>
							</legend>
							<br> <font size="3px" color="white"><label>
									Moyen de Transport</label><br> </font> <label class="radio-inline"><input
								type="radio" ng-value="'camion'" ng-click="moyenTransportRbtn()"
								name="camion" ng-model="moyenTransport">Camion</label> 
								<label
								class="radio-inline"><input ng-value="'container'"
								ng-click="moyenTransportRbtn()" name="container"
								ng-model="moyenTransport" type="radio">Container</label> 
								<!-- <label ng-if="moyenTransport=='container'"
								class="radio-inline">
								<input type="radio"
								ng-value="'venteLocale'" name="VenteLocale"
								ng-model="VenteLocOuExport">Vente Locale</label> --> 
								<!-- <label ng-if="moyenTransport=='container'"
								class="radio-inline"><input type="radio"
								ng-value="'Exportation'" name="Exportation"
								ng-model="VenteLocOuExport">Exportation</label> -->
							<div class="input-group" ng-if="moyenTransport=='camion'">
								<div class="input-group-addon"></div>
								<input class="form-control" placeholder="Matricule du Camion"
									type="text" ng-model="element.Immatricule" /> <br>
							</div>
							<div class="input-group" ng-if="moyenTransport=='container'">
								<div class="input-group-addon"></div>
								<input class="form-control" placeholder="Numero du Container"
									type="text" ng-model="element.NumContainer" /> <br>
							</div>
							<br>
							<div class="input-group" ng-if="moyenTransport=='container'">
								<div class="input-group-addon"></div>
								<input class="form-control" placeholder="Numero du Plombs"
									type="text" ng-model="element.NumPlombs" />
							</div>
							<br ng-if="moyenTransport=='container'">
							<div class="input-group">
								<div class="input-group-addon"></div>
								<input class="form-control" placeholder="Destination"
									type="text" ng-model="element.Destination" />
							</div>
							<br>
							<div class="input-group">
								<div class="input-group-addon"></div>
								<input class="form-control"
									placeholder="Nombre ou Poids a Transporter" type="text"
									ng-model="element.NbTransporter" />
							</div>
							<br>
							<button class="btn btn-lg btn-primary btn-block" type="submit"
								ng-click="add(element)">Ajouter Espece</button>
						</fieldset>

					</div>
				</div>


				<div class="row">
					<div class="col-xs-6 col-sm-12">

						<div class="panel panel-primary">
							<div class="panel-heading">Listes des especes selectionn�es</div>
							<div class="panel-body">
								<table class="table table-striped">
									<thead>
										<tr>
											<th scope="row">ESPECE</th>
											<th scope="row">CALIBRE</th>
											<th scope="row">POIDS(KGS)</th>
											<th>NB CARTON</th>
											<th>QUALITE</th>
											<th>DESTINATION / NB TRANSP</th>
										</tr>
										<tr ng:repeat="element in elements">
											<td>{{element.espece}}</td>
											<td>{{element.calibre}}</td>
											<td>{{element.poids}}</td>
											<td>{{element.nbCarton}}</td>
											<td>{{element.qualite}}</td>
											<td>{{element.Destination}} / {{element.NbTransporter}}</td>
											<td></td>
											<td><a data-toggle="modal"
												ng-click="LoadDataForPanierProduction()"
												data-target="#ModalUpdate" data-whatever="@mdo">Modifier</a></td>
											<td><a ng-click="remove(element)" class="delete-element">Suprimmer</a></td>
										</tr>
									</thead>

								</table>

								<br> <br>
								<button class="btn btn-lg btn-primary btn-block"
									ng-click="saveDebarquement()" type="submit">Valider</button>
							</div>
						</div>
					</div>
				</div>


				<br>




			</form>

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