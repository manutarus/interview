angular.service('Wine', function ($resource) {
    return $resource('api/ndivi/:wineId', {}, {
        update: {method:'PUT'}
    });
});
