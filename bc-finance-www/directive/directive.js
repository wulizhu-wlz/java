/**
 * 得到焦点
 * @param  {String} ) {               var FOCUS_CLASS [description]
 * @return {[type]}   [description]
 */
app.directive('ngFocusv', function (public) {
    var FOCUS_CLASS = "ng-focused";
    return{
        restrict:'A',
        require:'ngModel',
        link: function (scope, element, attrs,ctrl) {
            ctrl.$focused = false;
            element.bind('focus', function (evt) {
                element.addClass(FOCUS_CLASS);
                scope.$apply(function () {
                    ctrl.$focused = true;
                });
            }).bind('blur', function (val) {
                element.removeClass(FOCUS_CLASS);
                scope.$apply(function(){
                    ctrl.$focused = false;
                })
            })
        }
    }
});
/**
 * change select 选中菜单
 */
app.directive('ngChangev', function(){
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function(scope, element, attrs,ctrl){
            ctrl.$change = false;
            element.bind('change', function(){
                var result = $(this).val() ? true : false;
                scope.$apply(function(){
                    ctrl.$change = result;
                });
            });
        }
    }
});
app.directive('ngResetBtn', function(){
    return {
        restrict: 'A',
        link: function(scope, element, attrs){
            attrs.resetobj = attrs.resetobj ? attrs.resetobj : 'transQuery';
            element.bind('click', function(){
                scope[attrs.resetobj] = {};
                scope.conf.currentPage = 1;
                scope.getAllEmployee();
            });
        }
    }
});
/**
 * 表单列表查询
 */
app.directive('ngSearchBtn', function(defTime,public){
    return {
        restrict: 'A',
        link: function(scope, element, attrs){
            var $time = $(element).parents('table').find('.time-box').parent('td');
            var result = false;
            element.bind('click', function(){
                if($time.length > 0){
                    $time.each(function(){
                        var startVal = $(this).find('.time-box:eq(0) input').val(),
                            endVal = $(this).find('.time-box:eq(1) input').val();
                        if(!startVal || !endVal) return;
                        if(!defTime.quantum(startVal, endVal)){
                            public.msg($(this).prev('td').text() + '开始时间要小于结束时间,请重新选择时间！');
                            result = true;
                            return false;
                        }else{
                            result = false;
                        };
                    });
                };
                if(!result) scope.conf.currentPage == 1 ? scope.getAllEmployee() : scope.conf.currentPage = 1;
            });
        }
    }
});

/**
 * 返回上一页
 */
app.directive('ngBack', function(){
    return {
        restrict: 'A',
        link: function (scope, element, attrs,ctrl) {
            element.bind('click', function(){
                window.history.go(-1);
            });
        }
    }
});
app.directive('tip',function(){
    return {
        restrict : 'EA',
        transclude : true,
        replace: true,
        templateUrl:'views/tip.html',
        link : function(scope, element, attrs) {
            scope.dialog.showTipContent = false;
            scope.dialog.hideTipContent = function() {
                scope.dialog.showTipContent = false;
            };
            scope.dialog.submitFn = function(){
                scope.dialog[attrs.back]();
            };
        }
    }
});
/**
 * 全选
 */
app.directive('ngCheckall', function(){
    return {
        restrict: 'A',
        link: function (scope, element, attrs, ctrl) {
           var that = this;
           element.on('click', function(){
              that.$checkBox = $(this).parents('thead').next('tbody').find('input[type="checkbox"]');
              that.$checkBox.prop('checked', $(this).prop('checked'));
           });
        }
    }
});
/**
 * 批量处理
 */
app.directive('ngBatching', function(dialog,public){
    return {
        restrict: 'A',
        link: function (scope, element, attrs, ctrl) {
            var that = this;
            element.on('click', function(){
                var ary = [];
                that.$checkBox = $(this).parent('div').next('.table').find('tbody input[type="checkbox"]:checked');
                if(that.$checkBox.length == 0){
                    dialog.msg('请选择需要处理的数据！');
                    return;
                };
                that.$checkBox.each(function(){
                    ary.push(JSON.parse($(this).attr('data')));
                });
                var obj = {};
                obj[attrs.key] = JSON.stringify(ary);
                public.getHttpData({
                    url: attrs.src,
                    data: obj,
                    success: function(data){
                        dialog.msg(data.head.rm);
                        if(typeof scope.batchingcallBackFn == 'function') scope.batchingcallBackFn();
                    },
                    error: function(data){
                        dialog.msg(data.head.rm,2000);
                    }
                });
            });
        }
    }
});
/**
 * 银行，角色
 */
app.directive('uiBankRole', function() {
    return {
        restrict: 'EA',
        template: '<select class="form-control"  ng-options="x.id as x.name for x in bankRoleAry">'+
        '<option value="">全部</option>'+
        '</select>',
        replace: true,
        transclude: true,
        link: function ($scope, element, attrs) {
            $scope.bankRoleAry = [{
                id: '2',
                name: '银行'
            }, {
                id: '4',
                name: '第三方支付'
            },{
                id: '5',
                name: '开发者'
            }];
        }
    }
});
/**
 * 对账状态查询
 */
app.directive('uiCleanStatus', function() {
    return {
        restrict: 'EA',
        template: '<select class="form-control"  ng-options="x.id as x.name for x in cleanStatusAry">'+
        '<option value="">全部</option>'+
        '</select>',
        replace: true,
        transclude: true,
        link: function ($scope, element, attrs) {
            $scope.cleanStatusAry = [{
                id: '1',
                name: '未申请结算'
            }, {
                id: '2',
                name: '已申请结算'
            },{
                id: '3',
                name: '结算中'
            },{
                id: '4',
                name: '结算成功'
            },{
                id: '5',
                name: '结算失败'
            },{
                id: '6',
                name: '对账失败'
            }
            ];
        }
    }
});
/**
 * name: pagination
 * Version: 0.0.2
 * pagesLength 显示多少格数据
 * totalItems 总条数
 * currentPage 当前页
 * numberOfPages 总页数
 * jumpPageNum 跳转到第几页
 * itemsPerPage 每页显示多少条<div class="page-box-wrap">
 * pageboxwrap 是否浮动 conf.isFixed = false 浮动
 */
app.directive('pagination',function(public){
    return {
        restrict: 'EA',
        template: '<div class="page-list clearfix" ng-class="{pageboxwrap: !conf.isFixed}">' +
        '<div class="page-total pull-left dataTables_info" ng-show="conf.totalItems > 0">' +
        '共有<strong>{{ conf.totalItems }}</strong>条记录' +
        '</div>' +

        '<div class="pull-right"><ul class="pagination " ng-show="conf.totalItems > 0">' +
        '<li ng-class="{disabled: conf.currentPage == 1}" ng-click="prevPage()" class=""><a  class="prev-page" href="javascript:;">&lt;</a></li>' +
        '<li ng-repeat="item in pageList track by $index" ng-class="{active: item == conf.currentPage, separate: item == \'...\',pageBig:(1== conf.currentPage)||(conf.currentPage == conf.numberOfPages)}" ' +
        'ng-click="changeCurrentPage(item)">' +
        '<a href="javascript:;">{{ item }}</a>' +
        '</li>' +
        '<li ng-class="{disabled: conf.currentPage == conf.numberOfPages}" ng-click="nextPage()"><a href="javascript:;" class="next-page">&gt;</a></li>' +
        '<li class="go-page-content" ng-show="conf.totalItems > 0">' +
        '<input type="text" class="form-control input-sm inline"ng-model="jumpPageNum"/><button class="btn btn-sm btn-primary" ng-click="jumpToPage()">go</button>' +
        '</li></div></ul>' +
        '<div class="no-items" ng-show="conf.totalItems <= 0"><!--暂无数据--></div>' +
        '</div>',
        replace: true,
        transclude : true,
        link: function(scope, element, attrs){
            var obj =  scope.conf;
            // scope.conf.fixed = scope.conf.fixed ? scope.conf.fixed : 'page-box-wrap';
            // 变更当前页
            scope.changeCurrentPage = function(item) {
                if(item == '...') return;
                obj.currentPage = item;
            };
            // 定义分页的长度必须为奇数 (default:9)
            obj.pagesLength = parseInt(obj.itemsPerPage) ? parseInt(obj.itemsPerPage) : 9 ;
            // 如果不是奇数的时候处理一下
            if(obj.pagesLength % 2 === 0)  obj.pagesLength = obj.pagesLength -1;
            // pageList数组
            function getPagination(newValue, oldValue) {
                obj.totalItems = parseInt(obj.totalItems) ? parseInt(obj.totalItems) : 0;
                obj.itemsPerPage = parseInt(obj.itemsPerPage) ? parseInt(obj.itemsPerPage) : 15;
                obj.numberOfPages = Math.ceil(obj.totalItems / obj.itemsPerPage);
                scope.jumpPageNum = obj.currentPage;
                scope.pageList = [];
                if(obj.numberOfPages <= obj.pagesLength){
                    // 判断总页数如果小于等于分页的长度，若小于则直接显示
                    for(i =1; i <= obj.numberOfPages; i++){
                        scope.pageList.push(i);
                    }
                }else{
                    // 总页数大于分页长度（此时分为三种情况：1.左边没有...2.右边没有...3.左右都有...）
                    // 计算中心偏移量
                    var offset = (obj.pagesLength - 1)/2;
                    if(obj.currentPage <= offset){
                        // 左边没有...
                        for(i =1; i <= offset +1; i++){
                            scope.pageList.push(i);
                        }
                        scope.pageList.push('...');
                        scope.pageList.push(obj.numberOfPages);
                    }else if(obj.currentPage > obj.numberOfPages - offset){
                        scope.pageList.push(1);
                        scope.pageList.push('...');
                        for(i = offset + 1; i >= 1; i--){
                            scope.pageList.push(obj.numberOfPages - i);
                        }
                        scope.pageList.push(obj.numberOfPages);
                    }else{
                        // 最后一种情况，两边都有...
                        scope.pageList.push(1);
                        scope.pageList.push('...');

                        for(i = Math.ceil(offset/2) ; i >= 1; i--){
                            scope.pageList.push(obj.currentPage - i);
                        }
                        scope.pageList.push(obj.currentPage);
                        for(i = 1; i <= offset/2; i++){
                            scope.pageList.push(parseInt(obj.currentPage) + i);
                        }

                        scope.pageList.push('...');
                        scope.pageList.push(obj.numberOfPages);
                    }
                }
                if(obj.onChange){
                    if(!(oldValue != newValue && oldValue[0] == 0)) {
                        obj.onChange();
                    }
                };
                setTimeout(function(){
                    scope.setStyle();
                },100);
            };
            scope.$watch(function() {
                if(!obj.totalItems) obj.totalItems = 0;
                return obj.totalItems + ' ' +  obj.currentPage + ' ' + obj.itemsPerPage;
            }, getPagination);
            // prevPage
            scope.prevPage = function(){
                if(obj.currentPage > 1) obj.currentPage -= 1;
            };
            // nextPage
            scope.nextPage = function(){
                if(obj.currentPage < obj.numberOfPages) obj.currentPage += 1;
            };
            // 跳转页
            scope.jumpToPage = function(){
                scope.jumpPageNum = scope.jumpPageNum.toString().replace(/[^0-9]/g,'');
                scope.jumpPageNum = scope.jumpPageNum == 0 ? 1 : scope.jumpPageNum;
                scope.jumpPageNum = obj.currentPage = (scope.jumpPageNum <= obj.numberOfPages) ? scope.jumpPageNum : obj.numberOfPages;
            };
            scope.setStyle = function(){
                $(element).find('li a').removeClass('noclick');
                $(element).find('li a:not(a.prev-page,a.next-page)').each(function(){
                    if(!parseInt($(this).text())) $(this).addClass('noclick');
                })
            };
        }
    };
});

/**
 * 日历插件引用
 * bootstrap-datetimepicker
 * 时间选择时候类型：minView 时间类型
 * hsm 时间是否需要时分秒默认值，1：00:00:00， 2：23:59:59
 * scope.recoedType 限制开始时间与结束时间
 * attr.daystep 限制开始时间与结束时间的间距：数值为多少天，
 *
 * minview="2" hsm="1" daystep="30" endmax="1"
 */
app.directive('ngDate', function(defTime, public){
    return {
        restrict: 'A',
        link: function(scope, element, attr){
            var $obj = $(element);
            var minView = parseInt(attr.minview);
            var todayBtn = true;
            switch(minView){
                case 1: var time="yyyy-mm-dd hh:ii:ss", minView = 1; break;
                case 3: var time="yyyy-mm", minView = 3, todayBtn = false; break;
                default: var time = "yyyy-mm-dd", minView = 2;
            };
            var hsmFn = function(){
                var hsm = parseInt(attr.hsm);
                var hsmV = '';
                switch(hsm){
                    case 1:hsmV = ' 00:00:00'; break;
                    case 2:hsmV = ' 23:59:59'; break;
                };
                return  hsmV;
            };
            var opts = {
                language: 'zh-CN',
                todayBtn: todayBtn,
                minView: minView,
                startView: minView,
                format: time,
                autoclose: 1
            };
            var date = new Date();
            switch(scope.recoedType){//当前交易，天不能选
                case "now": (function(){
                    opts.startDate =  new Date(date.getFullYear(),date.getMonth(),date.getDate(),"00","00","00");
                    opts.endDate = new Date(date.getFullYear(),date.getMonth(),date.getDate(),"23","59","59");
                })();
                    break;
                case "minNow": (function(){
                    opts.startDate =  new Date(date.getFullYear(),date.getMonth(),date.getDate() + 1,"00","00","00");
                })();
                    break;
                case "nextMonth": (function(){
                    opts.startDate =  new Date(date.getFullYear(),date.getMonth()+1,1,"00","00","00");
                })();
                    break;
            };
            //历史交易必须小于今天
            switch(attr.endmax){
                case "1": (function() {
                    opts.maxEnd = defTime.intervalSize(-1);
                    opts.endDate =  new Date(date.getFullYear(),date.getMonth(),date.getDate()-1,"23","59","59");
                })(); break;
            };
            //开始时间与结束时间限制在多少天之内，isClick标识点击了开始时间需更新结束时间
            var daystepFn = function (val) {
                var stepStart = val.replace(/-/g, '/'),
                    startTime = new Date(stepStart),
                    endDate = defTime.intervalSize(parseInt(attr.daystep), new Date(stepStart));
                var endInput = $obj.parent('.time-box').nextAll('.time-box').find('input');
                var realTime = (date.getTime() < endDate.getTime()) && attr.endmax ?  opts.maxEnd : endDate,
                    intervalTime = parseInt(attr.daystep) * 24 * 3600 * 1000;
                endInput.datetimepicker('setStartDate', startTime);
                endInput.datetimepicker('setEndDate', realTime);
                if(isClick){//如end输入框的值大于了开始时间+daystep天就进行更换
                    var str1 = endInput.attr('hsm') == 2 ? ' 23:59:59' : '';
                    var str = startTime.getFullYear() + '-' + defTime.setFat(startTime.getMonth()+1) + '-' + defTime.setFat(startTime.getDate()) +  str1;
                    var modelAry = public.modelStr(endInput);
                    var endIptStr = scope[modelAry[0]][modelAry[1]].replace(/-/g, '/'),
                        endIptDate = new Date(endIptStr),
                        result = endIptDate.getTime() - startTime.getTime();
                    if(result > intervalTime || result < 0) scope[modelAry[0]][modelAry[1]] = str; //结束与开始差值大于所定的差值时间就进行变更
                    isClick = false;
                };
            };
            if(attr.daystep){
                var isClick = false;
                scope.$watch($obj.attr('ng-model'),daystepFn)
            };
            $obj.datetimepicker(opts).on("hide", function(){
                if(attr.daystep) isClick = true;
                var time = $obj.val() + hsmFn();
                scope.$apply(function(){
                    var modelType = $obj.attr('ng-model');
                    if(modelType.indexOf('.') > -1){
                        var data = $obj.attr('ng-model').split('.');
                        scope[data[0]][data[1]] = time;
                    }else{
                        scope[$obj.attr('ng-model')] = time;
                    };
                });
                $obj.val(time);//防止用户没有选择,默认的hsm值赋值不上
            });
            $obj.siblings('.add-on').on('click', function(e){
                var $cur = $(e.currentTarget);
                $cur.siblings('.form-control').datetimepicker('show');
            });
            $('#content').on('scroll',function(){
                $('.form-control').blur()
                $obj.datetimepicker('hide');
            });
        }
    }
});

