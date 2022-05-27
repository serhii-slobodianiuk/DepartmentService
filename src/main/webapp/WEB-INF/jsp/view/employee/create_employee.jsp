<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Create Employee</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="<c:url value="/styles/form-control.css"/>"  type="text/css"/>
</head>
<body>
<div class="container">
    <p>
    <h1>Create Employee</h1>

    <form:form method="POST" action="/employee/create_employee" modelAttribute="employeeDto">
        <div class="form-group">
            <form:label path="name">Name:</form:label>
            <form:input type="text" path="name" class="control-form" placeholder="*${errors.getFieldError('name').defaultMessage}"/>
        </div>

        <div class="form-group">
            <form:label path="phoneNumber">Phone Number:</form:label>
            <form:input type="text" path="phoneNumber" class="control-form"
                        placeholder="*${errors.getFieldError('phoneNumber').defaultMessage}"/>
        </div>

        <div class="form-group">
            <form:label path="email">Email:</form:label>
            <form:input type="text" path="email" class="control-form"
                        placeholder="*${errors.getFieldError('email').defaultMessage}"/>
        </div>

        <div class="form-group">
            <label for="birthday">Birthday:</label>
            <input type="date" name="birthday" id="birthday" class="control-form" value="2022-02-02"/>
        </div>

        <div class="form-group">
            <form:label path="salary">Salary:</form:label>
            <form:input type="text" path="salary" class="control-form"/>
        </div>

        <div class="form-group">
            <form:label path="dept">Department:</form:label>
            <form:select path="dept" class="control-form">
                <c:forEach items="${departments}" var="department">
                    <form:option value="${department.id}" label="${department.name}"/>
                </c:forEach>
            </form:select>
        </div>

        <input type="submit" value="Save" class="btn btn-success"/>
        <br>
    </form:form>
    <div class="col-sm-7" style="margin: 20px 0px 20px 0px">
        <a class="btn btn-success" href="/employee/display_employees">Display Employees</a>
    </div>
</div>
<br><br>
</body>
</html>