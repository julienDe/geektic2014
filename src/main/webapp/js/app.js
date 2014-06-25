var app = angular.module("geektic", ['ngRoute']);

/*app.controller('HelloCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});
*/

app.controller('HelloCtrl', function($scope, $http) {
	
	$scope.test = $http.get('/api/afficherCentreInteret').success(function(test) {
        $scope.test = test;
    });
	
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
    
    $scope.afficherDetail= function(geek){    
    	alert("Geek : "+geek.nom+""+geek.prenom+"\nmail :"+geek.mail+"\ncheveux de couleur "+geek.couleurCheveux+"\nLes yeux de couleur : "+ geek.couleurYeux+"\ntaille "+geek.taille+"\nPoids : "+ geek.poids+ "\nsexe : "+geek.sexe);
    	
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

app.controller('AfficherTousLesGeeks', function($scope, $http) {

    $http.get('/api/afficherTousLesGeeks').success(function(Geeks) {
        $scope.geeks = Geeks;
    });
    
});

