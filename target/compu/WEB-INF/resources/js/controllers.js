
swfMod.controller('HomeCtrl', function($scope) {

    $scope.message = 'Trust and Commitment';

});


swfMod.controller('CustomersCtrl', function($scope, $location, $customerService) {
    // initialize selected error data for re-queueing
    $scope.selected = {};
    // initialize the paging structure
    $scope.maxSize = 20;
    $scope.pageSize = 20;
    $scope.currentPage = 1;
    $customerService.getCustomers($scope.search, $scope.currentPage, $scope.pageSize).
        then(function (response) {
            var serverData = response.data;
            $scope.customers = serverData.objects;
            $scope.noOfPages = serverData.pages;
        });
    $scope.$watch('currentPage', function (newValue, oldValue) {
        if (newValue != oldValue) {
            $customerService.getCustomers($scope.search, $scope.currentPage, $scope.pageSize).
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
            $customerService.getCustomers($scope.search, $scope.currentPage, $scope.pageSize).
                then(function (response) {
                    var serverData = response.data;
                    $scope.groups = serverData.objects;
                    $scope.noOfPages = serverData.pages;
                });
        }
    }, true);


} );


swfMod.controller('AgentsCtrl', function($scope, $location, $agentService) {
    // initialize selected error data for re-queueing
    $scope.selected = {};
    // initialize the paging structure
    $scope.maxSize = 20;
    $scope.pageSize = 20;
    $scope.currentPage = 1;
    $agentService.getAgents($scope.search, $scope.currentPage, $scope.pageSize).
        then(function (response) {
            var serverData = response.data;
            $scope.agents = serverData.objects;
            $scope.noOfPages = serverData.pages;
        });
    $scope.$watch('currentPage', function (newValue, oldValue) {
        if (newValue != oldValue) {
            $agentService.getAgents($scope.search, $scope.currentPage, $scope.pageSize).
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
            $agentService.getAgents($scope.search, $scope.currentPage, $scope.pageSize).
                then(function (response) {
                    var serverData = response.data;
                    $scope.groups = serverData.objects;
                    $scope.noOfPages = serverData.pages;
                });
        }
    }, true);


} );


var app = angular.module('myApp', []);

function LoginCheckCtrl($scope) {
    $scope.loginData = false
    $scope.login = function() {
        console.log($scope.loginData  ? 'logged in' : 'not logged in');
        $scope.loginData = true;
    };
    $scope.logout = function() {
        console.log($scope.loginData ? 'logged in' : 'not logged in');
        $scope.loginData = false;
    };
    $scope.checkboxSelection = '2';

    $scope.isCheckboxSelected = function(index) {
        return index === $scope.checkboxSelection;
    };
}


swfMod.controller('agentCtrl', function($scope, $routeParams, $location, $agentService) {
    // initialize the source object
    $scope.source = {};
    // initialize the view to be read only
    $scope.mode = "view";
    $scope.uuid = $routeParams.uuid;
    if ($scope.uuid === undefined) {
        $scope.mode = "edit";
    } else {
        $agentService.getAgent($scope.uuid).
            then(function(response) {
                $scope.agent = response.data;
            });
    }

    $scope.edit = function() {
        $scope.mode = "edit";
    };

    $scope.cancel = function() {
        $location.path("/agents");
    };



    $scope.save = function(agent) {
        $agentService.saveAgent(agent.agent_number,  agent.company_name,  agent.location,  agent.uuid).

            success(function(){
                $location.path("/agents");
            })
            .error(function(){
                $location.path("/agents");
            })

    };

});

swfMod.controller('CustomerCtrl', function($scope, $routeParams, $location, $customerService) {
    // initialize the source object
    $scope.source = {};
    // initialize the view to be read only
    $scope.mode = "view";
    $scope.uuid = $routeParams.uuid;
    if ($scope.uuid === undefined) {
        $scope.mode = "edit";
    } else {
        $customerService.getCustomer($scope.uuid).
            then(function(response) {
                $scope.customer = response.data;
            });
    }

    $scope.edit = function() {
        $scope.mode = "edit";
    };

    $scope.cancel = function() {
        $location.path("/customers");
    };



    $scope.save = function(customer) {
        $customerService.saveCustomer(customer.namez, customer.phone_number, customer.id_number, customer.current_balance, customer.uuid).

            success(function(){
                $location.path("/customers");
            })
            .error(function(){
                $location.path("/customers");
            })

    };

});
