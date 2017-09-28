<%@include file="/WEB-INF/views/template/header.jsp" %>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <br><span>
            <h3><strong>Checkout the awesome products</strong></h3>
            </span>
            <div ng-controller="searchCtrl" ng-init="getProducts()">
                <div class="col-lg-push-4 col-lg-4">
                    <input type="text" class="form-control" placeholder="Search..." ng-model="searchText" autofocus>
                </div>
                <br><br><br>
                <table class="table table-hover table-responsive">
                    <div class="row">

                        <tr ng-repeat="product in products | filter:searchText">
                            <td class="col-lg-4 text-center"
                                ng-model="product.productImageUrl">
                                <a href="<spring:url value="/product/viewProduct/{{product.productId}}" />">
                                    <img src="<spring:url value="/resources/images/{{product.productId}}.png"/>"
                                         style="height: 200px;" ng-hide="">
                                    <img src="{{product.productImageUrl}}" style="height: 200px;" ng-hide="">
                                </a>
                            </td>
                            <td class="col-lg-4 text-center">
                                <br>
                                <h3><strong>{{product.productName}}</strong></h3>
                                <br>
                                Category: {{product.productCategory}}
                                <br>
                                Condition: {{product.productCondition}}
                            </td>
                            <td class="col-lg-4 text-center">
                                <br><br>
                                <h4> Price: <strong>&#8377;{{product.productPrice}}</strong> only.</h4>
                                <br>
                                <a href="<spring:url value="/product/viewProduct/{{product.productId}}"/>">
                                    <button type="button" class="btn btn-primary btn-lg">View</button>
                                </a>
                            </td>
                        </tr>
                    </div>
                </table>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>