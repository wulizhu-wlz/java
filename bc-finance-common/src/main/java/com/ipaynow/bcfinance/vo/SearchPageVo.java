package com.ipaynow.bcfinance.vo;

import lombok.Data;

import java.util.List;

/**
 * @author MLL
 * @title: SearchPageVo
 * @projectName marinabaysands
 * @description 搜索分页类
 * @date 2020/3/2 16:25
 */
@Data
public class SearchPageVo<T> {

    private long totalNum;

    private int pagNum;

    private int pageSize;

    private List<T> results;
}
