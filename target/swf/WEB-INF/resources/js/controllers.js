
swfMod.controller('HomeCtrl', function($scope) {

    $scope.message = 'Trust and Commitment';

});


swfMod.controller('MembersCtrl', function($scope, $location, $memberService) {
    // initialize selected error data for re-queueing
    $scope.selected = {};
    // initialize the paging structure
    $scope.maxSize = 5;
    $scope.pageSize = 5;
    $scope.currentPage = 1;
    $memberService.getMembers($scope.search, $scope.currentPage, $scope.pageSize).
        then(function (response) {
            var serverData = response.data;
            $scope.members = serverData.objects;
            $scope.noOfPages = serverData.pages;
        });
    $scope.$watch('currentPage', function (newValue, oldValue) {
        if (newValue != oldValue) {
            $memberService.getMembers($scope.search, $scope.currentPage, $scope.pageSize).
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
            $memberService.getMembers($scope.search, $scope.currentPage, $scope.pageSize).
                then(function (response) {
                    var serverData = response.data;
                    $scope.groups = serverData.objects;
                    $scope.noOfPages = serverData.pages;
                });
        }
    }, true);


} );

swfMod.controller('MemberCtrl', function($scope, $routeParams, $location, $memberService) {
    // initialize the source object
    $scope.source = {};
    // initialize the view to be read only
    $scope.mode = "view";
    $scope.uuid = $routeParams.uuid;
    if ($scope.uuid === undefined) {
        $scope.mode = "edit";
    } else {
        $memberService.getMember($scope.uuid).
            then(function(response) {
                $scope.member = response.data;
            });
    }

    $scope.edit = function() {
        $scope.mode = "edit";
    };

    $scope.cancel = function() {
            $location.path("/members");
    };

    $scope.void = function () {
        $memberService.voidMember($scope.uuid).
            success(function(){
                $location.path("/members");
            })
            .error(function(){
                $location.path("/members");
            })
    };

    $scope.save = function(member) {

        $memberService.saveMember(member.surname, member.other_names, member.gender, member.phone_number, member.id_number, member.date_created, member.creator, member.uuid, member.voided, member.voided_by, member.date_voided).

            success(function(){
                $location.path("/members");
            })
            .error(function(){
                $location.path("/members");
            })

    };

});
