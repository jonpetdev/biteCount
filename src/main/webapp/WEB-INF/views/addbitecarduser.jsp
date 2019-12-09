<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>

<jsp:include page="nav.jsp" />

<head>


    <title>Pridėti Bitės Naudotoja</title>
    <link href="${contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    <link href="${contextPath}/css/style.css" rel="stylesheet">


</head>

<body>

<div class="container">
    <form:form class="form-horizontal" method="POST" modelAttribute="addBiteForm" >

        <form:hidden path="id"></form:hidden>

        <div class="form-group">
            <label class="col-sm-2 control-label">Numeris</label>
            <div class="col-sm-10">
                <form:input path="numeris" type="number" class="form-control " placeholder="tel. numeris"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">Naudotojas</label>
            <div class="col-sm-10">
                <form:input path="naudotojas" type="text" class="form-control " placeholder="Vardas Pavardė"/>
            </div>
        </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Planas</label>
                <div class="col-sm-10">
                    <form:select path="mokejimoPlanas" type="text" class="form-control " id="mokejimoPlanas">
                        <form:options items="${communicationList}" itemValue="name" itemLabel="name"/>
                    </form:select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Pareigybė</label>
                <div class="col-sm-10">
                    <form:input path="pareigybe"  type="text" class="form-control " placeholder="Pareigybė"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Įmonė</label>
                <div class="col-sm-10">
                    <form:select path="imone" type="text" class="form-control " id="imone">
                        <form:options items="${businessList}" itemValue="name" itemLabel="name"/>
                    </form:select>
                </div>
            </div>


        <div class="form-group" style="margin-top: 10px">
            <button class="btn btn-success" type="submit">Submit</button>
        </div>

    </form:form>
</div>

</body>
</html>