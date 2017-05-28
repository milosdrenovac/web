var wafepaApp = angular.module('wafepaApp', ['ngRoute']);

wafepaApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider
    .when('/', {
        templateUrl : '/static/app/html/proba.html'
    })
    .when('/konfiguracije', {
        templateUrl : '/static/app/html/partial/konfiguracije.html'
    })
    .when('/konfiguracija/:id', {
        templateUrl : '/static/app/html/partial/konfiguracija.html'
    })
    .otherwise({
        redirectTo: '/'
    });
}]);


wafepaApp.controller('konfiguracijeCtrl', function($scope, $http, $routeParams, $location){

    $scope.currentPage=0;
    $scope.totalPages;
    $scope.searchModelKonf={};

    $scope.changePage = function (i) {
        if(($scope.currentPage>0&&i<0)||(i>0&&$scope.currentPage<$scope.totalPages)){
            $scope.currentPage += i;
            $scope.ucitajKonfiguracije();
        }
    }

    $scope.ucitajKonfiguracije = function(){
        var config = {params:{}}

        if($scope.searchModelKonf){
            config.params.modelid=$scope.searchModelKonf.id;
        }
        if($scope.searchModelKonf.priceFrom){
            config.params.priceFrom=$scope.searchModelKonf.priceFrom;
        }
        if($scope.searchModelKonf.priceTo){
            config.params.priceTo=$scope.searchModelKonf.priceTo;
        }
        if($scope.searchModelKonf.ramFrom){
            config.params.ramFrom=$scope.searchModelKonf.ramFrom;
        }
        if($scope.searchModelKonf.ramTo){
            config.params.ramTo=$scope.searchModelKonf.ramTo;
        }
        if($scope.currentPage){
            config.params.page=$scope.currentPage;            
        }

        $http.get('/api/konfiguracija', config).then(function (resp, status) {
            $scope.konfiguracije = resp.data;
            $scope.totalPages = Number(resp.headers().totalpages);
        },function (resp, status){            
            console.log('error');
            console.log(status);
        });
    };

    $scope.ucitajKonfiguracije();


    $scope.delete = function (id) {
        $http.delete('/api/konfiguracija/'+id).then(function () {
            $scope.ucitajKonfiguracije();
        });
    }

    $scope.setForUpdate = function (konfiguracija) {
        $scope.newKonfiguracija = angular.copy(konfiguracija);
        $scope.ucitajModele();
    }

    $scope.ucitajProizvodjace = function(){

        $http.get('/api/proizvodjaci').then(function (resp, status) {
            $scope.proizvodjaci = resp.data;
        },function (resp, status){            
            console.log('error');
            console.log(status);
        });

    }

    $scope.ucitajModele = function(){
        var id = $scope.newKonfiguracija.model.proizvodjac.id;
        $http.get('/api/proizvodjaci/'+id+'/modeli/').then(function (resp, status) {
            $scope.modeli = resp.data;
        },function (resp, status){            
            console.log('error');
            console.log(status);
        });
    }

    $scope.ucitajProizvodjace();

    $scope.save = function(){
        if($scope.newKonfiguracija.id){
            $http.put('/api/konfiguracija/'+$scope.newKonfiguracija.id,$scope.newKonfiguracija).then(function () {
                $scope.newKonfiguracija = {};
                $scope.ucitajKonfiguracije();
            });        
        }else{
            $http.post('/api/konfiguracija/',$scope.newKonfiguracija).then(function () {
                $scope.newKonfiguracija = {};
                $scope.ucitajKonfiguracije();
            });
        }
    }

    $scope.gotoKonfig = function (id) {
        $location.path('konfiguracija/'+id);
    }



    $scope.ucitajSveModele = function(){
        $http.get('/api/modeli').then(function (resp, status) {
            $scope.modeli = resp.data;
        },function (resp, status){            
            console.log('error');
            console.log(status);
        });
    }

    $scope.ucitajSveModele();

    $scope.filtriraj = function () {
        $scope.currentPage = 0;
        $scope.ucitajKonfiguracije();  
        $scope.searchModelKonf={};      
    }




});

wafepaApp.controller('konfiguracijaCtrl', function($scope, $http, $routeParams, $location){

    $scope.ucitajKonfiguracije = function(){
        $http.get('/api/konfiguracija/'+$routeParams.id).then(function (resp, status) {
            $scope.newKonfiguracija = resp.data;
        }).then(function(){
            $scope.ucitajProizvodjace();
        });
    }

    $scope.ucitajProizvodjace = function(){

        $http.get('/api/proizvodjaci').then(function (resp, status) {
            $scope.proizvodjaci = resp.data;
        }).then( function(){
            $scope.ucitajModele();
        });

    }

    $scope.ucitajModele = function(){
        var id = $scope.newKonfiguracija.model.proizvodjac.id;
        $http.get('/api/proizvodjaci/'+id+'/modeli/').then(function (resp, status) {
            $scope.modeli = resp.data;
        },function (resp, status){            
            console.log('error');
            console.log(status);
        });
    }

    $scope.ucitajKonfiguracije();



    $scope.save = function(){
        $http.put('/api/konfiguracija/'+$scope.newKonfiguracija.id,$scope.newKonfiguracija).then(function () {
            $location.path('konfiguracije');
        });        
    }

})



