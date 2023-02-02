<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/2/2023
  Time: 11:21 AM
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
<form action="/showList">
    <h1 class="d-flex justify-content-center">LIST</h1>
    <table class="d-flex justify-content-center table-view table-bordered">
        <tr>
            <th>STT</th>
            <th>Languages</th>
            <th>Page Sizes</th>
            <th>Spam Filter</th>
            <th>Signature</th>
            <th>Update</th>
        </tr>
        <c:forEach var="mailbox" items="${mailBoxList}" varStatus="stt">
            <tr>
                <td>${stt.count}</td>
                <td>${mailbox.language}</td>
                <td>${mailbox.pageSize}</td>
                <td>${mailbox.spamsFilter}</td>
                <td>${mailbox.signature}</td>
                <td>
                    <a class="btn btn-outline-secondary" type="submit" href="/form?id=${mailbox.id}">Update</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous">
</script>
</html>
