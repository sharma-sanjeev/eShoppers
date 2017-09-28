<!-----------------------Search Products Starts----------------------->
        <div>
            <table class="table table-hover table-responsive">
                <div class="row">
                    <div class="text-center col-lg-12">
                        <h3><strong>
                            <ng-pluralize count="${products.size()}"
                                          when="{
                                            '0': 'Sorry, we found no product for you.',
                                            '1': '1 product found.',
                                            'other': '{} products found'}">
                            </ng-pluralize>
                            <c:if test="${!(products.size()>0)}">
                                <h3><strong> Go to
                                    <a href="<spring:url value="/product/productList/"/>" type="button"
                                       class="btn btn-success">Normal Search</a>
                                </strong></h3>
                            </c:if>
                        </strong></h3>
                    </div>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td class="col-xs-5 text-center">
                                <a href="<spring:url value="/resources/images/${product.productId}"/>">
                                    <c:if test="${product.productImageUrl!=''}">
                                        <img src="${product.productImageUrl}" style="height: 250px;">
                                    </c:if>
                                    <c:if test="${product.productImageUrl==''}">
                                        <img src="<c:url value="/resources/images/${product.productId}.png"/>"
                                             alt="image"
                                             style="height: 250px">
                                    </c:if>
                                </a>
                            </td>
                            <td class="col-xs-7">
                                <h3><strong>${product.productName}</strong></h3>
                                <p><strong>Brand: ${product.productManufacturer}</strong></p>
                                <br>
                                <h3>Price: <strong>&#8377;${product.productPrice}</strong> only.</h3>
                                <br>
                                <a href="<spring:url value="/product/viewProduct/${product.productId}" />"
                                   class="btn btn-primary"> View </a>
                            </td>
                        </tr>
                    </c:forEach>
                </div>
            </table>
        </div>
<!-----------------------Search Products Ends----------------------->