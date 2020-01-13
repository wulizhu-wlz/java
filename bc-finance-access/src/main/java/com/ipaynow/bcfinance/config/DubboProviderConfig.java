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
public class DubboProviderConfig {

    @Value("${dubbo.service.timeout}")
    private int serviceTimeout;

    @Value("${dubbo.service.retries}")
    private int serviceRetries;

    @Value("${dubbo.service.version}")
    private String serviceVersion;

    @Value("${dubbo.service.group}")
    private String serviceGroup;



//    @Bean
//    public MonitorConfig monitorConfig() {
//        MonitorConfig mc = new MonitorConfig();
//        mc.setProtocol("registry");
//        return mc;
//    }

//    @Bean
//    public ReferenceConfig referenceConfig() {
//        ReferenceConfig rc = new ReferenceConfig();
//        rc.setMonitor(monitorConfig());
//        return rc;
//    }


//    @Bean
//    public ProviderConfig provider() {
//        ProviderConfig providerConfig = new ProviderConfig();
//        providerConfig.setMonitor(monitorConfig());
//        return providerConfig;
//    }

//    @Bean
//    public ServiceBean<BlockChainPaymentService> paymentServiceExport(BlockChainPaymentService blockChainPaymentService) {
//        ServiceBean<BlockChainPaymentService> serviceBean = new ServiceBean<>();
//        serviceBean.setInterface(BlockChainPaymentService.class.getName());
//        serviceBean.setRef(blockChainPaymentService);
//        serviceBean.setGroup(serviceGroup);
//        //serviceBean.setDelay(2000);
//        serviceBean.setVersion(serviceVersion);
//        serviceBean.setTimeout(serviceTimeout);
//        serviceBean.setRetries(serviceRetries);
//        serviceBean.setFilter("accessFilter");
//        return serviceBean;
//    }
}
