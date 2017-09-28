<%@include file="/WEB-INF/views/template/header.jsp" %>
<!-----------------------Checkout Page Five: Thank Customer Starts----------------------->
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container"><br>
                    <h1>You placed the order successfully!</h1>
                    <p>Your order will be shipped within two business days.</p>
                </div>
            </div>
        </section>
        <div class="row text-center">
            <div class="row">
                <h2>Participate and win a Apple iPhone 7 Plus.</h2>
                <br>
                <div class="col-sm-4 col-sm-push-4 text-center">
                    <a href="<spring:url value="/search/input"/>" class="btn btn-success"> Participate! </a>
                </div>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-sm-4 col-sm-push-4 text-center">
                <a href="<spring:url value="/"/>" class="btn btn-primary"> Continue Shopping </a>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-sm-4 col-sm-push-4 text-center">
                <a href="<spring:url value="/j_spring_security_logout"/>" class="btn btn-danger"> Logout </a>
            </div>
        </div>
    </div>
</div>
<!-----------------------Checkout Page Five: Thank Customer Ends----------------------->
<%@include file="/WEB-INF/views/template/footer.jsp" %>