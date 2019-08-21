var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "main.html",
        controller:  "JobsCtrl"
    })
    .when("/job-detail/:id", {
        templateUrl : "job-single.html",
        controller: "Job-Details-Ctrl"
    })
    .when("/green", {
        templateUrl : "green.htm"
    })
    .when("/blue", {
        templateUrl : "blue.htm"
    });
});
