<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Create</title>
</head>
<body>
<div align="center">
    <form:form method="POST" action="/department/create_department" modelAttribute="departmentDto">
        <caption><h1>Create Department</h1></caption>
        <h2><p style="color:red;"><c:out value="${general_error_message}"/></p></h2>
        <form:label path="name">Name:</form:label>
        <form:input type="text" path="name"/>
        <p style="color:red;"><form:errors path="name" cssClass="errors"/></p>
        <input type="submit" value="Save"/>
        <br><br>
    </form:form>
    <button>
        <a href="/department/display_departments">List of Departments</a>
    </button>
</div>
</body>
</html>
