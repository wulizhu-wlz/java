package com.ipaynow.bcfinance.config;

import com.alibaba.dubbo.config.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Created with IntelliJ IDEA.
 *
 * @author why Date: 2018/7/26 */
@Configuration
public class DubboBaseConfig {
//
//    @Value("${dubbo.application.name}")
//    private String applicationName;
//
//    @Value("${dubbo.registry.address}")
//    private String registryAddress;
//
//    @Value("${dubbo.protocol.port}")
//    private int protocolPort;
//
//    @Bean
//    public RegistryConfig registry() {
//        RegistryConfig registryConfig = new RegistryConfig();
//        registryConfig.setAddress(registryAddress);
//        registryConfig.setProtocol("dubbo");
//        return registryConfig;
//    }
//
//    @Bean
//    public ApplicationConfig application() {
//        ApplicationConfig applicationConfig = new ApplicationConfig();
//        applicationConfig.setName(applicationName);
//        return applicationConfig;
//    }

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
//    public ProtocolConfig protocol() {
//        ProtocolConfig protocolConfig = new ProtocolConfig();
//        protocolConfig.setPort(protocolPort);
//        return protocolConfig;
//    }
//
//    @Bean
//    public ProviderConfig provider() {
//        ProviderConfig providerConfig = new ProviderConfig();
//        providerConfig.setMonitor(monitorConfig());
//        return providerConfig;
//    }

}
