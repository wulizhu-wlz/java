package com.ipaynow.bcfinance.vo;

import com.ipaynow.bcfinance.enums.ChDataTypeEnum;
import com.ipaynow.bcfinance.enums.ChannelIdEnum;
import com.ipaynow.bcfinance.enums.IsExtLinkEnum;
import com.ipaynow.bcfinance.enums.StatusEnum;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author MLL
 * @title: EsDataVo
 * @projectName marinabaysands
 * @description 导入Es的Vo，对应ES的index字段
 * @date 2020/2/26 10:39
 */
@Data
public class EsDataVo {

    // TODO 需要确保biz_id+channel+ch_data_type拼接成的字符串全局唯一，主要用于防重和更新数据
    // TODO 字段描述见设计文档的 “1.4.5.2 ES索引结构涉及到的字段”

    //@NotNull
    private long bizId;
    private List<String> categories;
    private List<String> tags;
    //@NotNull
    private String title;
    private String name;
    private String content;
    private String detail;
    private String imgUrl;
    //@NotNull
    private String linkUrl;
    private Date bizCreatedTime;
    private Date bizModifiedTime;
    private ChannelIdEnum channel;
    private ChDataTypeEnum chDataType;
    private IsExtLinkEnum isExternalLink;
    private StatusEnum status;
    private long parentId;
    private String parentTitle;
    private String parentContent;
    private String parentImgUrl;
    private String parentLinkUrl;
    private List<String> feature;

    public static ImportEsDataVo getImportData(EsDataVo esDataVo) {

        StringBuilder sb = new StringBuilder();
        sb.append(esDataVo.getChannel().getCode()).append(esDataVo.getChDataType().getCode()).append(esDataVo.getBizId());
        ImportEsDataVo importEsDataVo = new ImportEsDataVo();
        importEsDataVo.setId(sb.toString());
        importEsDataVo.setBizId(esDataVo.getBizId());
        importEsDataVo.setCategories(esDataVo.getCategories());
        importEsDataVo.setTags(esDataVo.getTags());
        importEsDataVo.setTitle(esDataVo.getTitle());
        importEsDataVo.setName(esDataVo.getName());
        importEsDataVo.setContent(esDataVo.getContent());
        importEsDataVo.setDetail(esDataVo.getDetail());
        importEsDataVo.setImgUrl(esDataVo.getImgUrl());
        importEsDataVo.setLinkUrl(esDataVo.getLinkUrl());
        importEsDataVo.setBizCreatedTime(esDataVo.getBizCreatedTime());
        importEsDataVo.setBizModifiedTime(esDataVo.getBizModifiedTime());
        importEsDataVo.setChannel(esDataVo.getChannel() == null ? -1 : esDataVo.getChannel().getCode());
        importEsDataVo.setChDataType(esDataVo.getChDataType() == null ? -1 : esDataVo.getChDataType().getCode());
        importEsDataVo.setIsExternalLink(esDataVo.getIsExternalLink() == null ? -1 : esDataVo.getIsExternalLink().getCode());
        importEsDataVo.setStatus(esDataVo.getStatus() == null ? -1 : esDataVo.getStatus().getCode());
        importEsDataVo.setParentId(esDataVo.getParentId());
        importEsDataVo.setParentContent(esDataVo.getParentContent());
        importEsDataVo.setParentTitle(esDataVo.getParentTitle());
        importEsDataVo.setParentImgUrl(esDataVo.getParentImgUrl());
        importEsDataVo.setLinkUrl(esDataVo.getParentLinkUrl());
        Date now = new Date();
        importEsDataVo.setCreatedTime(now);
        importEsDataVo.setModifiedTime(now);
        importEsDataVo.setFeature(esDataVo.getFeature());
        return importEsDataVo;

    }

}
