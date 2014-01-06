angular.service('Users', function ($resource) {
    return $resource('list/users.json', {}, {
        show: {method:'GET'}
    });
});

angular.service('User', function ($resource) {
    return $resource('list/users.json', {}, {
        update: {method:'PUT'}
    });
});

