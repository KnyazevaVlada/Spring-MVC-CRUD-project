<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2> All Employees</h2>

<table> <%--тэг таблицы, в нем пишем все данные таблицы--%>
    <tr> <%--тэг строки таблицы--%>
        <th> <%--тэг шапки таблицы--%>
            Name
        </th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="emp" items="${allmps}">

        <%--создание ссылки,чтобы при нажатии кнопки Update вызывался метод updateEmployee()--%>
        <c:url var="updateButton" value="/updateInfo">

            <%--создание параметра с id работника, кот находится внутри ссылки--%>
            <c:param name="empID" value="${emp.id}"/>

        </c:url>
        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="empID" value="${emp.id}"/>
        </c:url>
        <tr>
            <td> <%--тег ячейки в таблице--%>
                    ${emp.name}
            </td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
                <%--создание кнопки Update, нажав на которую переходим в updateButton--%>
            <td><input type="button" name="Update"
                       onclick="window.location.href = '${updateButton}'"/>
                <input type="button" name="Delete"
                       onclick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>

</table>
<br><br>
<%--добавление кнопки add и перенаправление в метод addNewEmployee--%>
<input type="button" value="Add"
       onclick="window.location.href = 'addNewEmployee' "/>

</body>
</html>