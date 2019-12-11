<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>



<div class="navbar1">
    <div class="navbar2">
        <a href="#home">Menu1</a>
        <a href="#news">Meniu2</a>
        <div class="dropdown1">
            <button class="dropbtn1">Bitė<i class="fa fa-caret-down"></i></button>
            <div class="dropdown-content1">
                <a href="${contextPath}/home">Bitės sąskaitos paskirstymas</a>
                <a href="${contextPath}/viewnaudotojai">Bitės naudotojų sarašas</a>
                <a href="${contextPath}/viewlimitai">Bitės limitai</a>
            </div>
        </div>
    </div>
</div>

