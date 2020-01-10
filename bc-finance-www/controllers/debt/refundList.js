app.controller('refundCtrl', function($rootScope,$scope,public,$timeout,$state,$location){
    $scope.transQuery = {};
    $scope.conf = {currentPage: 1};
    $scope.params = {
        idSlLoanCreditLog: $location.search()['idSlLoanCreditLog']
    };
    $scope.getAllEmployee = function(){
        public.loading();
        $scope.transQuery.currentPage = $scope.conf.currentPage;
        $scope.transQuery.idSlLoanCreditLog = $scope.params.idSlLoanCreditLog;
        public.getHttpData({
            url: 'getLoanRefundPageList',
            data: $scope.transQuery,
            success: function(data){
                $rootScope.isLoading = false;
                $scope.list = data.body.result;
                if($scope.list.length==0){
                    $scope.panelSearchDialog=false;
                    return;
                }else{
                    $scope.panelSearchDialog=true;
                }

                public.pageTotal($scope, data);
            }
        });
    };
    $scope.$watch('conf.currentPage', $scope.getAllEmployee); //监听当前页的变化

});
