app.config(["$stateProvider","$urlRouterProvider","$locationProvider",routeFn]);
function routeFn($stateProvider,$urlRouterProvider,$locationProvider) {
    $urlRouterProvider.otherwise("/login");// 默认进入先重定向
    $stateProvider.state("login", {
            url: "/login",
            templateUrl: "views/login.html?v=1c374f3bcc",
            controller: "loginCtrl",
            controllerAs: "login",
            resolve: {
                deps: ["$ocLazyLoad", function ($ocLazyLoad) {
                    return $ocLazyLoad.load(['controllers/login.js?v=e41a290f8d']);
                }]
            }
        })

        .state("debtList",{
            url: "/debtList",
            templateUrl: "views/debt/debtList.html?v=b2c199d1b0",
            controller: "debtListCtrl",
            controllerAs: "debtList",
            resolve: {
                deps: ["$ocLazyLoad", function ($ocLazyLoad) {
                    return $ocLazyLoad.load(['controllers/debt/debtList.js?v=5e0b2c5a63']);
                }]
            }
        })
        .state("debtDetail",{
            url: "/debtDetail",
            templateUrl: "views/debt/debtDetail.html?v=b2c199d1b0",
            controller: "debtDetailCtrl",
            controllerAs: "debtDetail",
            resolve: {
                deps: ["$ocLazyLoad", function ($ocLazyLoad) {
                    return $ocLazyLoad.load(['controllers/debt/debtDetail.js?v=5e0b2c5a63']);
                }]
            }
        })
        .state("refundList",{
            url: "/refundList",
            templateUrl: "views/debt/refundList.html?v=b2c199d1b0",
            controller: "refundCtrl",
            controllerAs: "refund",
            resolve: {
                deps: ["$ocLazyLoad", function ($ocLazyLoad) {
                    return $ocLazyLoad.load(['controllers/debt/refundList.js?v=5e0b2c5a63']);
                }]
            }
        })
        .state("platBusinessList",{
            url: "/platBusinessList",
            templateUrl: "views/debt/platBusinessList.html?v=b2c199d1b0",
            controller: "platBusinessCtrl",
            controllerAs: "platBusiness",
            resolve: {
                deps: ["$ocLazyLoad", function ($ocLazyLoad) {
                    return $ocLazyLoad.load(['controllers/debt/platBusinessList.js?v=5e0b2c5a63']);
                }]
            }
        })

        .state("advanceInfoList",{
            url: "/advanceInfoList",
            templateUrl: "views/debt/advanceInfoList.html?v=b2c199d1b0",
            controller: "advanceInfoCtrl",
            controllerAs: "advanceInfo",
            resolve: {
                deps: ["$ocLazyLoad", function ($ocLazyLoad) {
                    return $ocLazyLoad.load(['controllers/debt/advanceInfoList.js?v=5e0b2c5a63']);
                }]
            }
        })

        .state("merchantApplicationList",{
            url: "/merchantApplicationList",
            templateUrl: "views/debt/merchantApplicationList.html?v=b2c199d1b0",
            controller: "merchantApplicationListCtrl",
            controllerAs: "mallCtrl",
            resolve: {
                deps: ["$ocLazyLoad", function ($ocLazyLoad) {
                    return $ocLazyLoad.load(['controllers/debt/merchantApplicationList.js?v=5e0b2c5a63']);
                }]
            }
        })
        $locationProvider.html5Mode(true);
    };
app.run(function($rootScope, handle, $location,public){
    $rootScope.$on('$stateChangeStart', function(evt, next, current){
        var result = (next.templateUrl &&next.templateUrl.indexOf('dialog') > -1) || (next.templateUrl.indexOf('login') > -1);
        $rootScope.isSidebarShow = !result;
        if(!handle.get('userNews')){
            $location.path('/login');//用户没有登录
        };
    });
});
