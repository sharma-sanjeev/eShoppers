var app = angular.module('searchApp', []);
app.controller('searchCtrl', searchCtrl);
app.controller('timeOut', timeOut)

function searchCtrl($scope, $http) {
    $scope.getProducts = function () {
        $http.get('/product/search')
            .success(function (data) {
                $scope.products = data;
            });
    };


}
function timeOut($scope, $window, $timeout) {
    $scope.greeting = 'Hello, World!';
    $scope.showGreeting = false;
    $scope.doGreeting = function() {
        $scope.msg="hi";
        $scope.showGreeting = true;
        $timeout(function(){
            $scope.showGreeting = false;
        }, 10000);
    };
}