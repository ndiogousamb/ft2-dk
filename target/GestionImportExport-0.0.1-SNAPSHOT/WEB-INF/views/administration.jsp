<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html ng-app="ImportExport" xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>ADMINISTRATION-FT2-DAKAR</title>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/assets/js/sweetalert.css">
<!-- BOOTSTRAP STYLES-->
<link
	href="<%=request.getContextPath()%>/static/assets/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/assets/css/Acue.css">
<link
	href="<%=request.getContextPath()%>/static/assets/css/font-awesome.css"
	rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="<%=request.getContextPath()%>/static/assets/css/custom.css"
	rel="stylesheet" />

</head>
<body ng-controller="ImportExportController"
	ng-init="getListUser();getListRole();getListProfil()">


<div id="general">
			<div id="head">
			<div class="bienvenu">
				<p>
					Utilisateur:
					<c:out value="${nomComplet}" /> !
				</p>
			</div> <a href="#"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_03.png"
				class="config">
			</a> <a href="<%=request.getContextPath()%>/user/login?logout"> <img
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
	
				
						<form class="form-signin-heading">
							<h2 class="form-signin-heading"></h2>
							<div class="input-group">
								<div class="input-group-addon">
									<i class="fa fa-user fa-fw"></i>
								</div>
								<input class="form-control" ng-model="search"
									placeholder="Rechercher" " type="text" required />
							</div>
							<br>
						</form>
					

				
				<div class="panel panel-primary">
					<div class="panel-heading">Liste des Utilisateurs</div>
					<div class="panel-body">
						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="row">Login</th>
									<th scope="row">Prenom & Nom</th>
									<th scope="row">Profil</th>
									<th scope="row">Role</th>
									<th scope="row">Etat</th>
									<th scope="row">Action</th>


								</tr>
							</thead>
							<tr ng-repeat="l in listUser | filter:search"
								ng-click="loadData()">
								<td>{{l.login}}</td>
								<td>{{l.nomComplet}}</td>
								<td>{{l.profil.nomProfil}}</td>
								<td>{{l.role.role}}</td>
								<td><span ng-if="l.enabled==true">Actif<br></span> <span
									ng-if="l.enabled==false">Inactif<br></span></td>

								<td><span ng-if="l.enabled==true"> <a
										data-toggle="modal" data-target="#ModalDesactivation"
										data-whatever="@mdo">Desactiver le compte </a><br>
								</span> <span ng-if="l.enabled==false"> <a data-toggle="modal"
										data-target="#ModalActivation" data-whatever="@mdo">Activer
											le compte </a><br>
								</span></td>

								<td><a data-toggle="modal" data-target="#ModalDelete"
									data-whatever="@mdo">Suprimmer l'utilisateur</a></td>
								<td><a data-toggle="modal" data-target="#ModalUpdate"
									data-whatever="@mdo">Modifier l'utilisateur</a></td>
							</tr>
							
						</table>
						<form>
							<div class="modal fade" id="ModalActivation" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="exampleModalLabel">Activer
												le compte</h4>
										</div>
										<div class="modal-body">

											<div class="form-group">
												<label for="recipient-name" style="color: white;"
													class="control-label">Prenom et Nom:</label> <input
													type="text" class="form-control" ng-model="nomComplet"
													required readonly="readonly">
											</div>
											<div class="form-group">
												<label for="recipient-name" style="color: white;class="control-label">Identifiant:</label>
												<input type="text" class="form-control" ng-model="login"
													required readonly="readonly">
											</div>
											<div class="form-group">
												<label for="recipient-name" style="color: white;class="control-label">Profil:</label>

												<select class="form-control" ng-model="profil">
													<option ng-repeat="lp in listProfil"
														ng-selected="lp.nomProfil==profil" value="{{lp.id}}">{{lp.nomProfil}}</option>
												</select>
											</div>
											<div class="form-group">
												<label for="recipient-name" style="color: white;class="control-label">Role:</label>
												<select class="form-control" ng-model="role">
													<option ng-repeat="lr in listRoles"
														ng-selected="lr.role==role" value="{{lr.userRoleId}}">{{lr.role}}</option>
												</select>
											</div>

										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Fermer</button>
											<button type="button" class="btn btn-primary"
												ng-click="activerUtilisateur()">Activer</button>
										</div>
									</div>
								</div>
							</div>
						</form>
						<form>
							<div class="modal fade" id="ModalDesactivation" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="exampleModalLabel">Désactivation
												du compte</h4>
										</div>
										<div class="modal-body">

											<div class="form-group">
												<label for="recipient-name" style="color: white;class="control-label">Prenom
													et Nom:</label> <input type="text" class="form-control"
													ng-model="nomComplet" required readonly="readonly">
											</div>
											<div class="form-group">
												<label for="recipient-name" style="color: white;class="control-label">Identifiant:</label>
												<input type="text" class="form-control" ng-model="login"
													required readonly="readonly">
											</div>

										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Fermer</button>
											<button type="button" class="btn btn-primary"
												ng-click="desactiverUtilisateur()">Désactiver le
												compte</button>
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
											<h4 class="modal-title" id="exampleModalLabel">Supprimer
												l'Utilisateur</h4>
										</div>
										<div class="modal-body">

											<div class="form-group">
												<label for="recipient-name" style="color: white;class="control-label">Prenom
													et Nom:</label> <input type="text" class="form-control"
													ng-model="nomComplet" required readonly="readonly">
											</div>
											<div class="form-group">
												<label for="recipient-name" style="color: white;class="control-label">Identifiant:</label>
												<input type="text" class="form-control" ng-model="login"
													required readonly="readonly">
											</div>

										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Fermer</button>
											<button type="button" class="btn btn-primary"
												ng-click="supprimerUtilisateur()">Supprimer</button>
										</div>
									</div>
								</div>
							</div>
						</form>
						<form>
							<div class="modal fade" id="ModalUpdate" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="exampleModalLabel">Modification
												de l'Utilisateur</h4>
										</div>
										<div class="modal-body">
											<div class="form-group">
												<label for="recipient-name" style="color: white;class="control-label">Prenom
													et Nom:</label> <input type="text" class="form-control"
													ng-model="nomComplet" required>
											</div>
											<div class="form-group">
												<label for="recipient-name" style="color: white;class="control-label">Identifiant:</label>
												<input type="text" class="form-control" ng-model="login"
													required>
											</div>
											<div class="form-group">
												<label for="recipient-name" style="color: white;class="control-label">Profil:</label>

												<select class="form-control" ng-model="profil">
													<option ng-repeat="lp in listProfil"
														ng-selected="lp.nomProfil==profil" value="{{lp.id}}">{{lp.nomProfil}}</option>
													<select />
											</div>
											<div class="form-group">
												<label for="recipient-name" style="color: white;class="control-label">Role:</label>
												<select class="form-control" ng-model="role">
													<option ng-repeat="lr in listRoles"
														ng-selected="lr.role==role" value="{{lr.userRoleId}}">{{lr.role}}</option>
												</select>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Fermer</button>
											<button type="button" class="btn btn-primary"
												ng-click="modifierUtilisateur()" data-dismiss="modal">Modifier</button>
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
