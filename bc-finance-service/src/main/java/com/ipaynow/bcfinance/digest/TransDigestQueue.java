package com.ipaynow.bcfinance.digest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.TimeUnit;

/**
 * @author ytw
 * @date 2019/11/4
 * description:
 */
@Slf4j
@Component
public class TransDigestQueue {

//    //任务池
//    private BlockingQueue<TransDigestBo> blockingQueue = new ArrayBlockingQueue<>(500);
//
//    //正在处理的任务id
//    private ConcurrentSkipListSet<Long> processingIds = new ConcurrentSkipListSet<>();
//
//
//    public TransDigestBo take() throws InterruptedException {
//        return blockingQueue.take();
//    }
//
//    public boolean offer(TransDigestBo transDigestBo, long timeout, TimeUnit timeUnit) throws InterruptedException {
//        processingIds.add(transDigestBo.getId());
//        return blockingQueue.offer(transDigestBo, timeout, timeUnit);
//    }
//
//    public void put(TransDigestBo transDigestBo) throws InterruptedException {
//        processingIds.add(transDigestBo.getId());
//        blockingQueue.put(transDigestBo);
//    }
//
//    public void removeProcessingId(Long id){
//        processingIds.remove(id);
//    }
//
//    public List<Long> getProcessingIds(){
//        return new ArrayList<>(processingIds);
//    }

}
