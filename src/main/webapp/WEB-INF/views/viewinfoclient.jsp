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
    <c:if test="${not empty listas}">
        <table class="table table-striped table-light" id="myTable">
            <thead class="thead-dark">
            <tr>
                <th scope="col">Numetis</th>
                <th scope="col">Naudotojas</th>
                <th scope="col">Imone</th>
                <th scope="col">Planas</th>
                <th scope="col">Sk LT</th>
                <th scope="col">Sk UZ</th>
                <th scope="col">sms LT</th>
                <th scope="col">sms UZ</th>
                <th scope="col">Internetas</th>
                <th scope="col">Kitos</th>
                <th scope="col">Automobilio statymas</th>
                <th scope="col">Suma su PVM</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listas}" var="clients">



                <tr>
                    <td>${clients.numeris}</td>
                    <td>${clients.naudotojas}</td>
                    <td>${clients.imone}</td>
                    <td>${clients.planas}</td>
                    <td style="text-align: center" id="skamblt${clients.numeris}">${clients.skambLT}</td>
                    <td style="text-align: center" id="skambuz${clients.numeris}">${clients.skambUZ}</td>
                    <td style="text-align: center" id="smslt${clients.numeris}">${clients.smsLT}</td>
                    <td style="text-align: center" id="smsuz${clients.numeris}">${clients.smsUZ}</td>
                    <td style="text-align: center" id="internetas${clients.numeris}">${clients.internetas}</td>
                    <td style="text-align: center" id="kitos${clients.numeris}">${clients.kitos}</td>
                    <td style="text-align: center" id="stovejimas${clients.numeris}">${clients.stovejimas}</td>
                    <td style="text-align: center">${clients.sumaSuPVM}</td>

                </tr>

                <script>
                        if(${clients.skambLT}>${limitas.skambLT}){
                            document.getElementById("skamblt${clients.numeris}").style.color = "red";
                        }
                        if(${clients.skambUZ}>${limitas.skambUZ}){
                            document.getElementById("skambuz${clients.numeris}").style.color = "red";
                        }
                        if(${clients.smsLT}>${limitas.smsLT}){
                            document.getElementById("smslt${clients.numeris}").style.color = "red";
                        }
                        if(${clients.smsUZ}>${limitas.smsUZ}){
                            document.getElementById("smsuz${clients.numeris}").style.color = "red";
                        }
                        if(${clients.internetas}>${limitas.internetas}){
                            document.getElementById("internetas${clients.numeris}").style.color = "red";
                        }
                        if(${clients.kitos}>${limitas.kitos}){
                            document.getElementById("kitos${clients.numeris}").style.color = "red";
                        }
                        if(${clients.stovejimas}>${limitas.stovejimas}){
                            document.getElementById("stovejimas${clients.numeris}").style.color = "red";
                        }
                </script>
            </c:forEach>
            </tbody>
        </table>

    </c:if>

</div>


</body>
</html>