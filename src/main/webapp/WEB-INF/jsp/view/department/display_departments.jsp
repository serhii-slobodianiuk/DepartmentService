<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head >
    <title id="title">Department Service</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="<c:url value="/styles/display_table.css"/>"  type="text/css"/>
</head>
<body>
<div class="container">
    <p>
    <h1>Departments</h1>

    <table id="display-table">
        <colgroup>
            <col style="width:94%">
            <col style="width:3%">
            <col style="width:3%">
        </colgroup>

        <c:forEach items="${departments}" var="department">
            <tr>
                <td align="left" class="cell-border-left"><a href="/employee/display_employees_by_dep_id?id=${department.id}">${department.name}</a></td>
                <td><a class="edit-control fa fa-edit" href="/department/show_edit_form?id=${department.id}"></a></td>
                <td class="cell-border-right"><a class="delete-control fa fa-trash" href="/department/delete_department?id=${department.id}"></a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<div align="center">
    <a class="btn btn-success" href="/department/show_create_form">Create Department</a>
    <a class="btn btn-success" href="/employee/display_employees">Display Employees</a>
</div>
<br><br>
</body>
</html>
