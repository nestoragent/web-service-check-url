<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>

<form:form method="GET" modelAttribute="linkForCheck" action="check">
    <table>
        <tr>
            <td>
                <label for="link"> Input link</label>
                <form:input type="text" id="link" path="link"/>
            </td>
            <td>
                <input type="submit" value="Check url">
            </td>
        </tr>
    </table>
</form:form>

<%--<form action="#" th:action="@{/check}" th:object="${link}" method="post">--%>
<%--<p>Link: <input type="text" th:field="*{link}" /></p>--%>
<%--<p><input type="submit" value="Submit" />--%>
<%--</form>--%>
<p> status: ${status} </p>

</body>
</html>
