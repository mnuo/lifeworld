define(['app','ueditor-lang'], function(app) {
	app.register.controller('InfopressController', [ '$scope','$http','$timeout',function($scope,$http,$timeout) {
		init();
		
		function init(){
			$scope.title = '';
			$scope.ue = UE.getEditor('editor');
		}
		
		$scope.submit = function(){
			var content = $scope.ue.getContent();
			if(content == ''){
				alert("不能提交");
				return;
			}
			$http.post('../../../blog/create', {title:$scope.title,content:content}).success(function(ret) {
		    alert(ret);
		  });
		};
		
		$scope.$on('$destroy', function() {
			$scope.ue.destroy();
  });
	} ]);
});
