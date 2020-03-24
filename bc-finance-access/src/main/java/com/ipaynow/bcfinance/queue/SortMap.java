package com.ipaynow.bcfinance.queue;

import jnr.ffi.annotations.In;

import java.util.*;

/**
 * @author Wu
 * @date 2020-03-20 11:26
 */
public class SortMap {

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("abc", 1);
        hashMap.put("def", 2);
        hashMap.put("ghi", 3);
        Comparator<Map.Entry<String, Integer>> comparator = (o1, o2) -> o2.getValue() - o1.getValue();
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>((hashMap.entrySet()));
        Collections.sort(list, comparator);
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }
    }
}
