<%@page import="dao.UtilisateurDao" %>
    <%@page import="beans.Utilisateur" %>
        <%@page import="java.util.ArrayList" %>
            <%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
                <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
                    <%@include file="navBar.jsp" %>
                        <h1>Liste des utilisateurs</h1>
                        <c:choose>
                            <c:when test="${ empty utilisateurs }">
                                <p>La liste des utilisateurs est vide</p>
                            </c:when>
                            <c:otherwise>
                                <table>
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nom</th>
                                            <th>Prenom</th>
                                            <th>Login</th>
                                            <th>Password</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="utilisateur" items="${ utilisateurs }">
                                            <tr>
                                                <td>
                                                    <c:out value="${utilisateur.id}" />
                                                </td>
                                                <td>
                                                    <c:out value="${utilisateur.nom}" />
                                                </td>
                                                <td>
                                                    <c:out value="${utilisateur.prenom}" />
                                                </td>
                                                <td>
                                                    <c:out value="${utilisateur.login}" />
                                                </td>
                                                <td>
                                                    <c:out value="${utilisateur.password}" />
                                                </td>
                                                <td>
                                                    <a href="modifier?id=${utilisateur.id}">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                            fill="currentColor" class="bi bi-arrow-clockwise"
                                                            viewBox="0 0 16 16">
                                                            <path fill-rule="evenodd"
                                                                d="M8 3a5 5 0 1 0 4.546 2.914.5.5 0 0 1 .908-.417A6 6 0 1 1 8 2v1z" />
                                                            <path
                                                                d="M8 4.466V.534a.25.25 0 0 1 .41-.192l2.36 1.966c.12.1.12.284 0 .384L8.41 4.658A.25.25 0 0 1 8 4.466z" />
                                                        </svg>
                                                    </a>
                                                </td>
                                                <td>
                                                    <a href="supprimer?id=${utilisateur.id}"
                                                        onclick="return confirm('En êtes vous sûr?')">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                            fill="currentColor" class="bi bi-trash3-fill"
                                                            viewBox="0 0 16 16">
                                                            <path
                                                                d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5Zm-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5ZM4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06Zm6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528ZM8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5Z" />
                                                        </svg>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </c:otherwise>
                        </c:choose>
                        </body>

                        </html>