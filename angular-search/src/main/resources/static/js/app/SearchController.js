'use strict'

angular.module('instantSearch', [])
    .controller('SearchCtrl', SearchCtrl);
    
function SearchCtrl($scope, $http) {
    $scope.searchString = "";
    $scope.searchRackets = function (searchString) {

        if (!searchString) {
            $http.get('/getallRacquets').
                then(function success(response) {
                    $scope.items = response.data;
                    $scope.statusval = response.status;
                    $scope.statustext = response.statusText;
                },
                    function error(response) {
                        $scope.items = "";
                        $scope.statusval = response.status;
                        $scope.statustext = "Service Issue, Did not get any response. Problem with the Search!!";
                    })
        } else {
            $http.get('/getallRacquets/' + $scope.searchString).
                then(function success(response) {
                    $scope.items = response.data;
                    $scope.statusval = response.status;
                    $scope.statustext = response.statusText;

                },
                    function error(error) {
                        $scope.items = "";
                        $scope.statusval = error.status;
                        $scope.statustext = error.errorMessage;
                    })
        }
    }
}


