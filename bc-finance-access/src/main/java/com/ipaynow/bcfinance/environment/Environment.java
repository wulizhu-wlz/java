package com.ipaynow.bcfinance.environment;

/**
 * @author ytw
 * @date 2019/7/3
 * description: 运行环境策略接口
 */
public interface Environment {

    //签名验证
    void signVerify(String message);
}
