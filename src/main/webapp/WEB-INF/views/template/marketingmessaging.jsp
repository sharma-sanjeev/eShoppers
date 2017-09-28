<!-----------------------MarketingMessaging Starts----------------------->
<div class="container marketing">
    <div class="row">
        <c:forEach items="${products}" var="product">
            <c:if test="${
                    product.productId == 4 ||
                    product.productId == 5 ||
                    product.productId == 6
                     }">
                <div class="col-lg-4">
                    <a href="<c:url value="/product/viewProduct/${product.productId}"/>">
                        <img src="<c:url value="/resources/images/${product.productId}.png" />"
                             height="140px"
                             alt="Generic placeholder image">
                    </a>
                    <h2>${product.productName}</h2>
                    <p>${product.productDescription}</p>
                    <p><a href="<c:url value="/product/viewProduct/${product.productId}"/>"
                          class="btn btn-default" role="button">View details &raquo;</a></p>
                </div>
            </c:if>
        </c:forEach>
    </div>
</div>
<!-----------------------MarketingMessaging Ends----------------------->