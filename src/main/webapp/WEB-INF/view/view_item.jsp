<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="nl.kolvoort.udemy.spring5.util.Mappings" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View item</title>
</head>
<body>
    <div align="center">
        <table>
            <tr>
                <td><label>ID</label></td>
                <td>
                    <c:out value="${todoItem.id}"/>
                </td>
            </tr>
            <tr>
                <td><label>Title</label></td>
                <td><c:out value="${todoItem.title}"/></td>
            </tr>
            <tr>
                <td><label>Deadline</label></td>
                <td><c:out value="${todoItem.deadline}"/></td>
            </tr>
            <tr>
                <td><label>Details</label></td>
                <td><c:out value="${todoItem.details}"/></td>
            </tr>
        </table>
        <p>
        <c:url var="itemsLink" value="${Mappings.ITEMS}"/>
        <a href="${itemsLink}">Show Todo Items</a>

    </div>
</body>
</html>