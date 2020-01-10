app.controller('platBusinessCtrl', function ($rootScope, $scope, public, $timeout, public, $location) {
    $scope.transQuery = {};
    $scope.conf = {currentPage: 1};
    $scope.params = {
        idOfTbMerchantUser: $location.search()['idOfTbMerchantUser']
    };
    $scope.transQuery.idOfTbMerchantUser = $scope.params.idOfTbMerchantUser;

    $scope.getAllEmployee = function () {
        public.loading();
        $scope.transQuery.currentPage = $scope.conf.currentPage;

        public.getHttpData({
            url: 'getMerchantPlatformBusinessPageList',
            data: $scope.transQuery,
            scope: $scope,
            success: function (data) {
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
