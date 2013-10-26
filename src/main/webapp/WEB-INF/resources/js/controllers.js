function RouteCtrl($route) {

    var self = this;

    $route.when('/ndivi', {template:'resources/partials/welcome.html'});

    $route.when('/users', {template:'resources/partials/users.html'});

    $route.when('/ndivi/:wineId', {template:'resources/partials/side-list.html', controller:WineDetailCtrl});

    $route.otherwise({redirectTo:'/ndivi'});

    $route.onChange(function () {
        self.params = $route.current.params;
    });

    $route.parent(this);

    this.addWine = function () {
        window.location = "#/ndivi/add";
    };

}

function WineListCtrl(Wine) {

    this.ndivi = Wine.query();

}

function WineDetailCtrl(Wine) {

    this.wine = Wine.get({wineId:this.params.wineId});


    this.saveWine = function () {
        if (this.wine.id > 0)
            this.wine.$update({wineId:this.wine.id});
        else
            this.wine.$save();
        window.location = "#/ndivi";
    }

    this.deleteWine = function () {
        this.wine.$delete({wineId:this.wine.id}, function() {
            alert('Wine ' + wine.name + ' deleted')
            window.location = "#/ndivi";
        });
    }

}