<%@include file="/WEB-INF/views/template/header.jsp" %>
<!-----------------------Cart Starts----------------------->
<div class="container-wrapper">
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Cart</h1>
                <p>All the selected products in your cart</p>
            </div>
        </div>
    </section>
    <section class="container">
        <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
            <div>
                <a class="btn btn-danger pull-left" ng-click="clearCart()">
                    <span class="glyphicon glyphicon-removesign"></span> Clear Cart </a>
                <a href="<spring:url value="/order/${cartId}"/> " class="btn btn-success pull-right">
                    <span class="glyphicon-shopping-cart glyphicon"></span> Check out </a>
            </div>
            <table class="table table-hover">
                <tr>
                    <th>Product</th>
                    <th>Price per unit</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th></th>
                </tr>
                <tr ng-repeat="item in cart.cartItems">
                    <td>{{item.product.productName}}</td>
                    <td>&#8377;{{item.product.productPrice}}</td>
                    <td>{{item.quantity}}</td>
                    <td>&#8377;{{item.totalPrice}}</td>
                    <td><a href="#" class="label label-danger" ng-click="removeFromCart(item.product.productId)">
                        <span class="glyphicon glyphicon-remove"/></span> Remove </a></td>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th>Grand Total</th>
                    <th>&#8377;{{calGrandTotal()}}</th>
                    <th></th>
                </tr>
            </table>
            <a href="<spring:url value="/product/productList"/>" class="btn btn-default">
                <span class="glyphicon-hand-left glyphicon"></span> Continue shopping </a>
        </div>
    </section>
</div>
<!-----------------------Cart Ends----------------------->
<%@include file="/WEB-INF/views/template/footer.jsp" %>