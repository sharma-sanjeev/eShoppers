<%@include file="/WEB-INF/views/template/admin-header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Inventory Page</h1>
            <p class="lead">Checkout all the awesome products
                <a href="<spring:url value="/admin/product/addProduct"/>" class="btn btn-success pull-right">Add
                    Product</a>
            </p>
        </div>
        <div ng-controller="searchCtrl" ng-init="getProducts()">
            <div class="col-lg-push-4 col-lg-4">
                <input type="text" class="form-control" placeholder="Search..." ng-model="searchText" autofocus>
            </div>
            <table class="table table-hover table-striped">
                <thead>
                <tr class="" bg-success>
                    <div class="row">
                    <th class="col-lg-3 text-center">Product Thumb</th>
                    <th class="col-lg-4 col-lg-push-3 text-center">Product Name</th>
                    <th class="col-lg-2 col-lg-push-6">Category, Status<br>& Condition</th>
                    <th class="col-lg-1 col-lg-push-8">Price</th>
                    <th></th>
                    </div>
                </tr>
                </thead>
                <tr ng-repeat="product in products | filter:searchText">
                    <div class="row">
                    <td class="col-lg-3 text-center" ng-model="product.productImageUrl">
                        <img src="<c:url value="/resources/images/{{product.productId}}.png"/>" style="height: 100px;" ng-hide="" />
                        <img src="{{product.productImageUrl}}" style="height: 100px;" ng-hide="" />
                    </td>
                    <td class="col-lg-4 col-lg-push-3 text-center">{{product.productName}}</td>
                    <td class="col-lg-2 col-lg-push-6">
                        Category: {{product.productCategory}}<br>
                        Status: {{product.productStatus}}<br>
                        Condition: {{product.productCondition}}</td>
                    <td class="col-lg-1 col-lg-push-8">{{product.productPrice}}</td>
                    <td  class="col-lg-2 text-center">
                        <a href="<spring:url value="/product/viewProduct/{{product.productId}}" />">
                            <button type="button" class="btn-info">View</button>
                        </a><br><br>
                        <a href="<spring:url value="/admin/product/editProduct/{{product.productId}}" />">

                            <button type="button" class="btn-light">Edit</button>
                        </a><br><br>
                        <a href="<spring:url value="/admin/product/deleteProduct/{{product.productId}}" />">
                            <button type="button" class="btn-danger">Delete/Set Inactive</button>
                        </a>
                    </td>
                    </div>
                </tr>
            </table>
        </div>

    </div>
</div>
<%@include file="/WEB-INF/views/template/admin-footer.jsp" %>