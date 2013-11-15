

studentMod.controller('HomeCtrl', function($scope) {

    $scope.message = 'Muzima angula module home';

});


studentMod.controller('UsersCtrl', function($scope, $location, $userService) {
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



studentMod.controller('StudentsCtrl', function($scope, $location, $studentService) {
//function UsersCtrlwwww($scope, $location, $userService) {
    // initialize selected error data for re-queueing
    $scope.selected = {};
    // initialize the paging structure
    $scope.maxSize = 5;
    $scope.pageSize = 5;
    $scope.currentPage = 1;
    $studentService.getStudents($scope.search, $scope.currentPage, $scope.pageSize).
        then(function (response) {
            var serverData = response.data;
            $scope.students = serverData.objects;
            $scope.noOfPages = serverData.pages;
        });
    $scope.$watch('currentPage', function (newValue, oldValue) {
        if (newValue != oldValue) {
            $studentService.getStudents($scope.search, $scope.currentPage, $scope.pageSize).
                then(function (response) {
                    var serverData = response.data;
                    $scope.students = serverData.objects;
                    $scope.noOfPages = serverData.pages;
                });
        }
    }, true);

    $scope.$watch('search', function (newValue, oldValue) {
        if (newValue != oldValue) {
            $scope.currentPage = 1;
            $studentService.getStudents($scope.search, $scope.currentPage, $scope.pageSize).
                then(function (response) {
                    var serverData = response.data;
                    $scope.students = serverData.objects;
                    $scope.noOfPages = serverData.pages;
                });
        }
    }, true);


} );


studentMod.controller('StudentCtrl', function($scope, $routeParams, $location, $studentService) {
    // initialize the source object
    $scope.source = {};
    // initialize the view to be read only
    $scope.mode = "view";
    $scope.reg_no = $routeParams.reg_no;
    if ($scope.reg_no === undefined) {
        $scope.mode = "edit";
    } else {
        $studentService.getStudent($scope.reg_no).
            then(function(response) {
                $scope.student = response.data;
            });
    }

    $scope.edit = function() {
        $scope.mode = "edit";
    };

    $scope.cancel = function() {
        if ($scope.mode == "edit") {
            if ($scope.uuid === undefined) {
                $location.path("/students");
            } else {
                $scope.mode = "view"
            }
        } else {
            $location.path("/students");
        }
    };

    $scope.save = function(student) {

        $studentService.saveStudent(student.sid,student.surname, student.other_names, student.reg_no,student.year,student.suspended).


            success(function(){
                $location.path("/students");
            })
            .error(function(){
                $location.path("/students");
            })
    };

});

