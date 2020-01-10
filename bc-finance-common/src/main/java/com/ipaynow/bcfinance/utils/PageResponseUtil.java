package com.ipaynow.bcfinance.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by ipaynow0407 on 2017/10/16.
 */
public class PageResponseUtil {

    public static String getSuccessPageJSONString(int currentPage,int pageNum, int pageSize, long totalCount, List data){
        Paginator paginator = new Paginator();
        paginator.setCurrentPage(currentPage);
        paginator.setTotalCount(totalCount);
        paginator.setPageSize(pageSize);
        paginator.setPageNum(pageNum);
        Head head = new Head();
        head.setRd("0");
        head.setRm("成功");
        JSONObject body = new JSONObject();
        body.put("paginator", JSONObject.toJSON(paginator));
        body.put("result", data);
        JSONObject resp = new JSONObject();
        resp.put("head", head);
        resp.put("body", body);
        return resp.toJSONString();
    }

    public static String getSystemErrorPageJSONString(){
        Head head = new Head();
        head.setRd("1");
        head.setRm("系统异常");
        JSONObject resp = new JSONObject();
        resp.put("head", head);
        return resp.toJSONString();
    }

}
