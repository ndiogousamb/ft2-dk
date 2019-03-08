<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>ACCUEIL-FT2-DAKAR</title>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/assets/css/Acue.css">
<link
	href="<%=request.getContextPath()%>/static/assets/css/bootstrap.css"
	rel="stylesheet" />

<link
	href="<%=request.getContextPath()%>/static/assets/css/font-awesome.css"
	rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="<%=request.getContextPath()%>/static/assets/css/custom.css"
	rel="stylesheet" />

</head>
<body>
	<div id="general" style="position: fixed;">
		<div id="head">
			<div class="bienvenu">
				<p>Bienvenue <c:out value="${nomComplet}"/> !</p>
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
			<img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_14.png"
				class="image14"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_12.png"
				class="image12"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_20.png"
				class="image20"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_34.png"
				class="image16"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_34.png"
				class="image18"> <a
				href="<%=request.getContextPath()%>/VenteLocale/menu"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_15.png"
				class="ventelocal">
			</a> <a href="<%=request.getContextPath()%>/exportation/menu"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_17.png"
				class="locatstock">
			</a> <a href="<%=request.getContextPath()%>/stock/"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_19.png"
				class="stock1">
			</a> <a href="<%=request.getContextPath()%>/facturation/menu"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_25.png"
				class="facturation1">
			</a> <a href="<%=request.getContextPath()%>/administration"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_28.png"
				class="admin">
			</a> <a href="#"> <img
				src="<%=request.getContextPath()%>/static/assets/img/ACCUEIL_26.png"
				class="para">
			</a>
		</div>
	</div>
	<script
		src="<%=request.getContextPath()%>static/assets/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>static/assets/js/bootstrap.min.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="<%=request.getContextPath()%>static/assets/js/custom.js"></script>


</body>
</html>
