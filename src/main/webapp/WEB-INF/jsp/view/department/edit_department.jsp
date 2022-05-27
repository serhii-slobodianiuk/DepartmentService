<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="<c:url value="/styles/form-control.css"/>"  type="text/css"/>
    <style>
<%--        <%@include file="/WEB-INF/css/form-control.css" %>--%>
    </style>
</head>
<body>
<div class="container">
    <p>
    <h1>Edit Department</h1>

    <form:form method="POST" action="/department/edit_department" modelAttribute="departmentDto">
        <form:hidden path="id" value="${dep_id}"/>

        <div class="form-group">
            <form:label path="name">Name:</form:label>
            <c:choose>
                <c:when test="${errors.hasErrors()}">
                    <form:input class="control-form" type="text" path="name"
                                placeholder="*${errors.getFieldError('name').defaultMessage}"/>
                </c:when>
                <c:otherwise>
                    <form:input class="control-form" type="text" path="name" value="${dep_name}"/>
                </c:otherwise>
            </c:choose>
        </div>

        <input type="submit" value="Save" class="btn btn-success"/>
        <br>
    </form:form>
    <div class="col-sm-7" style="margin: 20px 0px 20px 0px">
        <a class="btn btn-success" href="/department/display_departments">Display Departments</a>
    </div>
</div>
<br><br>
</body>
</html>
