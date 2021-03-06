package com.ipaynow.bcfinance.vo;

import lombok.Data;

import java.util.List;

/**
 * @author MLL
 * @title: SearchResultOriVo
 * @projectName marinabaysands
 * @description
 * @date 2020/3/2 16:40
 */
@Data
public class SearchResultOriVo {

    private String bizId;

    private String title;

    private String content;

    private String imgUrl;

    private String linkUrl;

    private int channel;

    private int chDataType;

    private List<String> feature;

    private int isExternalLink;

    private String parentId;

    private String parentTitle;

    private String parentContent;

    private String parentImgUrl;

    private String parentLinkUrl;


}
