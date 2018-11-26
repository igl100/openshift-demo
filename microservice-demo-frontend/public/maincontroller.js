
app.controller("MainController", function MainController($scope, $http){
	$scope.testData =[];
	$scope.postIt = function() {
		$http({
		      method: 'GET',
		      url: 'http://localhost:8080/services/rest/getall'
		   }).then(function (response){
			   console.log(response);
		       $scope.testData = response.data;
		   },function (error){
			   console.log("AJAX failed!");
		   });
    };
});	
