package com.ipaynow.bcfinance.es;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ipaynow.bcfinance.enums.ExceptionEnum;
import com.ipaynow.bcfinance.expcetion.BusinessException;
import lombok.extern.log4j.Log4j2;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.MultiSearchRequest;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.client.*;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.completion.CompletionSuggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author MLL
 * @title: EsUtil
 * @projectName marinabaysands
 * @description ES操作工具配封装
 * @date 2020/2/26 15:36
 */
@Component
@Log4j2
public class EsUtil {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 创建索引
     * @param index
     * @param requestOptions
     * @return
     */
    public boolean createIndex(String index, RequestOptions requestOptions) {
        CreateIndexRequest request = new CreateIndexRequest(index);
        boolean flag;
        try {
            CreateIndexResponse indexResponse = restHighLevelClient.indices().create(request, requestOptions);
            flag = indexResponse.isAcknowledged();
            if (flag) {
                log.info("创建索引成功!");
            }
            else {
                log.info("创建索引失败!");
            }
        } catch (IOException e) {
            log.error("failed to create index: {}.", index, e);
            flag = false;
        }
        return flag;
    }

    /**
     * 新增索引
     * @param index
     * @param document
     * @param id
     * @param object
     * @param requestOptions
     * @return
     */
    // TODO
    public String add(String index, String document, String id, JSONObject object, RequestOptions requestOptions) {
        IndexRequest indexRequest = new IndexRequest(index, document, id);
        try {
            indexRequest.source(object.toJSONString(), XContentType.JSON);
            IndexResponse indexResponse = restHighLevelClient.index(indexRequest, requestOptions);
            return indexResponse.getId();
        } catch (IOException e) {
            log.error("failed to add index: {}, document: {}, id: {}.", index, document, id, e);
        }
        return null;
    }

    /**
     * 检查某索引是否存在:同步方法
     * @param request
     * @return
     */
    public boolean checkIndexExist(Request request) {
        try {
            Response response = restHighLevelClient.getLowLevelClient().performRequest(request);
            log.info("checkIndexExist 返回 " + JSONObject.toJSONString(response));
            return response.getStatusLine().getReasonPhrase().equals("OK");
        } catch (IOException e) {
            log.error("index is not exist, request is {}.", request, e);
        }
        return false;
    }


    public void createIndex(String idxName,String idxSQL){
        try {
            if (!this.indexExist(idxName)) {
                log.error(" idxName={} 已经存在,idxSql={}",idxName,idxSQL);
                return;
            }
            CreateIndexRequest request = new CreateIndexRequest(idxName);
            buildSetting(request);
            request.mapping(idxSQL, XContentType.JSON);
//            request.settings() 手工指定Setting
            CreateIndexResponse res = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
            if (!res.isAcknowledged()) {
                throw new RuntimeException("初始化失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public boolean indexExist(String idxName) throws Exception {
        GetIndexRequest request = new GetIndexRequest(idxName);
        request.local(false);
        request.humanReadable(true);
        request.includeDefaults(false);
        request.indicesOptions(IndicesOptions.lenientExpandOpen());
        return restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
    }

    public boolean isExistsIndex(String idxName) throws Exception {
        return restHighLevelClient.indices().exists(new GetIndexRequest(idxName),RequestOptions.DEFAULT);
    }

    public void buildSetting(CreateIndexRequest request){
        request.settings(Settings.builder().put("index.number_of_shards",3)
                .put("index.number_of_replicas",2));
    }


    // TODO 需要交易重复插入导致的更新
    public void insertOrUpdateOne(String idxName, ImportEsDataVo esDataVo) throws BusinessException {

        IndexRequest request = new IndexRequest(idxName);
        log.info("请求数据 id={}, esDataVo={}", esDataVo.getId(), JSON.toJSONString(esDataVo));
        request.id(esDataVo.getId());
        request.source(JSONObject.toJSONString(esDataVo), XContentType.JSON);
        try {
            IndexResponse indexResponse = restHighLevelClient.index(request, RequestOptions.DEFAULT);
            log.info("新增数据返回结果 indexResponse=" + JSON.toJSONString(indexResponse));
            if (!DocWriteResponse.Result.CREATED.equals(indexResponse.getResult()) && !DocWriteResponse.Result.UPDATED.equals(indexResponse.getResult())) {
                throw new BusinessException(ExceptionEnum.ES_INSERT_ERROR);
            }
        } catch (BusinessException e) {
            log.error("insertOrUpdateOne BusinessException", e);
            throw e;
        }   catch (Exception e) {
            log.error("insertOrUpdateOne Exception", e);
            throw new BusinessException(ExceptionEnum.SYSTEM_ERROR);
        }
    }


    public void insertBatch(String idxName, List<ImportEsDataVo> list) {
        BulkRequest request = new BulkRequest();
        list.forEach(item -> {
            request.add(new IndexRequest(idxName).id(item.getId())
                .source(JSONObject.toJSONString(item), XContentType.JSON));
        });
        try {
            restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> void deleteBatch(String idxName, Collection<T> idList) {
        BulkRequest request = new BulkRequest();
        idList.forEach(item -> request.add(new DeleteRequest(idxName, item.toString())));
        try {
            restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> SearchResultResp<T> search(String idxName, SearchSourceBuilder builder, Class<T> c) {

        try {
            SearchRequest request = new SearchRequest(idxName);
            request.source(builder);
            SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
            log.info("ESUtil.search 返回结果 response={}", JSONObject.toJSONString(response));
            SearchHit[] hits = response.getHits().getHits();
            List<T> datas = new ArrayList<>(hits.length);
            for (SearchHit hit : hits) {
                SearchResultVo srv = new SearchResultVo();
                datas.add(JSON.parseObject(hit.getSourceAsString(), c));
            }
            TotalHits totalHits = response.getHits().getTotalHits();
            SearchResultResp<T> resp = new SearchResultResp<T>();
            resp.setTotalNum(totalHits.value);
            resp.setDatas(datas);
            return resp;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public <T> SearchResultResp<T> multiSearch(String idxName, SearchSourceBuilder builder, Class<T> c) {

        try {
            SearchRequest request = new SearchRequest(idxName);
            request.source(builder);
            MultiSearchRequest multiRequest = new MultiSearchRequest();
            multiRequest.add(request);
            MultiSearchResponse response = restHighLevelClient.msearch(multiRequest, RequestOptions.DEFAULT);
            log.info("ESUtil.search 返回结果 response={}", JSONObject.toJSONString(response));

            MultiSearchResponse.Item firstResponse = response.getResponses()[0];
            SearchResponse searchResponse = firstResponse.getResponse();
            log.info("{}", searchResponse.getHits().getTotalHits().value);
            // TODO 关注second响应
            //MultiSearchResponse.Item secondResponse = response.getResponses()[1];
            //searchResponse = secondResponse.getResponse();
            //log.info("{}", searchResponse.getHits().getTotalHits().value);

            SearchHit[] hits = searchResponse.getHits().getHits();
            List<T> datas = new ArrayList<>(hits.length);
            for (SearchHit hit : hits) {
                datas.add(JSON.parseObject(hit.getSourceAsString(), c));
            }
            TotalHits totalHits = searchResponse.getHits().getTotalHits();
            SearchResultResp<T> resp = new SearchResultResp<T>();
            resp.setTotalNum(totalHits.value);
            resp.setDatas(datas);
            return resp;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteIndex(String idxName) {
        try {
            if (!this.indexExist(idxName)) {
                log.error(" idxName={} 已经存在",idxName);
                return;
            }
            restHighLevelClient.indices().delete(new DeleteIndexRequest(idxName), RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteByQuery(String idxName, QueryBuilder builder) {

        DeleteByQueryRequest request = new DeleteByQueryRequest(idxName);
        request.setQuery(builder);
        //设置批量操作数量,最大为10000
        request.setBatchSize(10000);
        request.setConflicts("proceed");
        try {
            restHighLevelClient.deleteByQuery(request, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<String> suggest(String idxName, SearchSourceBuilder builder, String... suggestNames) {

        try {
            SearchRequest request = new SearchRequest(idxName);
            request.source(builder);
            SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
            Suggest suggest = response.getSuggest();
            List<String> datas = new ArrayList<>();
            for (String suggestName : suggestNames) {
                CompletionSuggestion comSuggestion = suggest.getSuggestion(suggestName);
                log.info("ESUtil.suggest 返回结果 response={}", JSONObject.toJSONString(comSuggestion));
                for (CompletionSuggestion.Entry entry : comSuggestion.getEntries()) {
                    for (CompletionSuggestion.Entry.Option option : entry) {
                        datas.add(option.getText().string());
                    }
                }
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
