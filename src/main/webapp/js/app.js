var app = angular.module("geektic", ['ngRoute']);

/*app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});
*/

app.controller('HelloCtrl', function($scope, $http) {
	
	// $scope.criteria = {c:1,b:5};
	
    /*
     * $http.get('/api/hello').success(function(CentreInterets) {
        $scope.centreInterets = CentreInterets;
    });    
    */
	
    $scope.afficherLesGeeks = function(){    
    	$http.get('/api/afficherLesGeeks', {params : $scope.criteria}).success(function(Geeks) {
            $scope.geeks = Geeks;
        });
    }   
    
});

app.controller('AfficherCentreInteret', function($scope, $http) {
    $http.get('/api/afficherCentreInteret').success(function(CentreInterets) {
        $scope.centreInterets = CentreInterets;
    });
});

app.controller('AfficherLesGeeks', function($scope, $http) {

    $http.get('/api/afficherLesGeeks').success(function(Geeks) {
        $scope.geeks = Geeks;
    });
    
});

