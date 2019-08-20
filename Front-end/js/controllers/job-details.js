(function (module) {

module.controller('Job-Details-Ctrl', function($scope, $http, $routeParams) {

  var id = $routeParams.id; // Get job_id

  //Get job by Id
  $http({
    method : "GET",
    url : "http://localhost:8080/Job/GetJob/" + id,
  }).then(function mySuccess(response) {
      $scope.jobDetails = response.data;
    },function myError(response) {
      $scope.jobDetails = response.statusText;
  });

});
}(angular.module("myApp")));
