package com.ipaynow.bcfinance.digest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ytw
 * @date 2019/11/1
 * description:交易摘要上链任务生产者
 */
@Slf4j
//@Component
public class TransHashProducer implements InitializingBean {

    @Resource
    private TransDigestQueue transDigestQueue;

//    @Resource
//    private TransService transService;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("启动生产者线程...");
        Thread thread = new Thread(() -> {
            while (true) {
//                List<BcTrans> bcTransList = transService.selectSendChainList(transDigestQueue.getProcessingIds());
//                log.info("交易摘要任务生产者, 查询出待上链数据count={}", bcTransList.size());
//                try {
//                    if (bcTransList.size() == 0) {
//                        TimeUnit.SECONDS.sleep(60);
//                    }
//                    for (BcTrans bcTrans : bcTransList) {
//                        TransDigestBo transDigestBo = TransBuilder.convert2TransDigestBo(bcTrans);
//                        transDigestQueue.put(transDigestBo);
//                    }
//                } catch (InterruptedException e) {
//                    log.error("交易摘要任务生产者异常", e);
//                }
            }
        });
        thread.start();
    }


}
