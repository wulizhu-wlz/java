package com.ipaynow.bcfinance.settle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ytw
 * @date 2019/11/12
 * description:
 */
@Slf4j
@Component
public class SettleQueue {

//    private BcTrans[] items;

    private Set<Long> processingList;

    private Lock lock = new ReentrantLock();

    private Condition notFull = lock.newCondition();

    private Condition notEmpty = lock.newCondition();

    private int putIndex;

    private int takeIndex;

    private int count;

    public SettleQueue() {
//        int size = 1000;
//        items = new BcTrans[size];
//        processingList = new HashSet<>(size);
    }

//    public BcTrans take() throws InterruptedException {
//        lock.lockInterruptibly();
//        try {
//            while (count == 0) {
//                notEmpty.await();
//            }
//            return dequeue();
//        } finally {
//            lock.unlock();
//        }
//    }

//    private BcTrans dequeue() {
//        BcTrans bcTrans = items[takeIndex];
//        items[takeIndex] = null;
//        if (++takeIndex == items.length) {
//            takeIndex = 0;
//        }
//        count--;
//        return bcTrans;
//    }
//
//    private void enqueue(BcTrans bcTrans) {
//        items[putIndex] = bcTrans;
//        if (++putIndex == items.length) {
//            putIndex = 0;
//        }
//        count++;
//        processingList.add(bcTrans.getId());
//        notEmpty.signal();
//    }
//
//
//    public void put(BcTrans bcTrans) throws InterruptedException {
//        lock.lockInterruptibly();
//        try {
//            while (count == items.length) {
//                notFull.await();
//            }
//            enqueue(bcTrans);
//
//        }finally {
//            lock.unlock();
//        }
//    }
//
//    public void removeProcessingId(Long id) throws InterruptedException {
//        lock.lockInterruptibly();
//        try {
//            processingList.remove(id);
//            if (processingList.size() < items.length / 2) {
//                notFull.signal();
//            }
//        } finally {
//            lock.unlock();
//        }
//    }

}
