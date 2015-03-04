/**
 * Created by vladimirb on 3/4/15.
 */

(function() {

    angular
        .module('app')
        .controller('Users', Users);

    function Users(UserService, Restangular) {
        var vm = this;
        vm.user = {};

        vm.users = [];
        UserService.getList().then(function(users) {
            vm.users = users;
        });


        vm.newUser = newUser;
        vm.active = active;
        vm.save = save;
        vm.remove = remove;

        function newUser() {
            vm.user = {};
            vm.edit = false;
        }

        function active(user) {
            vm.user = user;
            vm.edit = true;
        }

        function save() {
            if (vm.user.id) {
                UserService.one(''+vm.user.id).put(vm.user);
            } else {
                UserService.post(vm.user);
                vm.users.push(Restangular.restangularizeElement(UserService, vm.user));
            }
            vm.edit = false;
            vm.user = {};
        }

        function remove(user) {
            // user - Restangular Object
            if (user.id){
                user.remove();
            }
            vm.users = _.without(vm.users, user);
        }
    }

})();