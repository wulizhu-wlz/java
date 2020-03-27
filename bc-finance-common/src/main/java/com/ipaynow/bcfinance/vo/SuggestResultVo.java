package com.ipaynow.bcfinance.vo;

import lombok.Data;

import java.util.List;

/**
 * @author MLL
 * @title: SuggestVo
 * @projectName marinabaysands
 * @description 搜索建议提示返回结果类
 * @date 2020/3/2 17:01
 */
@Data
public class SuggestResultVo {

    private long totalNum;

    private List<String> suggestText;

}
