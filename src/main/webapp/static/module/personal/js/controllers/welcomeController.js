define(['app'], function(app) {
	app.register.controller('WelcomeController', [ '$scope','$timeout','$rootScope','$state',function($scope,$timeout,$rootScope,$state) {
		$scope.initializeController = function(){
			console.log('hello world1');
		};
		
	} ]);
});
