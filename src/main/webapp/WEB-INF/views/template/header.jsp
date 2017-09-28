<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en" ng-app="eShoppersApp">
<!-----------------------Header Starts----------------------->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="<c:url value="/resources/favicon.ico" />"/>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>"
          rel="stylesheet"/>
    <link href="<c:url value="/resources/css/carousel.css" />"
          rel="stylesheet"/>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

    <title>eShoppers</title>
</head>
<body>
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/">eShoppers</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="/">Home</a></li>
                        <li><a href="/about">About</a></li>
                        <li><a href="/product/productList">Products</a></li>
                        <c:if test="${pageContext.request.userPrincipal.name == null}">
                            <li class="active"><a href="/login">Login</a></li>
                            <li><a href="<c:url value="/register" />">Signup</a></li>
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <li class="nav-item"><a class="nav-link" href="<c:url value="j_spring_security_logout" />">Logout</a>
                            </li>
                        </c:if>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <li><a>
                                Welcome: ${name}
                            </a></li>
                            <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
                                <li class="active">
                                    <a href="<c:url value="/customer/cart" />">
                                        <span class="glyphicon glyphicon-shopping-cart"></span>
                                        Cart
                                        <ng-pluralize count="totalCartItems()"
                                                      when="{0: ' ', 1: ' (1 item)','other':' ({{totalCartItems()}} items)'}"></ng-pluralize>
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                                <li><a href="<c:url value="/admin" />">Admin Dashboard</a></li>
                            </c:if>
                        </c:if>
                        <li class="active">
                            <a href="<c:url value="/search" />">Smart Search</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</div>
<!-----------------------Header Ends----------------------->