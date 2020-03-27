package com.ipaynow.bcfinance.config;

import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author MLL
 * @title: EsConfig
 * @projectName marinabaysands
 * @description ES配置类
 * @date 2020/2/26 15:26
 */
@Configuration
@Log4j2
public class EsConfig {

    @Value("${es.hosts}")
    private String hosts;

    @Value("${es.port}")
    private int port;

    @Value("${es.schema}")
    private String schema;

    @Value("${es.connectTimeOut}")
    private int connectTimeOut;

    @Value("${es.socketTimeOut}")
    private int socketTimeOut;

    @Value("${es.connectionRequestTimeOut}")
    private int connectionRequestTimeOut;

    @Value("${es.maxConnectNum}")
    private int maxConnectNum;

    @Value("${es.maxConnectPerRoute}")
    private int maxConnectPerRoute;

    private static final boolean timeOutConfig = true;
    private static final boolean connectNumConfig = true;

    private RestHighLevelClient restHighLevelClient;

    /**
     * Bean name default  函数名字
     *
     * @return
     */
    @Bean(name = "restHighLevelClient")
    public RestHighLevelClient restHighLevelClient() {

        String[] hostArray = hosts.split(",");
        List<HttpHost> httpHosts = new ArrayList<>(hostArray.length);
        Arrays.stream(hostArray).forEach(item -> httpHosts.add(new HttpHost(item, port, schema)));
        httpHosts.forEach(System.out :: println);
        HttpHost[] httpHostsArray = new HttpHost[httpHosts.size()];
        RestClientBuilder builder = RestClient.builder(httpHosts.toArray(httpHostsArray));
        if (timeOutConfig) {
            setConnectTimeOutConfig(builder);
        }
        if (connectNumConfig) {
            setMutiConnectConfig(builder);
        }
        restHighLevelClient = new RestHighLevelClient(builder);
        return restHighLevelClient;
    }

    /**
     * client的连接延时配置
     */
    public void setConnectTimeOutConfig(RestClientBuilder builder) {

        builder.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
            @Override
            public RequestConfig.Builder customizeRequestConfig(RequestConfig.Builder requestConfigBuilder) {
                requestConfigBuilder.setConnectTimeout(connectTimeOut);
                requestConfigBuilder.setSocketTimeout(socketTimeOut);
                requestConfigBuilder.setConnectionRequestTimeout(connectionRequestTimeOut);
                return requestConfigBuilder;
            }
        });
    }

    /**
     *  client的连接数配置
     */
    public void setMutiConnectConfig(RestClientBuilder builder) {
        builder.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
            @Override
            public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
                httpClientBuilder.setMaxConnTotal(maxConnectNum);
                httpClientBuilder.setMaxConnPerRoute(maxConnectPerRoute);
                return httpClientBuilder;
            }
        });
    }

    /**
     * 关闭连接
     */
    @PreDestroy
    public void close() {

        log.info("**************关闭ES的连接**************");
        if (restHighLevelClient != null) {
            try {
                restHighLevelClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
