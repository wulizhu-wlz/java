package com.ipaynow.bcfinance.environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author ytw
 * @date 2019/7/3
 * description: 开发环境
 */

@Component
@Profile({"dev", "test", "pre","beta"})
public class DevEnvironment implements Environment {

    private Logger logger = LoggerFactory.getLogger(DevEnvironment.class);

    @Value("${jiuying.publicKey}")
    private String joinMessagePubkey;


    @Override
    public void signVerify(String message) {
        if (logger.isDebugEnabled()) {
            logger.debug("开发环境不验证签名");
        }
    }
}
