<%@include file="navBar.jsp" %>
    <div class="main">
        <input type="checkbox" id="chk" aria-hidden="true">
        <div class="signup">
            <form method="post">
                <h1 style="color: #fff; font-size: 20px; margin-left: 50px;">Ajouter Utilisateur</h1><br>
                <p class="massageBox ${ status ? 'succes' : 'erreur' }">${ statusMessage }</p>
                <input type="text" name="nom" id="nom" value="${ utilisateur.nom }"
                    placeholder="Entrez votre nom..."><br>
                <span class="erreur">${ erreur.nom }</span>
                <input type="text" name="prenom" id="prenom" value="${ utilisateur.prenom }"
                    placeholder="Entrez votre prénom..."><br>
                <span class="erreur">${ erreur.prenom }</span>
                <input type="text" name="login" id="login" value="${ utilisateur.login }"
                    placeholder="Entrez votre login..."><br>
                <span class="erreur">${ erreur.login }</span>
                <input type="password" name="password" id="password" value="${ utilisateur.password }" placeholder="Entrez votre mot de passe..."><br>
                <span class="erreur">${ erreur.password }</span>
                <input type="password" name="passwordBis" id="passwordBis"
                    placeholder="Confirmez votre mot de passe..."><br>
                <input class="bart" type="submit" value="Ajouter"><br><br>
            </form>
        </div>
    </div>
    </body>

    </html>