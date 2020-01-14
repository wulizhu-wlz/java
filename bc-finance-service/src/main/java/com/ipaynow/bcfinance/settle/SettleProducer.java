package com.ipaynow.bcfinance.settle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ytw
 * @date 2019/11/12
 * description:
 */
@Slf4j
//@Component
public class SettleProducer implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private SettleQueue settleQueue;
//    @Resource
//    private TransService transService;



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("启动结算信息上链生产者线程...");
        Thread thread = new Thread(() -> {
            while (true) {
//                List<BcTrans> bcTransList = transService.selectSettle2ChainList();
//                log.info("结算信息上链任务生产者, 查询出待上链数据count={}", bcTransList.size());
//                try {
//                    //没有可上链的结算信息，线程休息1分钟
//                    if (bcTransList.size() == 0) {
//                        TimeUnit.SECONDS.sleep(60);
//                    }
//                    for (BcTrans bcTrans : bcTransList) {
//                        settleQueue.put(bcTrans);
//                    }
//                } catch (InterruptedException e) {
//                    log.error("结算信息上链任务生产者异常", e);
//                }
            }
        });
        thread.start();
    }
}
