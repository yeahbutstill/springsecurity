<%--
  Created by IntelliJ IDEA.
  User: yeahbutstill
  Date: 10/23/22
  Time: 7:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h2>ECorp Home Page</h2>
    <hr>
    <em>Welcome to the jungle bitch!</em>
    <hr>
    <%--  display username and role  --%>
    <p>
        User: <security:authentication property="principal.username" />
        <br>
        <br>
        Role: <security:authentication property="principal.authorities" />
    </p>
    <hr>

    <%-- Add a link to point to /gssk ... this is for the BPR   --%>
    <security:authorize access="hasRole('BPR')">
        <p>
            <a href="${pageContext.request.contextPath}/gssk ">GSSK BPR</a>
            (Only for BPR peeps)
        </p>
    </security:authorize>

    <%-- Add a link to point to /gamr ... this is for the PELAKSANA   --%>
    <security:authorize access="hasRole('PELAKSANA')">
        <p>
            <a href="${pageContext.request.contextPath}/gamr ">GAMR PELAKSANA</a>
            (Only for GAMR peeps)
        </p>
    </security:authorize>

    <hr>

    <%--  Add a logout button  --%>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout" />
    </form:form>

</body>
</html>
