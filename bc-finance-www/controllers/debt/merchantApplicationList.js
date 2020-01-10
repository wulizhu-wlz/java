app.controller('merchantApplicationListCtrl', function($rootScope,$scope,public,$timeout,public){
    $scope.transQuery = {loanStatus:"0"};
    $scope.conf = {currentPage: 1};
    $scope.getAllEmployee = function () {
        public.loading();
        $scope.transQuery.currentPage = $scope.conf.currentPage;
        public.getHttpData({
            url: 'getMerchantApplicationPageList',
            data: $scope.transQuery,
            scope: $scope,
            success: function(data){
                $rootScope.isLoading = false;
                $scope.list = data.body.result;
                if ($scope.list.length == 0) {
                    $scope.panelSearchDialog = false;
                    return;
                } else {
                    $scope.panelSearchDialog = true;
                }
                public.pageTotal($scope, data);
            }
        });
    };
    $scope.$watch('conf.currentPage', $scope.getAllEmployee); //监听当前页的变化



});
