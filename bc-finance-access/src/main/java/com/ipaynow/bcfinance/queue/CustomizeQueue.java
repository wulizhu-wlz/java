package com.ipaynow.bcfinance.queue;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Wu
 * @date 2020-03-13 14:09
 */

/**
 * 先进先出队列
 * 队列满了 put阻塞
 * 队列空了 take阻塞
 */
public class CustomizeQueue {

    private Object[] items;
    private Condition notEmpty;
    private Condition notFull;
    private final Lock lock;
    int count, putIndex, takeIndex;

    public CustomizeQueue(int capacity, boolean fair) {
        this.lock = new ReentrantLock(fair);
        this.items = new Object[capacity];
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }


    public void put(Object obj) {
        lock.lock();
        try {
            if (count == items.length) {
                System.out.println("队列已满，等待take,当前长度为:" + count);
                notFull.await();
            }
            items[putIndex] = obj;
            ++putIndex;
            ++count;
            if (putIndex == items.length) {
                putIndex = 0;
            }
            notEmpty.signal();
            System.out.println("put成功，当前长度为:" + count + "，obj:" + obj);
        } catch (Exception e) {
            System.err.println("put操作失败");
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws TimeoutException {
        lock.lock();
        try {
            if (count == 0) {
                System.out.println("队列为空，等待put,队列长度为:" + count);
                notEmpty.await(1, TimeUnit.SECONDS);
            }
            if (count == 0) {
                throw new TimeoutException();
            }
            if (takeIndex == items.length) {
                takeIndex = 0;
            }
            --count;
            Object item = items[takeIndex++];
            notFull.signal();
            return item;
        } catch (TimeoutException e) {
            throw e;
        } catch (Exception e) {
            System.err.println("put操作失败");
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return "err";
    }


    public static void main(String[] args) throws InterruptedException {
        CustomizeQueue queue = new CustomizeQueue(10, false);
        new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.put(Math.random() * 100);
                i++;
                if (i > 20)
                    break;
            }
        }).start();
        Thread.sleep(1000 * 11);
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    Object take = queue.take();
                    System.out.println("take成功 obj:" + take);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    System.out.println("获取数据超时");
                }
            }
        }).start();

        for (; ; ) {
        }
    }

}
