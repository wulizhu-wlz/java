package com.ipaynow.bcfinance.environment;

import com.ipaynow.bcfinance.enums.ExceptionEnum;
import com.ipaynow.bcfinance.expcetion.ValidationException;
import com.ipaynow.security.sign.ecdsa.SignUtil;
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
@Profile({"prd"})
public class PrdEnvironment implements Environment {

    private Logger logger = LoggerFactory.getLogger(PrdEnvironment.class);

    @Value("${jiuying.publicKey}")
    private String joinMessagePubkey;


    @Override
    public void signVerify(String message) {
        boolean verify;
        try {
            verify = SignUtil.verify(joinMessagePubkey, message);
        } catch (Exception e) {
            logger.error("验签失败，joinMessagePubkey={},message:{}", joinMessagePubkey, message);
            throw new ValidationException(ExceptionEnum.SIGN_FAIL);
        }
        if (!verify) {
            logger.error("验签失败，joinMessagePubkey={},message:{}", joinMessagePubkey, message);
            throw new ValidationException(ExceptionEnum.SIGN_FAIL);
        }
    }
}
