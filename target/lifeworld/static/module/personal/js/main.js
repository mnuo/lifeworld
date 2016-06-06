/**
 * 入口文件
 * 2014-11-30 mon
 */
require.config({
    baseUrl: "../../",
    paths: {
      "jquery": "libs/jquery-1.11.1.min",
      "angular": "libs/angular.min",
      'angularAMD': 'libs/angularAMD.min',
      "angular-route": "libs/angular-route.min",
      "angular-sanitize":"libs/angular-sanitize.min",
      "angular-ui-router":"libs/angular-ui-router.min",
  		"angular-animate" : "libs/angular-animate.min",
    	"app":"module/personal/js/app"
    },
    shim: {
       'angular': {
          exports: 'angular'
       },
       'angular-route':{
          deps: ["angular"],
          exports: 'angular-route'
       },
       'angular-ui-router':{
      	 deps: ["angular"],
      	 exports: 'angular-ui-router'
       },
       'angular-animate':{
   				deps	:	["angular"],
   			 exports: 'angular-animate'
   			},
   		 'angularAMD':{
   			 deps	:	["angular"],
   			 exports: 'angularAMD'
   		 }
       
    }
});

require(['app']);
/*require(['jquery','angular','angular-route','angular-ui-router'
         ,'angular-animate','angularAMD','app','indexController'],function (jquery,angular,angularRoute
         ,angularSanitize,angularUiRouter,angularAnimate,angularAMD,app,indexController){
      $(function () {
            angular.bootstrap(document,["personalapp"]);
      });

});*/