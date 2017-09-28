<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" ng-app="eShoppersApp">
<!-----------------------Admin Header Starts----------------------->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="<c:url value="/resources/favicon.ico" />"/>
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>"
          rel="stylesheet"/>
    <link href="<c:url value="/resources/css/dashboard.css" />"
          rel="stylesheet"/>

    <title>eShoppers</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/"><strong> eShoppers </strong></a>
            <a class="navbar-brand"> Welcome: ${name} </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/admin">Dashboard</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">Product Managment<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/admin/product/addProduct">Add Product</a></li>
                        <li><a href="/admin/productInventory">Edit/Delete Product</a></li>
                        <li><a href="/admin/product/inactiveProducts">Inactive Products</a></li>
                    </ul>
                </li>
                <li><a href="/admin/user">Users Management</a></li>
                <li><a href="/admin/order">Order Management</a></li>
                <li><a href="/admin/h2">Database Management</a></li>
                <li><a href="/j_spring_security_logout">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="/admin">
                                    Dashboard
                                </a>
                            </h4>
                        </div>
                    </div>
                </div>
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">
                                    Product Management
                                </a>
                            </h4>
                        </div>
                        <div id="collapse2" class="panel-collapse collapse">
                            <div class="panel-body">
                                <table class="table">
                                    <tr>
                                        <td><a href="/admin/product/addProduct">Add Product</a></td>
                                    </tr>
                                    <tr>
                                        <td><a href="/admin/productInventory">Edit/Delete Product</a></td>
                                    </tr>
                                    <tr>
                                        <td><a href="/admin/product/inactiveProducts">Inactive Products</a></td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="/admin/user">
                                    User Management
                                </a>
                            </h4>
                        </div>
                    </div>
                </div>
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="/admin/order">
                                    Order Management
                                </a>
                            </h4>
                        </div>
                    </div>
                </div>
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="/admin/h2">
                                    Database Management
                                </a>
                            </h4>
                        </div>
                    </div>
                </div>
                <div class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="/j_spring_security_logout">
                                    Logout
                                </a>
                            </h4>
                        </div>
                    </div>
                </div>
            </ul>
        </div>
    </div>
    <!-----------------------Admin Header Ends----------------------->
    <!-----------------------Container Starts----------------------->
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">