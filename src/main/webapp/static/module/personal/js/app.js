/**
 * 建立angular.module
 */
define(['angular','angularAMD','angular-ui-router','angular-animate'], function (angular,angularAMD,io) {
		var app = angular.module('personalapp',  ['ngAnimate','ui.router']);
		app.config(['$stateProvider','$urlRouterProvider', function ($stateProvider,$urlRouterProvider) {
			$urlRouterProvider.when("", "/");
					$stateProvider
							.state("home",angularAMD.route({
												url : '/welcome',
												templateUrl : function(
														param) {
													return 'views/welcome.html';
												},
												controller : "js/controllers/welcomeController.js",
												controllerProvider : function() {

												}
											}))
							.state("menu",angularAMD.route({
											url : "/:parent/:menu",
											templateUrl : function(param) {
												return 'views/'+ param.parent+ '-'+ param.menu+ '.html';
											},
											resolve : {
												loadController : ['$q','$rootScope','$location','$stateParams',function($q,$rootScope,$location,$stateParams) {
															var parentPath = $stateParams.parent;
															var controllerName = $stateParams.menu;
															if (!controllerName)
																return;
															var loadController = "js/controllers/"+ parentPath+ controllerName + "Controller.js";
															var deferred = $q.defer();
															require([ loadController ],function() {
																		$rootScope.$apply(function() {
																					deferred.resolve();
																		});
																	});
															return deferred.promise;
														} ]
											}
										}))
							.state('unauthorized',angularAMD.route({
												url : '/unauthorized',
												templateUrl : function(
														param) {
													return 'index/views/unauthorized.html';
												},
												controller : "controllers/unauthorizedCtrl",
												controllerProvider : function() {

												}
											}));
							
					$urlRouterProvider.otherwise("/");
		}]);
		app.config(['$httpProvider',function ($httpProvider) {
			$httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
			 
		  /**
		   * The workhorse; converts an object to x-www-form-urlencoded serialization.
		   * @param {Object} obj
		   * @return {String}
		   */ 
		  var param = function(obj) {
		    var query = '', name, value, fullSubName, subName, subValue, innerObj, i;
		      
		    for(name in obj) {
		      value = obj[name];
		        
		      if(value instanceof Array) {
		        for(i=0; i<value.length; ++i) {
		          subValue = value[i];
		          fullSubName = name + '[' + i + ']';
		          innerObj = {};
		          innerObj[fullSubName] = subValue;
		          query += param(innerObj) + '&';
		        }
		      }
		      else if(value instanceof Object) {
		        for(subName in value) {
		          subValue = value[subName];
		          fullSubName = name + '[' + subName + ']';
		          innerObj = {};
		          innerObj[fullSubName] = subValue;
		          query += param(innerObj) + '&';
		        }
		      }
		      else if(value !== undefined && value !== null)
		        query += encodeURIComponent(name) + '=' + encodeURIComponent(value) + '&';
		    }
		      
		    return query.length ? query.substr(0, query.length - 1) : query;
		  };
		 
		  // Override $http service's default transformRequest
		  $httpProvider.defaults.transformRequest = [function(data) {
		    return angular.isObject(data) && String(data) !== '[object File]' ? param(data) : data;
		  }];
	}]);
		app.controller('IndexController', [ '$scope','$timeout','$rootScope','$state',function($scope,$timeout,$rootScope,$state) {
			$scope.initializeController = function(){
				$state.go('home',{});
				initData();
			};
			//跳转到对应的第一个子菜单
			$scope.changeItem = function(parent,index){
				var buss = $scope.data.navList[parent].list[index].url.split('/');
				/*if(buss.id==3){//热点分析弹出新页面
					openwin("../newWeb/hotspot/hotspotMain.jsp");
				}else if(buss.id==6){//系统配置弹出新页面
					openwin("../newWeb/sysmanager/sysmain.jsp");
				}else{
					var childurl = buss.children[0].url;
					var child = childurl.substring(buss.url.length+2,childurl.length);
				}*/
				$state.go('menu',{parent:buss[0],menu:buss[1]});
			};
			//togger伸缩左侧菜单
			$scope.togger = function(){
				if($scope.display.togger){
					$scope.display.togger = false;
				}else{
					$scope.display.togger = true;
				}
			};
			//showItem 是否显示子选项
			$scope.showItem = function(index){
				var obj = $scope.data.navList[index];
				if(!obj.showItem){
					obj.showItem = true;
				}else{
					obj.showItem = false;
				}
			};
			/*$scope.gotomenu = function(param){
				var arr = param.split('/');
				$state.go('menu',{parent:arr[0],menu:arr[1]});
			}*/
			function initData(){
				$scope.data = {
						navList:[{
								name:'个人中心',
								showItem:true,
								list:[{
										name:'账户资料',
										url:'user/info',
										avater:'icon-zhanghao'
									},
									{
										name:'修改密码',
										url:'user/password',
										avater:'icon-password'
									}]
						},
						{
							name:'信息管理',
							showItem:true,
							list:[{
										name:'图片相册',
										url:'info/photo',
										avater:'icon-xiangce'
									},
									{
										name:'博客文章',
										url:'info/blog',
										avater:'icon-bokefenxiang'
									},
									{
										name:'编辑文章',
										url:'info/press',
										avater:'icon-bokefenxiang'
									}]
						}]
				};
				$scope.display = {
						togger:true,
						active:0
				};
			}
			
		} ]);
		angularAMD.bootstrap(app);
    return app;
});
