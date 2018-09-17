<%--
  Created by IntelliJ IDEA.
  User: aramirez
  Date: 12/09/2018
  Time: 18:18
  To change this template use File | Settings | File Templates.

<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="#">Spring Boot</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" cata-target="#navbarExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false"
    <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active"><a class="nav-link" href="#">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="#about">About</a></li>
        </ul>
    </div>

</nav>
<div class="container">
    <div class="jumbotron">
        <h1 class="display-3">bjm,m<c:out value="${titulo}"/></h1>
        <h2>${mensaje}</h2>
    </div>
</div>
<div class="container">
    <hr>
    <footer>
        &copy; Company 2018
    </footer>
</div>
</body>
</html>
