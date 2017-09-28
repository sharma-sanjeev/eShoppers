angular.module('eShoppersApp', ['searchApp']).controller('cartCtrl', cartCtrl);

function cartCtrl($scope, $http) {

    $scope.refreshCart = function () {
        $http.get('/rest/cart/' + $scope.cartId)
            .success(function (data) {
                $scope.cart = data;
            });
    };

    $scope.clearCart = function () {
        $http.delete('/rest/cart/' + $scope.cartId)
            .success(function (data) {
                $scope.refreshCart();
            });
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function (productId) {
        $http.put('/rest/cart/add/' + productId).success(function () {

            alert("Product Successfully added to the Cart!");

        });
    };
    $scope.removeFromCart = function (productId) {
        $http.put('/rest/cart/remove/' + productId)
            .success(function (data) {
                $scope.refreshCart();
            });
    };

    $scope.calGrandTotal = function () {
        var grandTotal = 0;
        for (var i = 0; i < $scope.cart.cartItems.length; i++) {
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }
        return grandTotal;
    };

    $scope.totalCartItems = function () {
        var totalQty = 0;
        for (var i = 0; i < $scope.cart.cartItems.length; i++) {
            totalQty += $scope.cart.cartItems[i].quantity;
        }
        return totalQty;
    }
}
