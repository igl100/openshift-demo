
app.controller("MainController", function MainController($scope, $http){
	$scope.testData =[];
	
	$scope.postIt = function() {
		$http({
		      method: 'GET',
		      url: 'http://microservice-demo-test.apps.cloud.igalvan.com/rest/getall'
		   }).then(function (response){
			   console.log(response);
		       $scope.testData = response.data;
		   },function (error){
			   console.log("AJAX failed!");
		   });
    };
});	
