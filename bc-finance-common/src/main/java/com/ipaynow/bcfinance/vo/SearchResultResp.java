package com.ipaynow.bcfinance.vo;

import lombok.Data;

import java.util.List;

/**
 * @author MLL
 * @title: SearchResultResp
 * @projectName marinabaysands
 * @description 查询ES返回结果响应类
 * @date 2020/3/5 14:06
 */
@Data
public class SearchResultResp<T> {

    private long totalNum;

    private List<T> datas;

}
