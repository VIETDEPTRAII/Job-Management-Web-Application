(function(module) {

    module.controller('ResourcesCtrl', function($scope, $http, $window, $filter) {

        $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

        //Get All Jobs
        $http({
            method: "GET",
            url: "http://localhost:8080/Job/GetAllJobs"
        }).then(function mySuccess(response) {
            $scope.searched = response.data;

        }, function myError(response) {
            $scope.searched = response.statusText;
        });

        // Get Job By Id For Show Detail Job
        $scope.getResourcesIndex = function(resources) {
            $http({
                method: "GET",
                url: "http://localhost:8080/Job/GetJob/" + resources.id
            }).then(function mySuccess(response) {
                $scope.resourcesDetails = response.data;
            });
        };

        // Add New Job
        $scope.addResources = function() {
            var data = $.param({
                jobname: $scope.jobname,
                jobtype: $scope.jobtype,
                salary: $scope.salary,
                company: $scope.company,
                location: $scope.location,
                desc: $scope.desc
            });
            $http.post("http://localhost:8080/Job/InsertJob/", data)
                .then(function mySuccess(data) {
                    $window.location.reload()
                });
        }

        //Update Job
        $scope.updateResources = function() {
            var data = $.param({
                id: $scope.resourcesDetails.id,
                jobname: $scope.resourcesDetails.jobname,
                jobtype: $scope.resourcesDetails.jobtype,
                salary: $scope.resourcesDetails.salary,
                company: $scope.resourcesDetails.company,
                location: $scope.resourcesDetails.location,
                desc: $scope.resourcesDetails.desc
            });

            $http.post("http://localhost:8080/Job/UpdateJob/", data)
                .then(function mySuccess(data) {
                    $window.location.reload()
                });
        }

        //Delete Jobs
        $scope.deleteResources = function(resources) {
            var data = $.param({
                id: resources.id
            });
            $http.post("http://localhost:8080/Job/" + resources.id, data)
                .then(function mySuccess(response) {
                    alert("You deleted job successfully");
                    $window.location.reload()
                });
        }

        // Search Jobs
        $scope.findResources = function(key) {
            if (key != "" && key != null) {
                $http({
                    method: "GET",
                    url: "http://localhost:8080/Job/SearchJobs/" + key
                }).then(function mySuccess(response) {
                    $scope.searched = response.data;
                }, function myError(response) {
                    $scope.searched = response.statusText;
                });
            } else {
                $http({
                    method: "GET",
                    url: "http://localhost:8080/Job/GetAllJobs"
                }).then(function mySuccess(response) {
                    $scope.searched = response.data;
                }, function myError(response) {
                    $scope.searched = response.statusText;
                });
            }
        }
    });

}(angular.module("myApp")));
