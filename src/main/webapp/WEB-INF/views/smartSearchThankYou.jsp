<%@include file="/WEB-INF/views/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container"><br>
                    <h1 align="center"> Thank You </h1>
                </div>
            </div>
        </section>
        <br><br><br>
        <div class="row">
            <div class="col-sm-4 col-sm-push-4">
                <div class="text-center">
                    <a href="<spring:url value="/"/>" class="btn btn-primary">Continue Shopping</a>
                </div>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-sm-4 col-sm-push-4">
                <div class="text-center">
                    <a href="<spring:url value="/j_spring_security_logout"/>" class="btn btn-danger">Logout</a>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
