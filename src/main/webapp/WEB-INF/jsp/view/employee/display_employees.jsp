<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns>
<head>
    <title>Employees</title>
    <style>
        ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }
    </style>
</head>

<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h1>Employees</h1></caption>
        <tr>
            <th>Name</th>
            <th>Phone Number</th>
            <th>Birthday</th>
            <th>Email</th>
            <th>Salary</th>
            <th>Department</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.name}</td>
                <td>${employee.phoneNumber}</td>
                <td>${employee.birthday}</td>
                <td>${employee.email}</td>
                <td>${employee.salary}</td>
                <td>${employee.dept.name}</td>
                <td>
                    <button>
                        <a href="/employee/show_edit_form?id=${employee.id}">edit</a>
                    </button>
                </td>
                <td>
                    <button><a href="/employee/delete_employee?id=${employee.id}">delete</a></button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <button>
        <a href="/employee/show_create_form">Create new Employee</a>
<%--        <a href="/employee/create_employee">Create new Employee</a>--%>
    </button>
    <br>
    <br>
    <button>
        <a href="/department/display_departments">List of Departments</a>
    </button>
    <br>
</div>
</body>
</html>