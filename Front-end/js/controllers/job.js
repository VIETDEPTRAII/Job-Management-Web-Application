(function (module) {

module.controller('JobsCtrl', function($scope, $http, $window) {

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
