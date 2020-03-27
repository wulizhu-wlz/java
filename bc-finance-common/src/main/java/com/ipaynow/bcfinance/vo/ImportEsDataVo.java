package com.ipaynow.bcfinance.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author MLL
 * @title: ImportEsDataVo
 * @projectName marinabaysands
 * @description 导入ES的数据定义vo
 * @date 2020/2/27 17:28
 */
@Data
public class ImportEsDataVo {

    private String id;
    private long bizId;
    private List<String> categories;
    private List<String> tags;
    private String title;
    private String name;
    private String content;
    private String detail;
    private String imgUrl;
    private String linkUrl;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date bizCreatedTime;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date bizModifiedTime;
    private int channel;
    private int chDataType;
    private int isExternalLink;
    private int status;
    private long parentId;
    private String parentTitle;
    private String parentContent;
    private String parentImgUrl;
    private String parentLinkUrl;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

    private List<String> feature;

}
