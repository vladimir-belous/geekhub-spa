/**
 * Created by vladimirb on 3/4/15.
 */

(function() {

    angular
        .module('app')
        .factory('UserService', UserService);

    function UserService(Restangular) {
        return  Restangular.all('users');
    }

})();