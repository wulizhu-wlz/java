package com.ipaynow.bcfinance.vo;

import lombok.Data;

import java.util.List;

/**
 * @author MLL
 * @title: SearchResultVo
 * @projectName marinabaysands
 * @description
 * @date 2020/3/2 16:40
 */
@Data
public class SearchResultVo {

    private String bizId;

    private String title;

    private String content;

    private String imgUrl;

    private String linkUrl;

    private int channel;

    private int chDataType;

    private List<String> feature;

    private int isExternalLink;


}
