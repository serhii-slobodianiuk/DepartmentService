<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="<c:url value="/styles/form-control.css"/>"  type="text/css"/>
</head>
<body>
<div class="container">
    <p>
    <h1>Edit Employee</h1>

    <form:form method="POST" action="/employee/edit_employee" modelAttribute="employeeDto">
        <form:hidden path="id" value="${id}"/>

        <div class="form-group">
            <form:label path="name">Name:</form:label>
            <c:choose>
                <c:when test="${errors.hasErrors()}">
                    <form:input class="control-form" type="text" path="name"
                                placeholder="*${errors.getFieldError('name').defaultMessage}"/>
                </c:when>
                <c:otherwise>
                    <form:input class="control-form" type="text" path="name"/>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="form-group">
            <form:label path="phoneNumber">Phone Number:</form:label>
            <c:choose>
                <c:when test="${errors.hasErrors()}">
                    <form:input class="control-form" type="text" path="phoneNumber"
                                placeholder="*${errors.getFieldError('phoneNumber').defaultMessage}"/>
                </c:when>
                <c:otherwise>
                    <form:input class="control-form" type="text" path="phoneNumber"/>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="form-group">
            <form:label path="email">e_male:</form:label>
            <c:choose>
                <c:when test="${errors.hasErrors()}">
                    <form:input class="control-form" type="text" path="email"
                                placeholder="*${errors.getFieldError('email').defaultMessage}"/>
                </c:when>
                <c:otherwise>
                    <form:input class="control-form" type="text" path="email"/>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="form-group">
            <form:label path="birthday">Birthday:</form:label>
            <fmt:formatDate value="${employeeDto.birthday}" pattern="yyyy-MM-dd" var="birthday"/>
            <form:input type="date" path="birthday" value="${birthday}" class="form-control"/>
        </div>

        <div class="form-group">
            <form:label path="salary">Salary:</form:label>
            <form:input type="text" path="salary" class="form-control"/>
        </div>

        <div class="form-group">
            <form:label path="dept">Department:</form:label>
            <form:select path="dept" class="form-control">
                <form:option value="${employeeDto.dept.id}" label="${employeeDto.dept.name}"/>
                <c:forEach items="${departmentDtos}" var="department">
                    <c:if test="${!department.id.equals(employeeDto.dept.id)}">
                        <form:option value="${department.id}" label="${department.name}"/>
                    </c:if>
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
