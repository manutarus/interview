var swfMod = angular.module('swfMod', [])

swfMod.
    config(['$routeProvider', '$compileProvider', function ($routeProvider, $compileProvider) {
        $compileProvider.urlSanitizationWhitelist(/^\s*(https?|ftp|mailto|file):/);


        $routeProvider.when('/view', {controller: 'HomeCtrl',
            templateUrl: 'resources/partials/welcome.html'});

        $routeProvider.when('/members', {controller: 'MembersCtrl',
            templateUrl: 'resources/partials/members.html'});

        $routeProvider.when('/member/:uuid', {controller: 'MemberCtrl',
            templateUrl: 'resources/partials/member.html'});

        $routeProvider.when('/createGroup', {controller: 'GroupCtrl',
            templateUrl: 'resources/partials/group.html'});

        $routeProvider.otherwise({redirectTo: '/view'});
    }]);

swfMod.factory('$memberService', function ($http) {
    var getMembers = function (search, pageNumber, pageSize) {
        if (search === undefined) {
            // replace undefined search term with empty string
            search = '';
        }
        return $http.get("list/allMembers.json?search=" + search + "&pageNumber=" + pageNumber + "&pageSize=" + pageSize);
    };
    var getMember = function (uuid) {
        return $http.get("member.json?uuid=" + uuid);
    };

    var saveMember = function (surname,other_names,gender, phone_number,id_number, date_created, creator, uuid, voided, voided_by,date_voided) {

        return $http.post("memberUpdateSave.json", {"surname": surname, "other_names": other_names, "gender":gender, "phone_number": phone_number,
            "id_number": id_number, "date_created": date_created, "creator":creator, "uuid": uuid, "voided": voided, "voided_by": voided_by, "creator":creator, "date_voided": date_voided});
    };
    var voidMember = function (uuid) {
        return $http.post("member.json", {"uuid": uuid});
    };


    return {
        getMembers: getMembers,
        getMember: getMember,
        saveMember: saveMember,
        voidMember: voidMember

    }
});

