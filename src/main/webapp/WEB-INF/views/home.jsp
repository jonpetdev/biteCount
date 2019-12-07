<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>

    <title>Valiutos Kursai</title>
    <link href="${contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>

    <link href="${contextPath}/dist/css/datepicker.min.css" rel="stylesheet" type="text/css">
    <script src="${contextPath}/dist/js/datepicker.js"></script>


</head>

<body>


<form:form method="POST" modelAttribute="getFromPage" enctype="multipart/form-data">

    <form:input path="procSaskaita" placeholder="Procentine nuolaida saskaitai"/>

    <form:input path="procSkambuciams"  placeholder="Procentine nuolaida skambuciams"/>

    <form:input path="procSMS" placeholder="Procentine nuolaida SMS"/>

    <form:input path="file" type="file" name="file"/>


    <div class="form-group" style="margin-top: 10px">
        <button class="btn btn-success" type="submit">Submit</button>
    </div>

</form:form>

<c:if test="${not empty vidurkis}">
    <c:forEach items="${vidurkis}" var="modelis">
        <p>${modelis.imone} : ${modelis.sumaSuPVM} </p>
    </c:forEach>

    <h1>${tikrinam}</h1>
</c:if>





</body>
</html>
