package com.ipaynow.bcfinance.service;

/**
 * @title: SearchFromEsService
 * @projectName marinabaysands
 * @description 从ES查询的服务类
 * @author MLL
 * @date 2020/2/26 13:57
 */



import com.ipaynow.bcfinance.enums.ChannelIdEnum;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import com.ipaynow.bcfinance.vo.SearchPageVo;
import com.ipaynow.bcfinance.vo.SearchResultVo;

import java.util.List;


/**
 *@program marinabaysands
 *@description 从ES查询的服务类
 *@author MLL
 *@date 2020-02-26 13:57
 */
public interface SearchFromEsService {

    SearchPageVo<SearchResultVo> search(String text, int pageSize, int pageNum) throws BusinessException;

    List<String> suggest(String text, int pageSize) throws BusinessException;

    SearchPageVo<SearchResultVo> searchInChannel(String text, ChannelIdEnum channelId, int pageSize, int pageNum) throws BusinessException;

    SearchPageVo<SearchResultVo> searchInChannel(String text, ChannelIdEnum channelId, int pageSize, int pageNum, String... accurateText) throws BusinessException;
}
