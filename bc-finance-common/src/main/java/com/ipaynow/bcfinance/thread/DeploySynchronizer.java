package com.ipaynow.bcfinance.thread;

import com.ipaynow.bcfinance.enums.ContractEnum;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ytw
 * @date 2019/7/8
 * description:
 */
public class DeploySynchronizer {


    /**
     * 被依赖合约 ==> CountDownLatch集合
     */
    private Map<ContractEnum, List<CountDownLatch>> countDownLatchMap = new HashMap<>();

    private List<ContractEnum> deployedList = new ArrayList<>();

    private Lock lock = new ReentrantLock();


    public void register(CountDownLatch countDownLatch, ContractEnum... waitContracts) {
        try {
            lock.lock();
            for (ContractEnum contractEnum : waitContracts) {
                if (!countDownLatchMap.containsKey(contractEnum)) {
                    countDownLatchMap.putIfAbsent(contractEnum, new CopyOnWriteArrayList<>());
                }
                //获取contractEnum上的CountDownLatch
                List<CountDownLatch> countDownLatches = countDownLatchMap.get(contractEnum);
                countDownLatches.add(countDownLatch);
                //合约是否已经部署过了
                if (deployedList.contains(contractEnum)) {
                    countDownLatch.countDown();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void deployed(String contractName) {
        ContractEnum contractEnum = ContractEnum.valueOf(contractName);
        try {
            lock.lock();
            deployedList.add(contractEnum);
            List<CountDownLatch> countDownLatches = countDownLatchMap.get(contractEnum);
            if (!CollectionUtils.isEmpty(countDownLatches)) {
                countDownLatches.forEach(CountDownLatch::countDown);
            }
        } finally {
            lock.unlock();
        }
    }

}
