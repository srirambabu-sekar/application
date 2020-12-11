var app = angular.module("MessagesManagement", []);
 
// Javascript Controller
app.controller("MessagesController", function($scope, $http) {
 
    $scope.customerForm = [];
    $scope.messages = [];
    $scope.searchKeyword = "";
    $scope.validLogin = false;
    $scope.noData = true;
 
    // Private Method 
    // HTTP GET- Validating login
    // Call: http://localhost:8080/message/login/{userName}/{password}
    $scope.pageLogin = function() {
        $scope.messages = [];
        $http({
            method : 'GET',
            url : '/message/login/'+ $scope.customerForm.userName + '/' + $scope.customerForm.password
        }).then(
            function(res) { // on success
                $scope.validLogin = res.data;
                if (res.data==true) {
                    $scope.customerForm = [];
                    getMessages();
                }
            },
            function(res) { // on error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    };
 
    // Private Method 
    // HTTP GET- Fetching Messages
    // Call: http://localhost:8080/message/fetch
    function getMessages() {
        $http({
            method: 'GET',
            url: '/message/fetch'
        }).then(
            function(res) { // success
                $scope.noData = res.data.length > 0 ? false : true;
                $scope.messages = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }
});