<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr-FR">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="css/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mon site web</title>
</head>

<body>
    <nav class="navbar">
        <h3><span>My</span> LOGO</h3>
        <c:choose>
        	<c:when test="${ sessionScope.isConnected }">
        		<ul>
        			<li class="active"><a href="/gestionUsers/">Accueil</a></li>
            		<li><a href="list">Lister</a></li>
            		<li><a href="add">Ajouter</a></li>
        		</ul>
		        <div class="buttons">
		            <a href="logout" class="button">Logout</a>
		        </div>
        	</c:when>
        	<c:otherwise>
		        <div class="buttons">
		            <a href="login" class="button">Login</a>
		        </div>
        	</c:otherwise>
        </c:choose>
            
    </nav>