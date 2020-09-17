var app = angular.module('dataApp', []);

app.controller('dataCtrl', function($scope, $http){
	$scope.submit = function(){
		/*
		$scope.user ={
				firstname: "",
				lastname: ""
		};
		*/
		console.log($scope.user);
		//console.log(angular.toJson($scope.user));
		//console.log($scope.user.firstname);
		
		$http({
			method:"POST",
			url:"http://localhost:8084/publish",
			data: angular.toJson($scope.user),
			headers:{"Content-Type":"application/json" }
		}).then(function success(response){
			console.log(response.data);			
		}, 
		function error(response){
			console.log("error found");
			console.log(response.data);
		})	
	
	}
});

