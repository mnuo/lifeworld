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
							.state("message",angularAMD.route({
												url : '/message',
												templateUrl : function(
														param) {
													return 'index/views/message.html';
												},
												controller : "controllers/MessageCtrl",
												controllerProvider : function() {

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
		app.controller('IndexController', [ '$scope','$timeout','$rootScope','$state',function($scope,$timeout,$rootScope,$state) {
			$scope.initializeController = function(){
				$state.go('home',{});
				initData();
			};
			//跳转到对应的第一个子菜单
			$scope.gotoFirstMenu = function(index){
				var buss = $scope.busses[index];
				if(buss.id==3){//热点分析弹出新页面
					openwin("../newWeb/hotspot/hotspotMain.jsp");
				}else if(buss.id==6){//系统配置弹出新页面
					openwin("../newWeb/sysmanager/sysmain.jsp");
				}else{
					var childurl = buss.children[0].url;
					var child = childurl.substring(buss.url.length+2,childurl.length);
					$state.go('menu',{parent:buss.url,menu:child});
				}
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
			function initData(){
				$scope.data = {
						navList:[{
								name:'个人中心',
								showItem:true,
								list:[{
										name:'账户资料',
										url:'',
										avater:'icon-zhanghao'
									},
									{
										name:'修改密码',
										url:'',
										avater:'icon-password'
									}]
						},
						{
							name:'信息管理',
							showItem:true,
							list:[{
										name:'图片相册',
										url:'',
										avater:'icon-xiangce'
									},
									{
										name:'博客文章',
										url:'',
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
