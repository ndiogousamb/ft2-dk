<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>CONNEXION-FT2-DAKAR</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/assets/js/sweetalert.css">
<!-- BOOTSTRAP STYLES-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/assets/css/page.css">
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
<body onload='document.loginForm.username.focus();' width="100%" />

<div id="GE">
	<div class="forml-img">
		<img
			src="<%=request.getContextPath()%>/static/assets/img/LOGO_FT2_DAKAR.png"
			width="95%" />
	</div>
	<form method="POST">

		<div class="forml" style="margin: 0 auto;">

			<input class="InputId" placeholder="Identifiant" type="text"
				name="username" required /> <br />
			<!-- 	/****************************/ -->
			<c:if test="${not empty error}">
				<div class="alert alert-danger">
					<strong>Erreur! Identifiant ou mot de passe incorrect</strong>
				</div>
			</c:if>


			<!-- /***************************/ 
			 -->
			<input class="InputMdp" placeholder="Mot de passe" type="password"
				name="password" required /> <br /> <a href="#"><img
				style="margin-left: 67%;"
				src="<%=request.getContextPath()%>/static/assets/img/MOT_DE_PASSE_OUBLIE.png"
				width="32%" /></a> <br /> <br />
			<center>
				<button class="BtnSC" type="submit" value="">SE CONNECTER</button>
			</center>
			<br>
			<center>
				<button class="BtnEN"
					onclick="location.href='<%=request.getContextPath()%>/user/sincrire'"
					type="submit">S'ENREGISTRER</button>
			</center>
		</div>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		<c:if test="${not empty msg}">
			<%-- <div class="msg">${msg}</div> --%>
		</c:if>

	</form>

</div>
<!-- /. WRAPPER  -->
<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
<!-- JQUERY SCRIPTS -->
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
