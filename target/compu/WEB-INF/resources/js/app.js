var swfMod = angular.module('swfMod', [])

swfMod.
    config(['$routeProvider', '$compileProvider', function ($routeProvider, $compileProvider) {
        $compileProvider.urlSanitizationWhitelist(/^\s*(https?|ftp|mailto|file):/);


        $routeProvider.when('/view', {controller: 'HomeCtrl',
            templateUrl: 'resources/partials/welcome.html'});

        $routeProvider.when('/customers', {controller: 'CustomersCtrl',
            templateUrl: 'resources/partials/customers.html'});

        $routeProvider.when('/customer/:uuid', {controller: 'CustomerCtrl',
            templateUrl: 'resources/partials/customer.html'});


        $routeProvider.when('/agents', {controller: 'AgentsCtrl',
            templateUrl: 'resources/partials/agents.html'});

        $routeProvider.when('/agent/:uuid', {controller: 'agentCtrl',
            templateUrl: 'resources/partials/agent.html'});

        $routeProvider.otherwise({redirectTo: '/view'});
    }]);


swfMod.factory('$customerService', function ($http) {
    var getCustomers = function (search, pageNumber, pageSize) {
        if (search === undefined) {
            // replace undefined search term with empty string
            search = '';
        }
        return $http.get("list/allCustomers.json?search=" + search + "&pageNumber=" + pageNumber + "&pageSize=" + pageSize);
    };
    var getCustomer = function (uuid) {
        return $http.get("customer.json?uuid=" + uuid);
    };
    var saveCustomer = function (name,phone_number,id_number, current_balance,uuid) {

        return $http.post("customerUpdateSave.json", {"name": name, "phone_number": phone_number, "id_number":id_number, "current_balance": current_balance, "uuid":uuid});
    };

    return {
        getCustomer: getCustomer,
        getCustomers: getCustomers,
        saveCustomer: saveCustomer


    }
});


swfMod.factory('$agentService', function ($http) {
    var getAgents = function (search, pageNumber, pageSize) {
        if (search === undefined) {
            // replace undefined search term with empty string
            search = '';
        }
        return $http.get("list/allAgents.json?search=" + search + "&pageNumber=" + pageNumber + "&pageSize=" + pageSize);
    };
    var getAgent = function (uuid) {
        return $http.get("agent.json?uuid=" + uuid);
    };
    var saveAgent = function (agent_number,company_name,location, uuid) {

        return $http.post("agentUpdateSave.json", {"agent_number": agent_number, "company_name": company_name, "location":location, "uuid": uuid});
    };

    return {
        getAgents: getAgents,
        getAgent: getAgent,
        saveAgent: saveAgent


    }
});

