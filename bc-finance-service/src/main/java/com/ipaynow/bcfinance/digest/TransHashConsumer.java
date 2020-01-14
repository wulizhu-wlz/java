package com.ipaynow.bcfinance.digest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ytw
 * @date 2019/11/1
 * description:交易信息摘要上链任务消费者
 */
@Slf4j
//@Component
public class TransHashConsumer implements InitializingBean {

    private static final int CONSUMER_TREADS = 50;

    @Resource
    private TransDigestQueue transDigestQueue;
//    @Resource
//    private TransHashContractService transHashContractService;

    private ExecutorService executorService = Executors.newFixedThreadPool(CONSUMER_TREADS);


    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("启动消费者线程...");
        for (int i = 0; i < CONSUMER_TREADS; i++) {
            executorService.execute(() -> {
//                while (true) {
//                    TransDigestBo transDigestBo = null;
//                    try {
//                        transDigestBo = transDigestQueue.take();
//                        transHashContractService.submit(transDigestBo);
//                    } catch (Exception e) {
//                        log.error("交易摘要消费者处理失败, transDigestBo={}", JSON.toJSONString(transDigestBo), e);
//                    } finally {
//                        //消费者处理完成
//                        transDigestQueue.removeProcessingId(transDigestBo.getId());
//                    }
//                }

            });
        }

    }

}
