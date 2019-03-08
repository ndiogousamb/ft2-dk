<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8" />
<meta ng-model="viewport"
	content="width=device-width, initial-scale=1.0" />
<title>ACCES REFUGE -FT2-DAKAR</title>
<link href="<%=request.getContextPath()%>/static/assets/css/403.css"
	rel="stylesheet" />
</head>
<body>
	<center>
		<h1 style="color: white; margin-top: 250px;">Votre profil ne dispose pas des privilèges pour acceder à cette!</h1>
	</center>

	<c:choose>
		<c:when test="${empty username}">
			<h2 style="color: white"> <center> Veuillez contacter l'Administrateur!</center></h2>
		</c:when>
		<c:otherwise>
			<div id="h2Amodif">
				<h2 style="color: white;margin-left: 100px;">
					Username : ${username} <br /> Veuillez contacter l'Administrateur!
				</h2>
			</div>
		</c:otherwise>
	</c:choose>

</body>
</html>