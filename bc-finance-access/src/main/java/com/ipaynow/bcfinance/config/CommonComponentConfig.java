package com.ipaynow.bcfinance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @author ytw
 * @date 2019/6/25
 * description: 公用组件配置
 */
@Configuration
public class CommonComponentConfig {


    /**
     * 公用线程池
     * @return
     */
    @Bean
    @SuppressWarnings("unchecked")
    public ExecutorService commonThreadPool() {
        return new ThreadPoolExecutor(10, 200, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());
    }

}
