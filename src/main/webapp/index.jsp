<%@page import="org.springframework.security.core.userdetails.User"%>
<%@page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page
	import="org.springframework.security.core.context.SecurityContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%

	if (SecurityContextHolder.getContext().getAuthentication() != null) {
		String u = SecurityContextHolder.getContext().getAuthentication().getName();
		if(u.equals("anonymousUser")){
			response.sendRedirect("user/login");
		}
		else{response.sendRedirect("accueil");
		 /* User us = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		out.println(us.getUsername()); */
		}
	
	} else {
		response.sendRedirect("user/login");
	}
%>