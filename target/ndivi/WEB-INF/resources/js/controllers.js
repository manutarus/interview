

muzimaPreferredForm.controller('HomeCtrl', function($scope) {

    $scope.message = 'Muzima angula module home';

});


muzimaPreferredForm.controller('UsersCtrl', function($scope, $location, $userService) {
//function UsersCtrlwwww($scope, $location, $userService) {
    // initialize selected error data for re-queueing
    $scope.selected = {};
    // initialize the paging structure
    $scope.maxSize = 5;
    $scope.pageSize = 5;
    $scope.currentPage = 1;
    $userService.getPreferredForms($scope.search, $scope.currentPage, $scope.pageSize).
        then(function (response) {
            var serverData = response.data;
            $scope.preferredForms = serverData.objects;
            $scope.noOfPages = serverData.pages;
        });

    $scope.delete = function () {
        var uuidList = [];
        angular.forEach($scope.selected, function (value, key) {
            if (value) {
                uuidList.push(key);
            }
        });
        $userService.deletePreferredForms(uuidList).
            then(function () {
                $location.path("/preferredForms");
            })

    };

    $scope.$watch('currentPage', function (newValue, oldValue) {
        if (newValue != oldValue) {
            $userService.getPreferredForms($scope.search, $scope.currentPage, $scope.pageSize).
                then(function (response) {
                    var serverData = response.data;
                    $scope.preferredForms = serverData.objects;
                    $scope.noOfPages = serverData.pages;
                });
        }
    }, true);

    $scope.$watch('search', function (newValue, oldValue) {
        if (newValue != oldValue) {
            $scope.currentPage = 1;
            $userService.getPreferredForms($scope.search, $scope.currentPage, $scope.pageSize).
                then(function (response) {
                    var serverData = response.data;
                    $scope.preferredForms = serverData.objects;
                    $scope.noOfPages = serverData.pages;
                });
        }
    }, true);
} );
