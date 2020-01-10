package com.ipaynow.bcfinance.cmb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @author ytw
 * @date 2019/07/09
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
    public ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(10, 100, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadPoolExecutor.CallerRunsPolicy());
    }

}
