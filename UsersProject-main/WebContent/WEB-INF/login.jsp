<%@include file="navBar.jsp" %>
    <div class="main">
        <input type="checkbox" id="chk" aria-hidden="true">
        <div class="signup">
            <form method="post">
    		<h1 style="color: #fff; font-size: 20px; margin-left: 50px;">Page de Connexion</h1><br>
    		<c:if test="${ loginFailled == true }">
            	<span class="erreur">Login et ou mot de passe incorrect</span>
            </c:if>
            <input type="text" name="login" id="login" required="required" value="${login}" placeholder="Entrez votre login..."><br>
            <input type="password" name="password" id="password" required="required" placeholder="Entrez votre mot de passe..."><br>
            <input class="bart" type="submit" value="Ajouter"><br><br><br>
            </form>
        </div>
    </div>
</body>
</html>