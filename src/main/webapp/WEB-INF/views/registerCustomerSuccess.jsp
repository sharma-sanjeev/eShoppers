<%@include file="/WEB-INF/views/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Customer registration successful</h1>
                </div>
            </div>
        </section>
        <section>
            <div class="row">
                <div class="col-sm-12">
                    <div class="text-center">
                        <p>
                            <a href="<spring:url value="/login"/>" class="btn btn-default btn-success">
                                Login Now <span class="glyphicon-hand-right glyphicon"></span>
                            </a>
                        </p>

                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
