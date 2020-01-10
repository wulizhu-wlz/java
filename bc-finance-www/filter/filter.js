app.filter('statusStr', function(){
    return function(val){
        return val == 1 ? '已开通' : '已冻结';
    };
})
app.filter('statusStr1', function(){
    return function(val){
        return val == 1 ? '成功' : '失败';
    };
})

app.filter('loanChannelFilter', function(){
    return function(val){
        var channelAry = ["未定义","供应链", "垫资", "未借款", "未贷款"];
        return channelAry[val];
    };
})

app.filter('creditstatusFilter',function(){
    return function (val) {
        var creditStatusArray=["初审拒绝","已审核未放款","已放款","已回款未提现","已提现"];
        return creditStatusArray[val+1];
    }
})