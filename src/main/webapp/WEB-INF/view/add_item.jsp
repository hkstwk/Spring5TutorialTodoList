<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="nl.kolvoort.udemy.spring5.util.AttributeNames" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add item</title>
</head>
<body>
    <div align="center">
        <form:form method="POST" modelAttribute="${AttributeNames.TODO_ITEM">

        </form:form>
    </div>
</body>
</html>