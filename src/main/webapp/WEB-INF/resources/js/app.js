var payrollMod = angular.module('payrollMod', [])

payrollMod.
    config(['$routeProvider', '$compileProvider', function ($routeProvider, $compileProvider) {
        $compileProvider.urlSanitizationWhitelist(/^\s*(https?|ftp|mailto|file):/);


        $routeProvider.when('/view', {controller: 'HomeCtrl',
            templateUrl: 'resources/partials/welcome.html'});

        $routeProvider.when('/groups', {controller: 'GroupsCtrl',
            templateUrl: 'resources/partials/groups.html'});

        $routeProvider.when('/group/:uuid', {controller: 'GroupCtrl',
            templateUrl: 'resources/partials/group.html'});

        $routeProvider.when('/createGroup', {controller: 'GroupCtrl',
            templateUrl: 'resources/partials/group.html'});

        $routeProvider.otherwise({redirectTo: '/view'});
    }]);

payrollMod.factory('$groupService', function ($http) {
    var getGroups = function (search, pageNumber, pageSize) {
        if (search === undefined) {
            // replace undefined search term with empty string
            search = '';
        }
        return $http.get("list/allGroups.json?search=" + search + "&pageNumber=" + pageNumber + "&pageSize=" + pageSize);
    };
    var getGroup = function (uuid) {
        return $http.get("group.json?uuid=" + uuid);
    };
    var saveGroup = function (uuid,name,rate_per_hour, basic_pay) {

        return $http.post("groupUpdateSave.json", {"uuid": uuid, "name": name, "rate_per_hour":rate_per_hour, "basic_pay": basic_pay});
    };
    var voidGroup = function (uuid) {
        return $http.post("group.json", {"uuid": uuid});
    };


    return {
        getGroups: getGroups,
        getGroup: getGroup,
        saveGroup: saveGroup,
        voidGroup: voidGroup

    }
});

