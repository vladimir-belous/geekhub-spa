/**
 * Created by vladimirb on 3/4/15.
 */

(function() {

    angular
        .module('app', ['ngRoute', 'restangular'])
        .config(config);

    function config($routeProvider, RestangularProvider) {

        RestangularProvider.setBaseUrl('/');

        $routeProvider

            // route for the home page
            .when('/', {
                templateUrl : 'pages/home.html',
                controller  : 'Main'
            })

            // route for the about page
            .when('/about', {
                templateUrl : 'pages/about.html',
                controller  : 'About'
            })

            // route for the contact page
            .when('/contact', {
                templateUrl : 'pages/contact.html',
                controller  : 'Contacts'
            })
            .when('/users', {
                templateUrl : 'pages/users.html',
                controller  : 'Users',
                controllerAs: 'vm'
            });
    }

})();