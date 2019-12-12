<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>

<jsp:include page="nav.jsp" />

<head>

    <title>Pirmas</title>
    <link href="${contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    <link href="${contextPath}/css/style.css" rel="stylesheet">


</head>
<body>
<div class="tableBiteClient">

    <table class="table table-striped table-light" >
        <thead class="thead-dark">
        <tr>

            <th scope="col">Sk LT</th>
            <th scope="col">Sk UZ</th>
            <th scope="col">sms LT</th>
            <th scope="col">sms UZ</th>
            <th scope="col">Internetas</th>
            <th scope="col">Kitos</th>
            <th scope="col">Automobilio statymas</th>
            <th scope="col">
          <!--      <button  type="button" class="btn btn-success" onclick="window.location.href='addlimitai'">Create Limits</button>  -->
            </th>

        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty limit}">
        <c:forEach items="${limit}" var="limit">
        <tr>
                <td style="text-align: center">
                   ${limit.skambLT}
                </td>
                <td style="text-align: center">
                    ${limit.skambUZ}
                </td>
                <td style="text-align: center">
                    ${limit.smsLT}
                </td>
                <td style="text-align: center">
                    ${limit.smsUZ}
                </td>
                <td style="text-align: center">
                    ${limit.internetas}
                </td>
                <td style="text-align: center">
                    ${limit.kitos}
                </td>
                <td style="text-align: center">
                    ${limit.stovejimas}
                </td>
                <td>
                    <div class="btn-group">
                     <!--   <button onclick="window.location.href='limitaiview/${limit.getId()}/delete'"  class="btn btn-danger">Delete</button> -->
                    <button onclick="window.location.href='limitaiview/${limit.id}/update'"  class="btn btn-primary">Edit</button>
                    </div>
                </td>
        </tr>
        </c:forEach>
        </c:if>
        </tbody>
    </table>

</div>


</body>
</html>