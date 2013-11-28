
payrollMod.controller('HomeCtrl', function($scope) {

    $scope.message = 'Payroll home';

});


payrollMod.controller('GroupsCtrl', function($scope, $location, $groupService) {
    // initialize selected error data for re-queueing
    $scope.selected = {};
    // initialize the paging structure
    $scope.maxSize = 5;
    $scope.pageSize = 5;
    $scope.currentPage = 1;
    $groupService.getGroups($scope.search, $scope.currentPage, $scope.pageSize).
        then(function (response) {
            var serverData = response.data;
            $scope.groups = serverData.objects;
            $scope.noOfPages = serverData.pages;
        });
    $scope.$watch('currentPage', function (newValue, oldValue) {
        if (newValue != oldValue) {
            $groupService.getGroups($scope.search, $scope.currentPage, $scope.pageSize).
                then(function (response) {
                    var serverData = response.data;
                    $scope.groups = serverData.objects;
                    $scope.noOfPages = serverData.pages;
                });
        }
    }, true);


    $scope.$watch('search', function (newValue, oldValue) {
        if (newValue != oldValue) {
            $scope.currentPage = 1;
            $groupService.getGroups($scope.search, $scope.currentPage, $scope.pageSize).
                then(function (response) {
                    var serverData = response.data;
                    $scope.groups = serverData.objects;
                    $scope.noOfPages = serverData.pages;
                });
        }
    }, true);


} );

payrollMod.controller('GroupCtrl', function($scope, $routeParams, $location, $groupService) {
    // initialize the source object
    $scope.source = {};
    // initialize the view to be read only
    $scope.mode = "view";
    $scope.uuid = $routeParams.uuid;
    if ($scope.uuid === undefined) {
        $scope.mode = "edit";
    } else {
        $groupService.getGroup($scope.uuid).
            then(function(response) {
                $scope.group = response.data;
            });
    }

    $scope.edit = function() {
        $scope.mode = "edit";
    };

    $scope.cancel = function() {
            $location.path("/groups");
    };

    $scope.void = function () {
        $groupService.voidGroup($scope.uuid).
            success(function(){
                $location.path("/groups");
            })
            .error(function(){
                $location.path("/groups");
            })
    };

    $scope.save = function(group) {

        $groupService.saveGroup(group.uuid, group.name, group.rate_per_hour, group.basic_pay).

            success(function(){
                $location.path("/groups");
            })
            .error(function(){
                $location.path("/groups");
            })
    };

});
