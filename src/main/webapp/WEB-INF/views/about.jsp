<%@include file="/WEB-INF/views/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <br>
            <h2>About</h2>
            <p class="lead">Welcome to eShoppers!</p>
        </div>
        <div class="container" ng-app="eShoppersCartApp">
            <div class="row">
                <h3> This is site is only for educational, practice and testing purposes.
                    <br><br></h3>
                <h4> Code of this site is available on GitHub.
                    <a href="<c:url value="
                    https://github.com/sharma-sanjeev/
                    " />"> Click here to view/download </a>
                </h4>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>