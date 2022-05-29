<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html xmlns>
<head>
    <title>Employees</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<c:url value="/styles/display_table.css"/>"  type="text/css"/>
</head>
<body>
<div class="container">
    <p>
    <h1>Employees</h1>

    <table id="display-table">
        <colgroup>
            <col style="width:15%">
            <col style="width:15%">
            <col style="width:15%">
            <col style="width:15%">
            <col style="width:15%">
            <col style="width:15%">
            <col style="width:3%">
            <col style="width:3%">
        </colgroup>
        <tr align="left">
            <th class="cell-border-left">Name</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Birthday</th>
            <th>Salary</th>
            <th>Department</th>
            <th></th>
            <th class="cell-border-right"></th>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td align="left" class="cell-border-left">${employee.name}</td>
                <td align="left">${employee.phoneNumber}</td>
                <td align="left">${employee.email}</td>
                <td align="left">${employee.birthday}</td>
                <td align="left">$${employee.salary}</td>
                <td align="left">${employee.dept.name}</td>
                <td><a class="fa fa-edit edit-control" href="/employee/show_edit_form?id=${employee.id}"></a></td>
                <td class="cell-border-right"><a class="fa fa-trash delete-control" href="/employee/delete_employee?id=${employee.id}"></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<div align="center">
    <a class="btn btn-success" href="/employee/show_create_form">Create Employee</a>
    <a class="btn btn-success" href="/department/display_departments">Display Departments</a>
</div>
<br><br>
</body>
</html>