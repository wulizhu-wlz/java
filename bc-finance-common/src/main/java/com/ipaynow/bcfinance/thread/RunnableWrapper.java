package com.ipaynow.bcfinance.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author ytw
 * @date 2019/7/5
 * description: 线程池中任务打印的日志带TRACE_ID
 */
public class RunnableWrapper implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(RunnableWrapper.class);

    private Runnable wrapped;

    /**
     * 父线程traceId
     */
    private String traceIdRoot;


    private RunnableWrapper(Runnable wrapped) {
        traceIdRoot = MDC.get("TRACE_ID");
        this.wrapped = wrapped;
    }

    @Override
    public void run() {
        try {
            String traceId = UUID.randomUUID().toString().replace("-", "");
            MDC.put("TRACE_ID", traceId);
            MDC.put("TRACE_ID_ROOT", traceIdRoot);
            logger.debug("RunnableWrapper开始执行");
            wrapped.run();
        } finally {
            MDC.remove("TRACE_ID");
            MDC.remove("TRACE_ID_ROOT");
        }
    }

    public static Runnable wrap(Runnable wrapped) {
        return new RunnableWrapper(wrapped);
    }
}
