<%@include file="/WEB-INF/views/template/admin-header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <br>
            <h1 class="page-header">Dashboard - Administrator</h1>
            <p class="lead">Administrator's page.</p>
            <c:if test="${pageContext.request.userPrincipal.name!=null}">
                <h2><a>
                    Welcome: ${name}
                </a></h2>
                <br><br>
                <p>Over here you can manage products and view customer details.</p>
                <br><br><br>
                <h3><a href="<c:url value="/j_spring_security_logout"/> ">Logout</a>
                </h3></c:if>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/admin-footer.jsp" %>