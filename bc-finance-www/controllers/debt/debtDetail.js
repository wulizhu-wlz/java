app.controller('debtDetailCtrl', function($rootScope,$scope,public,$timeout,public,$location){
    $scope.transQuery = {};
    $scope.conf = {currentPage: 1};
    $scope.params = {
        userIdOfIPayNowOfDebtor: $location.search()['userIdOfIPayNowOfDebtor']
    };
    $scope.transQuery.userIdOfIPayNowOfDebtor = $scope.params.userIdOfIPayNowOfDebtor;

    $scope.getAllEmployee = function () {
        public.loading();
        $scope.transQuery.currentPage = $scope.conf.currentPage;
        public.getHttpData({
            url: 'getLoanCreditPageList',
            data: $scope.transQuery,
            scope: $scope,
            success: function(data){
                $rootScope.isLoading = false;
                $scope.list = data.body.result;
                public.pageTotal($scope, data);
            }
        });
    };
    $scope.$watch('conf.currentPage', $scope.getAllEmployee); //监听当前页的变化



});
