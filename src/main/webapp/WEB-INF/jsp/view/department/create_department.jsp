<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="<c:url value="/styles/form-control.css"/>"  type="text/css"/>
</head>
<body>
<div class="container">
    <p>
    <h1>Create Department</h1>

    <form:form method="POST" action="/department/create_department" modelAttribute="departmentDto">
        <div class="form-group">
            <form:label path="name">Name:</form:label>
            <form:input class="control-form" type="text" path="name"
                        placeholder="*${errors.getFieldError('name').defaultMessage}"/>
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