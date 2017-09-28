<!-----------------------Featurettes Starts----------------------->
<div class="container marketing">
    <c:forEach items="${products}" var="product">
        <c:if test="${
                    product.productId == 1 ||
                    product.productId == 2 ||
                    product.productId == 3 ||
                    product.productId == 4 ||
                    product.productId == 5 ||
                    product.productId == 6
                    }">
            <hr class="featurette-divider">
            <div class="row featurette">
                <c:choose>
                    <c:when test="${product.productId%2 == 0}">
                        <div class="col-md-7">
                            <h2 class="featurette-heading">${product.productName}</h2>
                            <h3><span class="text-muted">${product.productManufacturer}</span></h3>
                            <p class="lead">${product.productDescription}</p>
                            <br>
                            <a href="<c:url value="/product/viewProduct/${product.productId}"/>"
                               class="btn btn-success btn-lg pull-right"
                               role="button">View Details</a>
                            <br><br><br>
                        </div>
                        <div class="col-md-5">
                            <img class="featurette-image img-responsive center-block"
                                 width="250"
                                 alt="image"
                                 src="<c:url value="/resources/images/${product.productId}.png" />">
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="col-md-7 col-md-push-5">
                            <h2 class="featurette-heading">${product.productName}</h2>
                            <h3><span class="text-muted">${product.productManufacturer}</span></h3>
                            <p class="lead">${product.productDescription}</p>
                            <br>
                            <a href="<c:url value="/product/viewProduct/${product.productId}"/>"
                               class="btn btn-success btn-lg pull-left">View Details</a>
                            <br><br><br>
                        </div>
                        <div class="col-md-5 col-md-pull-7">
                            <img class="featurette-image img-responsive center-block"
                                 width="250"
                                 alt="image"
                                 src="<c:url value="/resources/images/${product.productId}.png" />"/>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:if>
    </c:forEach>
</div>
<!-----------------------Featurettes Ends----------------------->