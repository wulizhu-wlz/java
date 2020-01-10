app.controller('debtListCtrl', function($rootScope,$scope,public,$timeout,public){
    $scope.transQuery = {};
    $scope.conf = {currentPage: 1};
    $scope.getAllEmployee = function () {
        public.loading();
        $scope.transQuery.currentPage = $scope.conf.currentPage;
        public.getHttpData({
            url: 'getMerchantDebtList',
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
