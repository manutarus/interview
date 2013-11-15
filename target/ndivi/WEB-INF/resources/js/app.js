var studentMod = angular.module('studentMod', [])

studentMod.
    config(['$routeProvider', '$compileProvider', function ($routeProvider, $compileProvider) {
        $compileProvider.urlSanitizationWhitelist(/^\s*(https?|ftp|mailto|file):/);


        $routeProvider.when('/ndivi', {controller: 'HomeCtrl',
            templateUrl: 'resources/partials/welcome.html'});

        $routeProvider.when('/users', {controller: 'UsersCtrl',
            templateUrl: 'resources/partials/users.html'});

        $routeProvider.when('/students', {controller: 'StudentsCtrl',
            templateUrl: 'resources/partials/students.html'});

        $routeProvider.when('/student/:reg_no', {controller: 'StudentCtrl',
            templateUrl: 'resources/partials/student.html'});


        $routeProvider.otherwise({redirectTo: '/ndivi'});
    }]);

studentMod.factory('$userService', function ($http) {
    var getPreferredForms = function (search, pageNumber, pageSize) {
        if (search === undefined) {
            // replace undefined search term with empty string
            search = '';
        }
        return $http.get("list/allUsers.json?search=" + search + "&pageNumber=" + pageNumber + "&pageSize=" + pageSize);
    };




    var deletePreferredForms = function(uuidList) {
        return $http.post("preferredForms.json", {"uuidList": uuidList});
    };

    var getPreferredForm = function (uuid) {
        return $http.get("preferredForm.json?uuid=" + uuid);
    };

    var deletePreferredForm = function (uuid) {
        return $http.post("preferredForm.json", {"uuid": uuid});
    };

    var savePreferredForm = function(uuid, name) {
        return $http.post("preferredForm.json", {"uuid": uuid, "name": name});
    };

    var getAttributeTypes = function (search, pageNumber, pageSize) {
        if (search === undefined) {
            // replace undefined search term with empty string
            search = '';
        }
        return $http.get("attributeTypes.json?search=" + search + "&pageNumber=" + pageNumber + "&pageSize=" + pageSize);
    };

    var getAttributeType = function (uuid) {
        return $http.get("attributeType.json?uuid=" + uuid);
    };

    var saveAttributeType = function (uuid, name, description) {
        return $http.post("attributeType.json", {"uuid": uuid, "name": name, "description": description});
    };

    var deleteAttributeType = function (uuid) {
        return $http.post("attributeType.json", {"uuid": uuid});
    };

    var getAttributes = function (search, pageNumber, pageSize) {
        if (search === undefined) {
            // replace undefined search term with empty string
            search = '';
        }
        return $http.get("attributes.json?search=" + search + "&pageNumber=" + pageNumber + "&pageSize=" + pageSize);
    };

    var getAttribute = function (uuid) {
        return $http.get("attribute.json?uuid=" + uuid);
    };

    return {
        getPreferredForms: getPreferredForms,
        deletePreferredForms: deletePreferredForms,
        getPreferredForm: getPreferredForm,
        deletePreferredForm:deletePreferredForm,
        savePreferredForm: savePreferredForm,

        getAttributeTypes: getAttributeTypes,
        getAttributeType: getAttributeType,
        saveAttributeType: saveAttributeType,
        deleteAttributeType: deleteAttributeType,

        getAttributes: getAttributes,
        getAttribute: getAttribute
    }
});



studentMod.factory('$studentService', function ($http) {
    var getStudents = function (search, pageNumber, pageSize) {
        if (search === undefined) {
            // replace undefined search term with empty string
            search = '';
        }
        return $http.get("list/allStudents.json?search=" + search + "&pageNumber=" + pageNumber + "&pageSize=" + pageSize);
    };
    var getStudent = function (reg_no) {
        return $http.get("student.json?reg_no=" + reg_no);
    };
    var saveStudent = function (sid,surname, other_names, reg_no,year,suspended) {
        return $http.post("student.json", {"sid": sid, "surname":surname, "other_names": other_names,"reg_no": reg_no, "year":year, "suspended": suspended});
    };


    return {
        getStudents: getStudents,
        getStudent: getStudent,
        saveStudent: saveStudent

    }
});

