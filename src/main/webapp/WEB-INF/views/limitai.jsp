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
            <th scope="col"></th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <spring:url value="/limitai" var="userActionUrl" />

            <form:form class="forma1" method="POST" modelAttribute="limitaiForm" action="${userActionUrl}" >
                <form:hidden path="id" />


                <spring:bind path="skambLT">
                    <td style="text-align: center">
                        <form:input path="skambLT" type="text"  id="skambLT" class="form-control " placeholder="skamb LT"/>
                    </td>
                </spring:bind>


                <spring:bind path="skambUZ">
                    <td style="text-align: center">
                        <form:input path="skambUZ" type="text" id="skambUZ" class="form-control " placeholder="skamb UZ"/>
                    </td>
                </spring:bind>

                <spring:bind path="smsLT">
                    <td style="text-align: center">
                        <form:input path="smsLT" type="text" id="smsLT" class="form-control " placeholder="sms LT"/>
                    </td>
                </spring:bind>


                <spring:bind path="smsUZ">
                    <td style="text-align: center">
                        <form:input path="smsUZ" type="text" id="smsUZ" class="form-control " placeholder="sms Uz"/>
                    </td>
                </spring:bind>

                <spring:bind path="internetas">
                    <td style="text-align: center">
                        <form:input path="internetas" type="text" id="internetas" class="form-control " placeholder="internetas"/>
                    </td>
                </spring:bind>

                <spring:bind path="kitos">
                    <td style="text-align: center">
                        <form:input path="kitos" type="text" id="kitos" class="form-control " placeholder="kitos"/>
                    </td>
                </spring:bind>


                <spring:bind path="stovejimas">
                    <td style="text-align: center">
                        <form:input path="stovejimas" type="text" id="stovejimas" class="form-control " placeholder="stovejimas"/>
                    </td>
                </spring:bind>

                <td>
                    <button type="submit" class="btn-lg btn-primary pull-right">Save</button>
                </td>
            </form:form>
        </tr>
        </tbody>
    </table>
                        
</div>


</body>
</html>