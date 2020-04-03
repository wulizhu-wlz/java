package com.ipaynow.bcfinance.service.impl;

import com.ipaynow.bcfinance.EsUtil;
import com.ipaynow.bcfinance.enums.ChannelIdEnum;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import com.ipaynow.bcfinance.service.SearchFromEsService;

import com.ipaynow.bcfinance.vo.SearchPageVo;
import com.ipaynow.bcfinance.vo.SearchResultOriVo;
import com.ipaynow.bcfinance.vo.SearchResultResp;
import com.ipaynow.bcfinance.vo.SearchResultVo;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author MLL
 * @title: SearchFromEsServiceImpl
 * @projectName marinabaysands
 * @description
 * @date 2020/3/2 17:11
 */
@Service
@Log4j2
public class SearchFromEsServiceImpl implements SearchFromEsService {

    public static final String INDEX_NAME = "marindata";

    @Autowired
    private EsUtil esUtil;

    @Override
    public SearchPageVo<SearchResultVo> search(String text, int pageSize, int pageNum) throws BusinessException {

        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.from(pageSize * pageNum); // 页码从0开始，第一笔也从0开始
        builder.size(pageSize);
        //Analyzer analyzer = new Analyzer() {
        //    @Override
        //    protected TokenStreamComponents createComponents(String s) {
        //        return null;
        //    }
        //};
        MultiMatchQueryBuilder queryBuilders = QueryBuilders.multiMatchQuery(text, "categories", "tags", "name", "title", "content", "detail");
        //MatchQueryBuilder queryBuilders = QueryBuilders.matchQuery("content", text);
        //MatchPhraseQueryBuilder queryBuilders = QueryBuilders.matchPhraseQuery("detail", text);
        //MatchAllQueryBuilder queryBuilders = QueryBuilders.matchAllQuery();
        //queryBuilders.analyzer("ik_max_word");
        queryBuilders.field("title", 6);
        queryBuilders.field("name", 5);
        queryBuilders.field("tags", 4);
        queryBuilders.field("categories", 3);
        queryBuilders.field("content", 2);
        queryBuilders.field("detail", 1);
        log.info("----------queryBuilders={}", queryBuilders);
        //queryBuilders.type(MultiMatchQueryBuilder.Type.PHRASE);
        builder.query(queryBuilders);
        String[] includeFields = new String[] {};
        String[] excludeFields = new String[] {"detail"};
        builder.fetchSource(includeFields, excludeFields);

        log.info("----------builder={}", builder);
        SearchResultResp<SearchResultOriVo> resp = esUtil.search(INDEX_NAME, builder, SearchResultOriVo.class);

        SearchPageVo<SearchResultVo> searchPageVos = new SearchPageVo<>();
        searchPageVos.setResults(getSearchResultOriVo(resp.getDatas()));
        searchPageVos.setPageSize(pageSize);
        searchPageVos.setPagNum(pageNum);
        searchPageVos.setTotalNum(resp.getTotalNum());
        return searchPageVos;
    }

    @Override
    public List<String> suggest(String text, int pageSize) throws BusinessException {

        SearchSourceBuilder builder = new SearchSourceBuilder();
        CompletionSuggestionBuilder tagsSuggest = SuggestBuilders.completionSuggestion("tags.suggest").text(text).skipDuplicates(true);
        CompletionSuggestionBuilder categoriesSuggest = SuggestBuilders.completionSuggestion("categories.suggest").text(text).skipDuplicates(true);
        CompletionSuggestionBuilder titleSuggest = SuggestBuilders.completionSuggestion("title.suggest").text(text).skipDuplicates(true);
        CompletionSuggestionBuilder nameSuggest = SuggestBuilders.completionSuggestion("name.suggest").text(text).skipDuplicates(true);
        //CompletionSuggestionBuilder contentSuggest = SuggestBuilders.completionSuggestion("content").text(text).skipDuplicates(true);
        SuggestBuilder suggestBuilder = new SuggestBuilder();
        suggestBuilder.addSuggestion("tags_suggest", tagsSuggest);
        suggestBuilder.addSuggestion("categories_suggest", categoriesSuggest);
        suggestBuilder.addSuggestion("title_suggest", titleSuggest);
        suggestBuilder.addSuggestion("name_suggest", nameSuggest);
        //suggestBuilder.addSuggestion("content_suggest", contentSuggest);

        // TODO 不生效，需要研究下
        MatchQueryBuilder mqb = QueryBuilders.matchQuery("channel", "21");
        //builder.query(mqb);
        //builder.postFilter(mqb);
        builder.suggest(suggestBuilder);
        builder.from(0);
        builder.size(pageSize);
        String[] includeFields = new String[] {};
        String[] excludeFields = new String[] {"detail"};
        builder.fetchSource(includeFields, excludeFields);
        //return esUtil.suggest(INDEX_NAME, builder, "tags_suggest", "categories_suggest", "title_suggest", "name_suggest", "content_suggest");
        return esUtil.suggest(INDEX_NAME, builder, "tags_suggest", "categories_suggest", "title_suggest", "name_suggest");

    }

    @Override
    public SearchPageVo<SearchResultVo> searchInChannel(String text, ChannelIdEnum channelId, int pageSize, int pageNum) throws BusinessException {

        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.from(pageSize * pageNum); // 页码从0开始，第一笔也从0开始
        builder.size(pageSize);
        MultiMatchQueryBuilder queryBuilders = QueryBuilders.multiMatchQuery(text, "categories", "tags", "name", "title", "content", "detail");
        MatchQueryBuilder mqb = QueryBuilders.matchQuery("channel", channelId.getCode());
        log.info("----------queryBuilders={}", queryBuilders);
        //queryBuilders.type(MultiMatchQueryBuilder.Type.PHRASE);
        queryBuilders.field("title", 6);
        queryBuilders.field("name", 5);
        queryBuilders.field("tags", 4);
        queryBuilders.field("categories", 3);
        queryBuilders.field("content", 2);
        queryBuilders.field("detail", 1);
        builder.query(queryBuilders);

        builder.postFilter(mqb);
        //builder.query(mqb);
        String[] includeFields = new String[] {};
        String[] excludeFields = new String[] {"detail"};
        builder.fetchSource(includeFields, excludeFields);

        log.info("----------builder={}", builder);
        SearchResultResp<SearchResultOriVo> resp = esUtil.search(INDEX_NAME, builder, SearchResultOriVo.class);
        SearchPageVo<SearchResultVo> searchPageVos = new SearchPageVo<>();
        searchPageVos.setResults(getSearchResultOriVo(resp.getDatas()));
        searchPageVos.setPageSize(pageSize);
        searchPageVos.setPagNum(pageNum);
        searchPageVos.setTotalNum(resp.getTotalNum());
        return searchPageVos;

    }

    @Override
    public SearchPageVo<SearchResultVo> searchInChannel(String text, ChannelIdEnum channelId,
                          int pageSize, int pageNum, String... accurateText) throws BusinessException {


        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.from(pageSize * pageNum); // 页码从0开始，第一笔也从0开始
        builder.size(pageSize);
        MultiMatchQueryBuilder queryBuilders = QueryBuilders.multiMatchQuery(text, "categories", "tags", "name", "title", "content", "detail");
        log.info("----------queryBuilders={}", queryBuilders);
        //queryBuilders.type(MultiMatchQueryBuilder.Type.PHRASE);
        queryBuilders.field("title", 6);
        queryBuilders.field("name", 5);
        queryBuilders.field("tags", 4);
        queryBuilders.field("categories", 3);
        queryBuilders.field("content", 2);
        queryBuilders.field("detail", 1);
        builder.query(queryBuilders);


        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        for (String aText : accurateText) {
            if (StringUtils.isNotBlank(aText)) {
                boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("categories", aText));
            }
        }
        boolQueryBuilder.must(QueryBuilders.matchQuery("channel", channelId.getCode()));
        builder.postFilter(boolQueryBuilder);
        log.info("---------boolFilter={}", boolQueryBuilder);

        String[] includeFields = new String[] {};
        String[] excludeFields = new String[] {"detail"};
        builder.fetchSource(includeFields, excludeFields);

        log.info("----------builder={}", builder);
        SearchResultResp<SearchResultOriVo> resp = esUtil.search(INDEX_NAME, builder, SearchResultOriVo.class);
        SearchPageVo<SearchResultVo> searchPageVos = new SearchPageVo<>();
        searchPageVos.setResults(getSearchResultOriVo(resp.getDatas()));
        searchPageVos.setPageSize(pageSize);
        searchPageVos.setPagNum(pageNum);
        searchPageVos.setTotalNum(resp.getTotalNum());
        return searchPageVos;
    }


    private List<SearchResultVo> getSearchResultOriVo(List<SearchResultOriVo> searchResultOriVos) {

        List<SearchResultVo> vos = new ArrayList<>();
        for (SearchResultOriVo vo : searchResultOriVos) {
            SearchResultVo searchResultVo = new SearchResultVo();
            searchResultVo.setBizId(vo.getBizId());
            searchResultVo.setTitle(vo.getTitle());
            searchResultVo.setContent(vo.getContent());
            searchResultVo.setImgUrl(vo.getImgUrl());
            searchResultVo.setLinkUrl(vo.getLinkUrl());
            searchResultVo.setChannel(vo.getChannel());
            searchResultVo.setChDataType(vo.getChDataType());
            searchResultVo.setFeature(vo.getFeature());
            searchResultVo.setIsExternalLink(vo.getIsExternalLink());
            if (StringUtils.isNotBlank(vo.getParentId()) && StringUtils.isNotBlank(vo.getParentTitle())) {
                searchResultVo.setBizId(vo.getParentId());
                searchResultVo.setTitle(vo.getParentTitle());
                searchResultVo.setContent(vo.getParentContent());
                searchResultVo.setImgUrl(vo.getParentImgUrl());
                searchResultVo.setLinkUrl(vo.getParentLinkUrl());
            }
            vos.add(searchResultVo);
        }
        return vos;

    }

}
