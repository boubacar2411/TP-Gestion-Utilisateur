<%@page import="beans.*" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="navBar.jsp" %>
    	<div class="main">
        	<input type="checkbox" id="chk" aria-hidden="true">
        	<div class="signup">
            <form method="post">
                <h1 style="color: #fff; font-size: 20px; margin-left: 50px;">Modifier Utilisateur</h1><br>
                <input type="text" name="nom" id="nom" value="${ utilisateur.nom }"><br>
                <input type="text" name="prenom" id="prenom" value="${ utilisateur.prenom }""><br>
                <input type="text" name="login" id="login" value="${ utilisateur.login }""><br>
                <input type="password" name="password" id="password" value="${ utilisateur.password }" ><br>
                <input class="bart" type="submit" value="Ajouter"><br>
            </form>
    	</div>
	</body>
</html>