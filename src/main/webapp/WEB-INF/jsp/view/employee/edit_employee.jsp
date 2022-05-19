<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Create</title>
</head>
<body>
<div align="center">
    <form:form method="POST" action="/employee/edit_employee" modelAttribute="employeeDto">
        <h1>Edit Employee</h1>
        <h2><p style="color:red;"><c:out value="${general_error_message}"/></p></h2>

        <form:hidden path="id" value="${id}"/>

        <form:label path="name">Name:</form:label>
        <form:input type="text" path="name"/>
        <p style="color:red;"><form:errors path="name" cssClass="errors"/></p>

        <form:label path="phoneNumber">Phone Number:</form:label>
        <form:input type="text" path="phoneNumber"/>
        <p style="color:red;"><form:errors path="phoneNumber" cssClass="errors"/></p>

        <form:label path="birthday">Birthday:</form:label>
        <fmt:formatDate value="${employeeDto.birthday}" pattern="yyyy-MM-dd" var="birthday"/>
        <form:input type="date" path="birthday" value="${birthday}"/>
        <p style="color:red;"><form:errors path="birthday" cssClass="errors"/></p>

        <form:label path="email">e_male:</form:label>
        <form:input type="text" path="email"/>
        <p style="color:red;"><form:errors path="email" cssClass="errors"/></p>

        <form:label path="salary">Salary:</form:label>
        <form:input type="text" path="salary"/>
        <p style="color:red;"><form:errors path="salary" cssClass="errors"/></p>

        <form:label path="dept">Department:</form:label>
        <form:select path="dept">
            <form:option value="${employeeDto.dept.id}" label="${employeeDto.dept.name}"/>
            <c:forEach items="${departmentDtos}" var="department">
                <c:if test="${!department.id.equals(employeeDto.dept.id)}">
                    <form:option value="${department.id}" label="${department.name}"/>
                </c:if>
            </c:forEach>
        </form:select>
        <p style="color:red;"><form:errors path="dept" cssClass="errors"/></p>

        <input type="submit" value="Save"/>
        <br><br>
        </form:form>
    <button>
        <a href="/department/display_departments">List of Departments</a>
    </button>
</div>
</body>
</html>
