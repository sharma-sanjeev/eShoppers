<%@include file="/WEB-INF/views/template/header.jsp" %>
<!-----------------------Checkout Cancelled Starts----------------------->
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1 class="alert alert-danger">Checkout cancelled.</h1>
                    <p>Your checkout process is cancelled. You may continue shopping.</p>
                </div>
            </div>
        </section>
        <section class="container">
            <p class="pull-left">
                <a href="<spring:url value="/customer/cart" />" class="btn btn-success">
                    <span class="glyphicon-hand-left glyphicon"></span> View Cart </a>
            </p>
            <p class="pull-right">
                <a href="<spring:url value="/product/productList" />" class="btn btn-success"> Continue Shopping <span
                        class="glyphicon-hand-right glyphicon"></span></a>
            </p>
        </section>
    </div>
</div>
<!-----------------------Checkout Cancelled Ends----------------------->
<%@include file="/WEB-INF/views/template/footer.jsp" %>