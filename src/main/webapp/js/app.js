var app = angular.module("geektic", ['ngRoute']);

app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});

app.controller('HelloCtrl2', function($scope, $http) {
    $http.get('/api/hello').success(function(CentreInteret) {
        $scope.centreInteret = CentreInteret;
    });
});

