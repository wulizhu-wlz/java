package com.ipaynow.bcfinance.queue;

import lombok.Data;

import java.awt.image.Kernel;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Wu
 * @date 2020-03-21 17:59
 */
public class LRU {
    static Map map = new TreeMap<String, Object>();

    public static void main(String[] args) {
        Map map = new TreeMap();
    }

    @Data
    static class lruKey implements Comparable<lruKey> {
        private String key;
        private String value;
        private int age;//年龄随使用次数增加，最小的最早被淘汰

        @Override
        public int compareTo(lruKey o) {
            return this.age - o.age;
        }
    }
}
