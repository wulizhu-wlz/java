app.controller('indexCtrl', function($rootScope,$scope, $location, $timeout, handle,public,$timeout){
    $rootScope.isSidebar = $rootScope.isLoading = false;
    $rootScope.basePath =  $location.protocol() + '://' + $location.host() + ':' + $location.port() + '/';
    $scope.changeType = function(e,type){
        handle.set('clickType', type);
        $('.nav-header,.has-sub').hide();
        $('.nav-header[name="'+type+'"],.has-sub[name="'+type+'"]').show();
        $('.main-nav li[name="'+type+'"]').addClass('active').siblings('li').removeClass('active');
        if(e){//点击
            if($('.page-sidebar-fixed').hasClass('page-sidebar-minified')) return;
            $('.has-sub[name="'+type+'"]:visible:first .sub-menu>li:visible:first a').trigger('click');
            $location.path('/' + $('.has-sub[name="'+type+'"]:visible:first .sub-menu>li:visible:first a').attr('ng-href'));
        }else{//三级
            $timeout(function(){
                var href = $location.url();
                var str =  href.indexOf('?') >= 0 ? href.substring(href.indexOf('/')+1, href.indexOf('?')) : href.substring(href.indexOf('/')+1);
                var $obj = $('.sub-menu>li a[ng-href="'+str+'"]');
                var threeLevel = $obj.attr('ng-href') ? str : handle.get('threeLevel');
                $('.sub-menu>li a[ng-href="'+threeLevel+'"]').trigger('click');
            },500);
        }; 
    };

    $scope.firstMenu = function(){
        var type = handle.get('clickType');
        type = type ? type : 'debt';//默认页面
        $scope.changeType('', type);
    };
    $scope.closeLoading = function(){
        $rootScope.isLoading = false;
    };
    $scope.handleSidebar = function(){
        $rootScope.isSidebar = !$rootScope.isSidebar;
    };
    //菜单操作
    $('.has-sub>a').on('click', function(){
        var $obj = $(this).parent('li');
        $obj.find('.sub-menu').is(':visible') ? $obj.find('.sub-menu').hide() : $obj.find('.sub-menu').show();
        $obj.addClass('active').siblings('li').removeClass('active');
    });
    $('.sub-menu>li:visible a').on('click', function(){
        $('.sub-menu>li').removeClass('active');
        $(this).parent('li').addClass('active');
        $(this).parents('.has-sub').addClass('active').siblings('li').removeClass('active');
        handle.set('threeLevel', $(this).attr('ng-href'));
    });
    
    $scope.$on('userNews', function(event, msg){
        handle.set('userNews', JSON.stringify(msg));
        $rootScope.userNews = msg;
        $scope.firstMenu();
    });
    if(handle.get('userNews')){
        $rootScope.userNews = JSON.parse(handle.get('userNews'));
        $scope.firstMenu();
    };//用户登录
    
    if($location.url() == '/login'){
        handle.del('clickType');
        handle.del('threeLevel');
    };
    $rootScope.exitFn = function(){//记得清除cookie
        handle.del('clickType');
        handle.del('threeLevel');
        handle.del('userNews');
        $location.path('/login');
        // public.getHttpData({
        //     url: 'user/logout',
        //     success: function(data){
        //         handle.del('clickType');
        //         handle.del('threeLevel');
        //         handle.del('userNews');
        //         $location.path('/login');
        //     },
        //     error: function(){
        //         public.msg('退出失败！');
        //     }
        // });
    };
});

