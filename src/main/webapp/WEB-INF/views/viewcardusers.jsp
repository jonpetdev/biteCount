<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>

<jsp:include page="nav.jsp" />
<head>

    <title>Bite korteliu turetojai</title>
    <link href="${contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    <link href="${contextPath}/css/style.css" rel="stylesheet">


</head>

<body>

<div class="filter" id="filteris">
    <input type="text" id="myFilterNumeris" onkeyup="myFilterNumeris()" placeholder="Numeris.." class="filterTag">
    <input type="text" id="myFilterNaudotojas" onkeyup="myFilterNaudotojas()" placeholder="Naudotojas.." class="filterTag">
    <select class="filterTag" id="myFilterPlanas" onchange="myFilterPlanas()">
        <option value="">Planas</option>
        <c:forEach items="${communicationList}" var="planas">
            <option value="${planas.name}">${planas.name}</option>
        </c:forEach>
    </select>

    <input type="text" id="myFilterPareigybe" onkeyup="myFilterPareigybe()" placeholder="Pareigybe.." class="filterTag">

    <select class="filterTag" id="myFilterImone" onchange="myFilterImone()">
        <option value="">Įmone</option>
        <c:forEach items="${businessList}" var="imone">
            <option value="${imone.name}">${imone.name}</option>
        </c:forEach>
    </select>
</div>

<script src="${contextPath}/js/filter.js"></script>

<div class="tableBiteClient">
    <c:if test="${not empty clients}">
        <table class="table table-striped table-light" id="myTable">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Numetis</th>
                <th scope="col">Naudotojas</th>
                <th scope="col">Mokėjimo Planas</th>
                <th scope="col">Pareigybė</th>
                <th scope="col">Įmonė</th>
                <th scope="col"><button  type="button" class="btn btn-success" onclick="window.location.href='addbitecarduser'">Create User</button></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${clients}" var="clients">

                <tr>
                    <td>${clients.numeris}</td>
                    <td>${clients.naudotojas}</td>
                    <td>${clients.mokejimoPlanas}</td>
                    <td>${clients.pareigybe}</td>
                    <td>${clients.imone}</td>

                    <td>
                        <div class="btn-group">
                                <button onclick="window.location.href='viewcardusers/${clients.getId()}/delete'"  class="btn btn-danger">Delete</button>
                                <button onclick="window.location.href='viewcardusers/${clients.getId()}/update'"  class="btn btn-primary">Edit</button>
                        </div>
                    </td>


                </tr>

            </c:forEach>
            </tbody>
        </table>

    </c:if>

</div>

</body>
</html>