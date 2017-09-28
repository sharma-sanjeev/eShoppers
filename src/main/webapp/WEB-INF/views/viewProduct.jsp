<%@include file="/WEB-INF/views/template/header.jsp" %>
<!-----------------------View Products Starts----------------------->
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <br>
            <h2>Product Detail</h2>
            <p class="lead">Detailed information of the product</p>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <c:if test="${product.productImageUrl==''}">
                        <img src="<c:url value="/resources/images/${product.productId}.png"/>"
                             style="height:500px; width: 250px">
                    </c:if>
                    <img src="<c:url value="${product.productImageUrl}"/>" style="height:auto; width: auto">
                </div>
                <p class="col-md-6">
                <h3>${product.productName}</h3>
                <br>
                <p>${product.productDescription}</p>
                <p><strong>Brand: ${product.productManufacturer}</strong></p>
                <h4><strong>&#8377;${product.productPrice}</strong></h4>
                <c:set var="role" scope="page" value="${param.role}"/>
                <br><br>
                <p ng-controller="cartCtrl">
                    <a href="<spring:url value="${pageContext.request.getHeader('referer')}"/>" class="btn btn-default">
                        <span class="glyphicon-hand-left glyphicon"></span> Go Back </a>
                    <c:choose>
                        <c:when test="${pageContext.request.userPrincipal.name == null}">
                            <a href="<spring:url value="/login"/>" class="btn btn-warning btn-large">
                                <span class="glyphicon glyphicon-shopping-cart"></span> Order Now </a>
                        </c:when>
                        <c:otherwise>
                            <a href="#" class="btn btn-warning btn-large"
                               ng-click="addToCart('${product.productId}')">
                                <span class="glyphicon glyphicon-shopping-cart"></span> Order Now </a>
                            <a href="<spring:url value="/customer/cart"/>" class="btn btn-default">
                                <span class="glyphicon glyphicon-hand-right"></span> View Cart </a>
                        </c:otherwise>
                    </c:choose>
                </p>
            </div>
        </div>
    </div>
</div>
<!-----------------------View Products Ends----------------------->
<%@include file="/WEB-INF/views/template/footer.jsp" %>