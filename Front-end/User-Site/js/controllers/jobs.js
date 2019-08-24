(function (module) {

module.controller('JobsCtrl', function($scope, $http, $filter) {



  // Search Jobs By Name
  $scope.searchJobs= function(key){
          if(key!="" && key!= null){
          $http({
            method : "GET",
            url : "http://localhost:8080/Job/SearchJobs/" + key
          }).then(function mySuccess(response) {
              $scope.searched = response.data;
            },function myError(response) {
              $scope.searched = response.statusText;
          });
        }
        else{
          $http({
            method : "GET",
            url : "http://localhost:8080/Job/GetAllJobs"
          }).then(function mySuccess(response) {
              $scope.searched = response.data;
            },function myError(response) {
              $scope.searched = response.statusText;
          });
        }
      }

      //Get jobs
      $http({
        method : "GET",
        url : "http://localhost:8080/Job/GetAllJobs"
      }).then(function mySuccess(response) {

          $scope.searched = response.data;
        },function myError(response) {
          $scope.searched = response.statusText;
      });

});
}(angular.module("myApp")));
