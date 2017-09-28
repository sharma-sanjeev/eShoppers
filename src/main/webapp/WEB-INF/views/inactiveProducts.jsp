<%@include file="/WEB-INF/views/template/admin-header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <br>
            <h1>Inactive Products</h1>
            <p class="lead">This list cannot be deleted because these products must be connected with some other
                table(like CartItem).</p>
            <table class="table table-hover table-striped">
                <thead>
                <tr class="" bg-success>
                    <th>Product Thumb</th>
                    <th>Product Name</th>
                    <th>Category<br>& Status</th>
                    <th>Condition</th>
                    <th>Price</th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>
                            <img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image"
                                 style="width: 100px;"/>
                        </td>
                        <td>${product.productName}</td>
                        <td>Category: ${product.productCategory}<br>Status: ${product.productStatus}</td>
                        <td>${product.productCondition}</td>
                        <td>${product.productPrice}</td>
                        <td>
                            <a href="<spring:url value="/product/viewProduct/${product.productId}" />">
                                <button type="button" class="btn-info">View</button>
                            </a>
                            <a href="<spring:url value="/admin/product/editProduct/${product.productId}" />">
                                <button type="button" class="btn-light">Edit</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/admin-footer.jsp" %>