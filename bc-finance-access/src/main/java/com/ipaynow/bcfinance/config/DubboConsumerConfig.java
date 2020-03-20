package com.ipaynow.bcfinance.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @author why
 * Date: 2018/7/26
 */
@Configuration
public class DubboConsumerConfig {

//    @Value("${dubbo.service.timeout}")
//    private int serviceTimeout;
//
//    @Value("${dubbo.service.retries}")
//    private int serviceRetries;
//
//    @Value("${dubbo.service.version}")
//    private String serviceVersion;
//
//    @Value("${dubbo.service.group}")
//    private String serviceGroup;
//
//    @Value("${dubbo.service.want.group}")
//    private String wantServiceGroup;

//    @Bean
//    public ReferenceBean<IMerchant> iMerchant(){
//        return createRefBean(IMerchant.class);
//    }
//
//    private <T> ReferenceBean<T> createRefBean(Class<T> type) {
//        ReferenceBean<T> ref = new ReferenceBean<>();
//        ref.setVersion(serviceVersion);
//        ref.setInterface(type);
//        ref.setTimeout(serviceTimeout);
//        ref.setRetries(serviceRetries);
//        ref.setGroup(serviceGroup);
//        ref.setCheck(false);
//        return ref;
//    }


}
