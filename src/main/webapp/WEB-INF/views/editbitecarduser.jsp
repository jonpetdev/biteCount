<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>

<jsp:include page="nav.jsp" />

<head>

    <title>Valiutos Kursai</title>
    <link href="${contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    <link href="${contextPath}/css/style.css" rel="stylesheet">


</head>

<body>

<div class="container">
    <spring:url value="/editbitecarduser" var="userActionUrl" />

    <form:form class="form-horizontal" method="POST" modelAttribute="editBiteForm" action="${userActionUrl}">

        <form:hidden path="id" />

        <spring:bind path="numeris">
            <div class="form-group">
                <label class="col-sm-2 control-label">Numeris</label>
                <div class="col-sm-10">
                    <form:input path="numeris" type="text" class="form-control " id="numeris" placeholder="Tel. numeris"/>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="naudotojas">
            <div class="form-group">
                <label class="col-sm-2 control-label">Naudotojas</label>
                <div class="col-sm-10">
                    <form:input path="naudotojas" type="text" class="form-control " id="naudotojas" placeholder="Vardas Pavardė" />
                </div>
            </div>
        </spring:bind>


        <spring:bind path="mokejimoPlanas">
            <div class="form-group ">
                <label class="col-sm-2 control-label">Mokėjimo planas</label>
                <div class="col-sm-10">
                    <form:select path="mokejimoPlanas" type="text" class="form-control " id="mokejimoPlanas">
                        <form:options items="${communicationList}" itemValue="name" itemLabel="name"/>
                    </form:select>
                </div>
            </div>
        </spring:bind>

        <spring:bind path="pareigybe">
            <div class="form-group">
                <label class="col-sm-2 control-label">Darbuotojo pareigybė</label>
                <div class="col-sm-10">
                    <form:input path="pareigybe" type="text" class="form-control " id="pareigybe" placeholder="Pareigybė" />
                </div>
            </div>
        </spring:bind>

        <spring:bind path="imone">
            <div class="form-group">
                <label class="col-sm-2 control-label">Įmonė</label>
                <div class="col-sm-10">
                    <form:select path="imone" type="text" class="form-control " id="imone">
                        <form:options items="${businessList}" itemValue="name" itemLabel="name"/>
                    </form:select>
                </div>
            </div>
        </spring:bind>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn-lg btn-primary pull-right">Update</button>
            </div>
        </div>

    </form:form>
</div>

</body>
</html>