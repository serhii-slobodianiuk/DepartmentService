<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h1>Departments</h1></caption>
        <tr>
            <th>Department</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${departments}" var="department">
            <tr>
                <td>
                    <button><a href="/employee/display_employees_by_dep_id?id=${department.id}">${department.name}</a>
                    </button>
                </td>
                <td>
                    <button><a href="/department/show_edit_form?id=${department.id}">edit</a></button>
                </td>
                <td>
                    <button><a href="/department/delete_department?id=${department.id}">delete</a></button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <button>
        <a href="/department/show_create_form">Create new Department</a>
    </button>
    <br>
    <br>
    <button>
        <a href="/employee/display_employees">List of Employees</a>
    </button>
    <br>
    <br>
</div>
</body>
</html>
