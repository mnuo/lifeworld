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
    	"app":"module/personal/js/app",
    	"ajaxService":"module/personal/js/services/httpservice",
    	
    	"ueditor":"libs/ueditor/ueditor.all.min",
    	"ueditor-config":"libs/ueditor/ueditor.config",
    	"ueditor-lang":"libs/ueditor/lang/zh-cn/zh-cn"
    },
    shim: {
       'angular': {
          exports: 'angular'
       },
       'angular-route':{
          deps: ["angular"],
          exports: 'angular-route'
       },
       'ueditor':{
      	 deps: ["ueditor-config"],
      	 exports: 'ueditor'
       },
       'ueditor-lang':{
      	 deps: ["ueditor"],
      	 exports: 'ueditor-lang'
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