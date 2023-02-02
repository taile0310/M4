<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/2/2023
  Time: 1:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<center>


<form:form action="/form" modelAttribute="mailBox">
    <form:hidden path="id"></form:hidden>
    <h1>SETTING</h1>
        Languages:
    <form:select path="language">
         <form:options  items="${languagesList}"></form:options>
    </form:select>
    <br>
    Page Size:
    <form:select path="pageSize">
        <form:options  items="${pageSizes}" name="Show"></form:options>
    </form:select>
    <span>Email per page</span>
    <br>
    Spams Filter: <form:checkbox path="spamsFilter"></form:checkbox>Enable spams filter
    <br>
    Signature: <form:textarea path="signature"></form:textarea>
    <br>
    <button type="submit">Update</button>
    <button type="submit">Cancel</button>
</form:form>
</center>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous">
</script>
</html>
