var app = angular.module("myApp", ["ngRoute","ngStorage"]);
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
    .when("/login", {
    templateUrl : "login.html",
    controller : "Login.IndexController",
    controllerAs: "vm"
    })
    .when("/blue", {
        templateUrl : "blue.htm"
    });
});

app.run(function($rootScope, $http, $location, $localStorage) {
        // keep user logged in after page refresh
        if ($localStorage.currentUser) {
            $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.currentUser.token;
        }

        // redirect to login page if not logged in and trying to access a restricted page
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            var publicPages = ['/login'];
            var restrictedPage = publicPages.indexOf($location.path()) === -1;
            if (restrictedPage && !$localStorage.currentUser) {
                $location.path('/login');
            }
        });
});
