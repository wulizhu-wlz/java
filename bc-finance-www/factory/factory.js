app.factory('public', function($timeout,$http,$rootScope, $timeout, handle, $location){
    var publicFn = {
        getHttpData: function(data){
            var that = this;
            $http({
                method: data.type ? data.type : 'post',
                data: data.data,
                dataType: 'json',
                url:  $rootScope.basePath + data.url + '.do'
            }).success(function(result){
                if(!result) return;
                var h = result.head;
                $rootScope.isLoading = false;
                if(h.rd == 2){
                    that.msg(h.rm);
                    $timeout(function(){
                        $location.path('/login');
                    }, 1000);
                }else if(h.rd == 1){
                    if(data.error && typeof data.error == 'function'){
                        data.error(result);
                    };
                }else if(h.rd == 0){
                    if(data.success && typeof data.success == 'function'){
                        data.success(result);
                    };
                }else if(h.rd == 3){
                    that.msg(h.rm);
                }
            });
        },
        loading: function(){
            $rootScope.isLoading = true;
            $rootScope.$emit('loading', $rootScope.isLoading);
        },
        msg: function(text,time){
            var time = time ? time : 2000,
                $tip = $('<div class="tip-box">'+text+'</div>');
                $tip.appendTo('body').css({
                    width: $tip[0].offsetWidth + 20
                });
            $timeout(function(){
                $tip.remove();
            },time);
        },
        navStyle: function(scope){
            for(var i=1; i<=l; i++){
                scope['isSelected' + i] = (index == i) ? true : false;
            };
        },
        pageTotal: function(obj,data) {
            var paginator = data.body.paginator;
            if (paginator) {
                obj.conf.totalItems = paginator.totalCount;
                obj.conf.itemsPerPage = paginator.pageSize;
            } else {
                obj.conf.totalItems = 0;
                obj.conf.itemsPerPage = 0;
            };
        },
        goBack: function(){
            window.history.go(-1);
        },
        /**
         * 上传文件
         * 参数 {
         *  src //上传地址
         *  arg //上传需要的参数
         *  obj //jQuery 对象
         * }
         */
        uploadFild: function(data){
            var that = this;
            var parameter = {
                src: 'order/uploadcsvfile.do',
                data: {},
                obj: $('.uploadFile')
            };
            that.opts = $.extend({}, parameter, data);
            that.opts.scope.isUpload = true;
            that.opts.obj.upload({
                    url: $rootScope.basePath + that.opts.src,
                    dataType: 'json',
                    params: that.opts.data,
                    onSend: function (obj, str) {  return true; },
                    // 上传之后回调
                    onComplate: function (data) {
                        that.msg(data.head.rm, 2000);
                        $timeout(function(){
                            that.opts.scope.isUpload = false;
                        });
                        if(data.head.rd == 0 && typeof that.opts.scope.getAllEmployee == 'function') that.opts.scope.getAllEmployee();
                    }
                });
            that.opts.obj.upload("ajaxSubmit");
        }

    };
    return publicFn;
});
/**
 * type: 1, 传入任意的文本或html和DOM
 * area: ['600px', '360px'],
 * shadeClose: true, //点击遮罩关闭
 * content: '\<\div style="padding:20px;">自定义内容\<\/div>'
 * btnAlign
 */
app.factory('dialog', function($timeout){
    var Dialog = {
        open: function(obj){
            var that = this;
            var parameter = {
                type: 1,
                area: ['auto', 'auto'],
                title: '操作',
                btn: ['确认','取消'],
                content: ''
            };
            that.parameter = $.extend({},parameter,obj);
            that.dialogHtml = $(that.wrapHtml());
            that.dialogHtml.appendTo('body');
            that.areaFn();//
            that.dialogHtml.find('.modal-footer button').on('click', function(){
                that.incidentFn();
            });
        },
        msg: function(text, time){
            var time = time ? time : 2000,
                $tip = $('<div class="tip-box">'+text+'</div>');
            $tip.appendTo('body').css({
                width: $tip[0].offsetWidth + 20
            });
            $timeout(function(){
                $tip.remove();
            },time);
        },
        titleHtml:function (){
            var that = this;
            return that.parameter.title ? '<p class="text-center pull-left">'+that.parameter.title+'</p>' : '';
        },
        btnHtml: function(){
            var that = this;
            var htmlBtn = '';
            that.parameter.btn.forEach(function(item,index){
               // var btnClass = index > 0 ? 'btn-white' : '';
                htmlBtn += '<button type="button" class="btn btn-primary btn-sm m-r-10 dialog-btn'+index+'" >'+item+'</button>';
            });
            return htmlBtn;
        },
        bodyHtml: function () {//instanceof
            var that = this,
                html = '';
            switch(that.parameter.type){
                case 1: html = that.parameter.content instanceof jQuery ? that.parameter.content.html() : that.parameter.content;
            };
            return html;
        },
        incidentFn: function(){//事件
            var that = this;
            if(typeof that.parameter.success == 'function') that.parameter.success();//层弹出后的成功回调方法
            that.parameter.btn.forEach(function(item,index){//按钮事件
                switch(index){
                    case 0: if(typeof that.parameter.yes == 'function') that.parameter.yes(); break;
                    case 1: if(typeof that.parameter.no == 'function') that.parameter.no(),that.closeDialog(); break;
                };
            });
            that.dialogHtml.find('.dialog-close').on('click', function(){//右上角关闭按钮触发的回调
                that.closeDialog();
                if(typeof that.parameter.cancel == 'function') that.parameter.cancel();
            });
        },
        closeDialog: function(){//关闭弹出框
           var that = this;
            that.dialogHtml.remove();
        },
        areaFn: function(){//弹出框高宽设置
            var that = this;
            that.$body = that.dialogHtml.find('.dialog-body');
            that.$body.css({
                width: that.parameter.area[0],
                height: that.parameter.area[1]
            });
            that.$wrap = that.dialogHtml.find('.tipContent');
            var scrollW = that.$wrap[0].scrollWidth,
                scrollH = that.$wrap[0].scrollHeight;
            that.$wrap.css({
                marginTop: - scrollH/2,
                marginLeft: - scrollW/2,
                width: scrollW,
                height: scrollH
            });
        },
        wrapHtml: function(){
            var that = this;
            var html = '<div class="modal modal-box" style="display: block">' +
                            '<div class="tipContent">' +
                                '<div class="modal-content">'+
                                    '<div class="modal-header clearfix">'+
                                         that.titleHtml()+
                                        '<button type="button" class="close pull-right dialog-close"></button>'+
                                    '</div>' +
                                    '<div class="modal-body tip-modal-body dialog-body">'+that.bodyHtml()+'</div>'+
                                    '<div class="modal-footer text-center">'+that.btnHtml()+'</div>' +
                '</div></div></div>';
            return html;
        }
    };
    return Dialog;
});
/**
 * key 键值
 * expires 过期时间
 */
app.factory('handle', function(){
    var Cookie = {
        set: function(key, val, expires){

            var str = key + '=' + escape(val);
            if(expires > 0){
                var date = new Date();
                date.setTime(expires * 3600 * 1000);
                str += '; expires=' + date.toUTCString();
            };
            document.cookie = str;
        },
        get: function(key){
            var cookie = document.cookie.split('; ');
            var result = '';
            for(var i=0, l=cookie.length; i<l; i++){
                var data = cookie[i].split('=');
                if(data[0] == key)  return unescape(data[1]);
            }
        },
        del: function(key){
            var cookie = document.cookie,
                date = new Date;
            date.setTime(date.getTime() - 1000);
            document.cookie = key + '=' + '' +'; sprites=' + date.toUTCString();
        },
        delAll: function(){
            var keys=document.cookie.match(/[^ =;]+(?=\=)/g);
            if(keys){
                for (var i = keys.length; i--;){
                    document.cookie=keys[i]+'=0;expires=' + new Date( 0).toUTCString();
                }
            }
        }
    };
    return Cookie;
});
/**
 * 默认时间设定
 */
app.factory('defTime', function(){
    var defTimeFn = {
        getData: function(day,type){
            var data = new Date();
            if(day){
                var data1 = new Date();
                data1.setDate(data1.getDate() + day);
                data = data1;
            };
            function setFat(str){
                return str > 9 ? str : '0'+str;
            };
            function monthHandle(){//月账单处理
                var data1 = new Date();
                var daysInMonth = [31,28,31,30,31,30,31,31,30,31,30,31];
                if(data1.getFullYear()%4 == 0 && data1.getFullYear%100 != 0)  daysInMonth[1]= 29;
                data1.setDate(data1.getDate() - daysInMonth[data1.getMonth()]);
                return data1;
            };
            var str = setFat(data.getHours())+':'+setFat(data.getMinutes())+':'+setFat(data.getSeconds());
            switch(type){
                case 1: str ='00:00:00'; break;
                case 2: str = '23:59:59'; break;
                case 3: return monthHandle().getFullYear()+'-'+setFat(monthHandle().getMonth()+1); break;
                case 4: return monthHandle().getFullYear()+'-'+setFat(monthHandle().getMonth()+1); break;
                case 5: str = ''; break;
            };
            return data.getFullYear()+'-'+setFat(data.getMonth()+1)+'-'+setFat(data.getDate())+' '+ str;
        },
        quantum: function(start, end){//开始时间要小于最大时间
            if(!start || !end) return false;
            if(start.indexOf(':') < 1){
                start += ' 00:00:00';
                end += ' 23:59:59';
            };
            var s = new Date(start).getTime(),
                e = new Date(end).getTime();
            s = s ? s :  new Date(start.replace(/-/g, '/')).getTime();
            e = e ? e :  new Date(end.replace(/-/g, '/')).getTime();
            return e >= s;
        }
    };
    return defTimeFn;
})