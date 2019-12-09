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

<div class="bitePaskirstymas">
    <div class="forma">
        <form:form class="forma1" method="POST" modelAttribute="getFromPage" enctype="multipart/form-data">

            <form:input class="formaIn" path="procSaskaita" placeholder="Procentine nuolaida saskaitai"/>

            <form:input class="formaIn" path="procSkambuciams"  placeholder="Procentine nuolaida skambuciams"/>

            <form:input class="formaIn" path="procSMS" placeholder="Procentine nuolaida SMS"/>

            <form:input  path="file" type="file" name="file"/>

            <button class="btn btn-success" type="submit">Submit</button>

        </form:form>
    </div>
</div>
<c:if test="${not empty vidurkis}">
<div class="container">

    <table class="table table-striped table-light" id="myTable">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Imonė</th>
            <th scope="col">Suma Su PVM</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${vidurkis}" var="modelis">

            <tr>
                <td>${modelis.imone}</td>
                <td>${modelis.sumaSuPVM}</td>
            </tr>

        </c:forEach>
        </tbody>
    </table>


    <h1>${tikrinam}</h1>

</div>
</c:if>



</body>
</html>
