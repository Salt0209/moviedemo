<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Movies</title>
</head>
<body>
    <h2>List of Movies</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Year of Release</th>
            <th colspan="2">Action</th>
        </tr>
        <c:forEach var="movie" items="${movies}">
            <tr>
                <td>${movie.id}</td>
                <td>${movie.title}</td>
                <td>${movie.genre}</td>
                <td>${movie.yearOfRelease}</td>
                <td><a href="${pageContext.request.contextPath}/movies/edit/${movie.id}">Edit</a></td>
                <td><a href="${pageContext.request.contextPath}/movies/delete/${movie.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/movies/add">Create</a>
    
</body>
</html>
