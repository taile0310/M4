<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/1/2023
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CALCULATOR</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<h1>CALCULATOR</h1>
<body>
<form action="/calculator">
    <input type="number" name="num1" value="num1" placeholder="Nhập số">
    <input type="number" name="num2" value="num2" placeholder="Nhập số">
    <input type="text" readonly value="${result}" name="result">
    <button class="btn btn-outline-secondary" type="submit" name="calculus" value="Addition">Addition (+)</button>
    <button class="btn btn-outline-secondary" type="submit" name="calculus" value="Subtraction">Subtraction (-)</button>
    <button class="btn btn-outline-secondary" type="submit" name="calculus" value="Multiplication">Multiplication (*)</button>
    <button class="btn btn-outline-secondary" type="submit" name="calculus" value="Division">Division (/)</button>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous">

</script>
</html>
