
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html ng-app="ImportExport">
<head>
<meta charset="utf-8" />
<meta ng-model="viewport"
	content="width=device-width, initial-scale=1.0" />
<title>INSCRIPTION-FT2-DAKAR</title>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/assets/js/sweetalert.css">

<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<link href="<%=request.getContextPath()%>/static/assets/css/form2.css"
	rel="stylesheet" />
</head>
<body ng-controller="ImportExportController">

	<div id="GE">
		<div id="gauche"></div>
		<div id="droite">
			<form>
				<img class="insc"
					src="<%=request.getContextPath()%>/static/assets/img/FORMULAIRE-INSCRIPTION_03.png">
				<img class="insc2"
					src="<%=request.getContextPath()%>/static/assets/img/FORMULAIRE-INSCRIPTION_06.png">
				<p class="pre">Prenom(s) &</p>
				<p class="nom">Nom*</p>
				<input class="inp" type="text" ng-model="nomComplet" ng-readonly="verrou"/>
				<p class="identifiant">Identifiant*</p>
				<input class="inp1" type="text" ng-model="login" ng-change="verifierLogin()" ng-model-options="{debounce: 1000}"/>
				<p class="motdepasse">Mot de passe*</p>
				<input class="inp2" type="password" ng-model="password" ng-readonly="verrou"/>
				<p class="confir">Confirmation</p>
				<p class="depass">de mot passe*</p>
				<input class="inp3" type="password" ng-model="Confpassword" ng-readonly="verrou"/>
				<p class="profil">Profil*</p>
				<div id="sele1">
					<select ng-model="profil" ng-disabled="verrou">
						<option value="" disabled selected>Choisir Le Profil</option>
						<c:forEach items="${listProfils}" var="l">
							<option value="${l.id}">${l.nomProfil}</option>
						</c:forEach>
					</select>
				</div>
				<p class="role">Role*</p>
				<div id="sele2">
					<select ng-model="role" class="form-control" ng-disabled="verrou">
						<option value="" disabled selected>Choisir Le Role</option>
						<c:forEach items="${listRoles}" var="l">
							<option value="${l.userRoleId}">${l.role}</option>
						</c:forEach>
					</select>
				</div>
				<div id="bas">
					<button class="BtnAN" type="submit"
						onclick="location.href='<%=request.getContextPath()%>'">ANNULER</button>
					<button class="BtnIN" ng-click="validerInscription()" type="submit">S'INSCRIRE</button>
				</div>
			</form>
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
		src="<%=request.getContextPath()%>/static/assets/js/materialize.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/assets/js/materialize.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/static/assets/js/sweetalert.min.js"></script>


</body>
</html>






