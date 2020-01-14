package com.ipaynow.bcfinance.settle;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ytw
 * @date 2019/11/12
 * description:
 */
@Slf4j
@Component
public class SettleConsumer implements ApplicationListener<ContextRefreshedEvent> {

    private static final int CONSUMER_TREADS = 30;

    private ExecutorService executorService = Executors.newFixedThreadPool(CONSUMER_TREADS);

    @Resource
    private SettleQueue settleQueue;
//    @Resource
//    private PaymentProxyService paymentProxyService;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("启动结算信息上链消费者线程...");
        for (int i = 0; i < CONSUMER_TREADS; i++) {
            executorService.execute(() -> {
                while (true) {
//                    MDC.put(CommonConstants.TRACE_ID, UUID.randomUUID().toString().replace("-", ""));
//                    BcTrans bcTrans = null;
//                    try {
//                        bcTrans = settleQueue.take();
//                        //paymentProxyService.pay(Date.from(zonedDateTime.toInstant()), Long.parseLong(bcTrans.getAmount()), params);
//                        paymentProxyService.payAsync(bcTrans);
//                    } catch (Exception e) {
//                        log.error("交易摘要消费者处理失败, bcTrans={}", JSON.toJSONString(bcTrans), e);
//                    } finally {
//                        //消费者处理完成
//                        if (bcTrans != null) {
//                            try {
//                                settleQueue.removeProcessingId(bcTrans.getId());
//                            } catch (InterruptedException e) {
//                                log.error("线程中断异常", e);
//                            }
//                        }
//                        MDC.remove(CommonConstants.TRACE_ID);
//                    }
                }

            });
        }
    }


}
